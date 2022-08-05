package com.vote.service.api;

import com.vote.core.dto.users.UserRegistration;
import javax.validation.Valid;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

  void add(@Valid UserRegistration userRegistration);

}
