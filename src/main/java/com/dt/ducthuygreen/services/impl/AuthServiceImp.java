package com.dt.ducthuygreen.services.impl;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.Utils.ConvertObject;
import com.dt.ducthuygreen.Utils.JwtUtil;
import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.entities.Role;
import com.dt.ducthuygreen.entities.User;
import com.dt.ducthuygreen.exception.DuplicateException;
import com.dt.ducthuygreen.payload.AuthenticationRequest;
import com.dt.ducthuygreen.payload.AuthenticationResponse;
import com.dt.ducthuygreen.services.AuthService;
import com.dt.ducthuygreen.services.IRoleService;
import com.dt.ducthuygreen.services.MyUserDetailService;
import com.dt.ducthuygreen.services.UserService;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired private JwtUtil jwtUtil;

    @Autowired private MyUserDetailService myUserDetailsService;

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired private UserService userService;
    
    @Autowired private PasswordEncoder passwordEncoder;
    
    @Autowired private IRoleService roleService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) throws LoginException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
            ));
        }catch (BadCredentialsException e) {
            throw new LoginException("Incorrect username or password");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User user = userService.findByUsername(request.getUsername());
        
        List<String> roles = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if(roleSet.size() > 0) {
            roleSet.forEach(item -> roles.add(item.getRoleName()));
        }

        return new AuthenticationResponse(jwt, user.getId(), user.getUsername(), roles);
    }

    @Override
    public Boolean validateToken(AuthenticationResponse authenticationResponse) throws InvalidObjectException {
        try {
            String jwt = authenticationResponse.getJwt();
            String username = jwtUtil.extractUsername(jwt);
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

            return jwtUtil.validateToken(jwt, userDetails);
        } catch (Exception e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

	@Override
	public AuthenticationResponse register(UserDTO userDTO) throws InvalidObjectException {
		User oldUser = userService.findByUsername(userDTO.getUsername());
		if(oldUser != null) {
            throw new DuplicateException("Username has already exists");
        }
        User user = new User();
        user = ConvertObject.convertUserDTOToUser(user, userDTO);
        if(user == null) {
            throw new InvalidObjectException("Invalid user");
        }
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Role role = roleService.getRoleByName("ROLE_MEMBER");
        user.setRoles(Set.of(role));

        User newUser = userService.save(user);
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(newUser.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        
        return new AuthenticationResponse(jwt, newUser.getId(), newUser.getUsername(), List.of(role.getRoleName()));
	}
    
    
}
