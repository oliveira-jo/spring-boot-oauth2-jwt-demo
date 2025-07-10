package com.devjoliveira.demo.projections;

public interface UserDetailsProjection {
  String getUsername();

  String getPassword();

  Long getRoleId();

  String getAuthority();
}
