package com.vote.service;

import com.vote.core.dao.api.IRoleRepository;
import com.vote.core.dao.api.IUserRepository;
import com.vote.core.dto.users.UserRegistration;
import com.vote.service.api.IUserService;
import com.vote.service.converters.users.UserRegistrationToUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Transactional(readOnly = true)
public class UserService implements IUserService {

  @Autowired
  IUserRepository repository;
  @Autowired
  UserRegistrationToUserConverter userRegistrationToUserConverter;

  @Override
  @Transactional
  public void add(UserRegistration userRegistration) {
    repository.save(userRegistrationToUserConverter.convert(userRegistration));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDetails user = repository.findByIdentificationNumber(username);

    if (user == null) {
      throw new UsernameNotFoundException("User with such mail is not found");
    }
    return user;
  }
}
