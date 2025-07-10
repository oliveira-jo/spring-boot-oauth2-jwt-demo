package com.devjoliveira.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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

  /*
   * This implementation of loadUserByUsername resolves the problem of leazy
   * loading of jpa
   */
  @Override
  public UserDetails loadUserByUsername(String username) {

    List<UserDetailsProjection> userDetails = userRepository.searchUserAndRolesByEmail(username);

    if (userDetails == null) {
      throw new UsernameNotFoundException("User not found with email: " + username);
    }

    User user = new User();
    user.setEmail(username);
    user.setPassword(userDetails.get(0).getPassword());
    for (UserDetailsProjection projection : userDetails) {
      user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
    }

    return user;

  }

  // Other methods can be added as needed for user management

}
