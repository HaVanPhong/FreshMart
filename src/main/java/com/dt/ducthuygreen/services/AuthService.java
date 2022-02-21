package com.dt.ducthuygreen.services;

import java.io.InvalidObjectException;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.payload.AuthenticationRequest;
import com.dt.ducthuygreen.payload.AuthenticationResponse;

public interface AuthService {
	AuthenticationResponse login(AuthenticationRequest request) throws LoginException;
	AuthenticationResponse register(UserDTO userDTO) throws InvalidObjectException;
    Boolean validateToken(AuthenticationResponse authenticationResponse) throws InvalidObjectException;
}
