package com.techlabs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.project.dto.AuthRequest;
import com.techlabs.project.dto.AuthResponse;
import com.techlabs.project.dto.SignupRequest;
import com.techlabs.project.entity.Role;
import com.techlabs.project.entity.User;
import com.techlabs.project.repository.RoleRepository;
import com.techlabs.project.repository.UserRepository;
import com.techlabs.project.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/auth/signup")
	public ResponseEntity<String> registerUser(@RequestBody SignupRequest request) {
		// Fetch ROLE_USER from database
		authService.register(request);
		return ResponseEntity.ok("User registered successfully!");
	}

	@PostMapping("/auth/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
		AuthResponse response = authService.login(request);
		return ResponseEntity.ok(response);
	}
}