package com.dt.ducthuygreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.payload.AuthenticationRequest;
import com.dt.ducthuygreen.payload.AuthenticationResponse;
import com.dt.ducthuygreen.services.AuthService;

import javax.security.auth.login.LoginException;
import java.io.InvalidObjectException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired 
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws LoginException {
        return ResponseEntity.ok(authService.login(authenticationRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestBody AuthenticationResponse authenticationResponse)
            throws InvalidObjectException {
        return ResponseEntity.ok(authService.validateToken(authenticationResponse));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO)
            throws InvalidObjectException {
        return ResponseEntity.ok(authService.register(userDTO));
    }
}