package com.techlabs.project.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.project.entity.Role;
import com.techlabs.project.repository.RoleRepository;

@Component
public class StartupInitializer implements CommandLineRunner {

	private final RoleRepository roleRepository;

	public StartupInitializer(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (roleRepository.findByRoleName("USER").isEmpty()) {
			roleRepository.save(new Role("USER"));
		}
		if (roleRepository.findByRoleName("ADMIN").isEmpty()) {
			roleRepository.save(new Role("ADMIN"));
		}
	}
}
