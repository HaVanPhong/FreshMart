package com.dt.ducthuygreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.entities.User;
import com.dt.ducthuygreen.exception.NotFoundException;
import com.dt.ducthuygreen.repos.UserRepository;
import com.dt.ducthuygreen.services.UserService;

@RestController
@RequestMapping("/api/users")
//@SecurityRequirement(name = "Authorization")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUser(){
		
		return ResponseEntity.status(200).body(userService.getAllUsers());
	}
	
//	@PostMapping
//	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
//		
//		
//	}



}
