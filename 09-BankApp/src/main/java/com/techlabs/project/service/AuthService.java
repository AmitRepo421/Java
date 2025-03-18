package com.techlabs.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlabs.project.dto.AddCustomerRequest;
import com.techlabs.project.dto.AuthRequest;
import com.techlabs.project.dto.AuthResponse;
import com.techlabs.project.dto.SignupRequest;
import com.techlabs.project.entity.Role;
import com.techlabs.project.entity.User;
import com.techlabs.project.repository.RoleRepository;
import com.techlabs.project.repository.UserRepository;
import com.techlabs.project.security.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public void register(SignupRequest request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email is already registered.");
		}

		Role userRole =null;
		
		if(request.getRole().equalsIgnoreCase("ROLE_CUSTOMER"))
		userRole = roleRepository.findByRoleName("ROLE_CUSTOMER")
				.orElseThrow(() -> new RuntimeException("Role not found"));
		if(request.getRole().equalsIgnoreCase("ROLE_ADMIN"))
			userRole = roleRepository.findByRoleName("ROLE_ADMIN")
					.orElseThrow(() -> new RuntimeException("Admin not found"));

		System.out.println(userRole.getRoleName());
		User user = new User();
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setRole(userRole);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
	}

	public AuthResponse login(AuthRequest authRequest) {

		// System.out.println(authRequest.getEmail());

		Optional<User> dbUser = userRepository.findByEmail(authRequest.getEmail());
		// System.out.println(dbUser.get());

//		User user = userRepository.findByEmail(authRequest.getEmail())
//				.orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

		User user = dbUser.get();
		// System.out.println(user.getEmail());
		// System.out.println(user.getPassword());
		if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
			throw new BadCredentialsException("Invalid email or password");
		}

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

		String token = jwtUtil.generateToken(user.getEmail());

		return new AuthResponse(token);
	}
}
