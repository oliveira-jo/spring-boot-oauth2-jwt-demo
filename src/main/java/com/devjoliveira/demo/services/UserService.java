package com.devjoliveira.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devjoliveira.demo.entities.Role;
import com.devjoliveira.demo.entities.User;
import com.devjoliveira.demo.projections.UserDetailsProjection;
import com.devjoliveira.demo.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {

		List<UserDetailsProjection> response = userRepository.searchUserAndRolesByEmail(email);

		if (response.isEmpty()) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}

		User user = new User();
		user.setEmail(email);
		user.setPassword(response.get(0).getPassword());

		for (UserDetailsProjection projection : response) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}

		return user;

	}

}
