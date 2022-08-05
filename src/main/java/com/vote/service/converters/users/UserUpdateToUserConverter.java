package com.vote.service.converters.users;

import com.vote.core.dao.entity.Role;
import com.vote.core.dao.entity.User;
import com.vote.core.dto.users.UserRegistrationByAdmin;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateToUserConverter {

  @Autowired
  PasswordEncoder encoder;

  public User convert(UserRegistrationByAdmin userRegistrationByAdmin, User userFromDB) {
    Set<Role> roles = new HashSet<>();
      if(userRegistrationByAdmin.getRole().getName().equalsIgnoreCase("ADMIN")) {
        roles.add(new Role(2L, "ADMIN"));
      }
      if(userRegistrationByAdmin.getRole().getName().equalsIgnoreCase("USER")) {
        roles.add(new Role(1L, "USER"));
      }
    userFromDB.setRoles(roles);
    userFromDB.setUserStatus(userRegistrationByAdmin.getUserStatus());
    userFromDB.setPassportNumber(encoder.encode(userRegistrationByAdmin.getPassportNumber()));

    return userFromDB;
  }

}
