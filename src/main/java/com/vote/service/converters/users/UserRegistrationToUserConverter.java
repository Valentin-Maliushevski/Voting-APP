package com.vote.service.converters.users;

import com.vote.core.dao.entity.Role;
import com.vote.core.dao.entity.User;
import com.vote.core.dao.entity.UserStatus;
import com.vote.core.dto.users.UserRegistration;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationToUserConverter implements Converter<UserRegistration, User> {

  private final PasswordEncoder encoder;

  public UserRegistrationToUserConverter(PasswordEncoder encoder) {
    this.encoder = encoder;
  }

  @Override
  public User convert(UserRegistration userRegistration) {
    User user = new User();
    user.setUuid(UUID.randomUUID());
    user.setDtCreate(OffsetDateTime.now());
    user.setDtUpdate(user.getDtCreate());
    user.setIdentificationNumber(userRegistration.getIdentificationNumber());
    user.setRoles(Collections.singleton(new Role(1L, "USER")));
    user.setUserStatus(UserStatus.ACTIVATED);
    user.setPassportNumber(encoder.encode(userRegistration.getPassportNumber()));
    user.setCredentialsNonExpired(true);
    user.setAccountNonExpired(true);
    user.setAccountNonLocked(true);
    user.setEnabled(true);

    return user;
  }
}
