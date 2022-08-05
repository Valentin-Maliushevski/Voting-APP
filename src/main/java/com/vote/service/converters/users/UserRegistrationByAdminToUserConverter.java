package com.vote.service.converters.users;

import com.vote.core.dao.entity.Role;
import com.vote.core.dao.entity.User;
import com.vote.core.dto.users.UserRegistrationByAdmin;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationByAdminToUserConverter implements Converter<UserRegistrationByAdmin, User> {

  @Autowired
  PasswordEncoder encoder;

  public UserRegistrationByAdminToUserConverter(PasswordEncoder encoder) {
    this.encoder = encoder;
  }

  @Override
  public User convert(UserRegistrationByAdmin userRegistrationByAdmin) {
    Set<Role> roles = new HashSet<>();

      if(userRegistrationByAdmin.getRole().getName().equals("ADMIN")) {
        roles.add(new Role(2L, "ADMIN"));
      }
      if(userRegistrationByAdmin.getRole().getName().equals("USER")) {
        roles.add(new Role(1L, "USER"));
      }

    User user = new User();
    user.setUuid(UUID.randomUUID());
    user.setDtCreate(OffsetDateTime.now());
    user.setDtUpdate(user.getDtCreate());
    user.setIdentificationNumber(userRegistrationByAdmin.getIdentificationNumber());
    user.setRoles(roles);
    user.setUserStatus(userRegistrationByAdmin.getUserStatus());
    user.setPassportNumber(encoder.encode(userRegistrationByAdmin.getPassportNumber()));
    user.setCredentialsNonExpired(true);
    user.setAccountNonExpired(true);
    user.setAccountNonLocked(true);
    user.setEnabled(true);

    return user;
  }
}
