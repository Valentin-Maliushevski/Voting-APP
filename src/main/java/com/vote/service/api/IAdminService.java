package com.vote.service.api;

import com.vote.core.dto.CustomPage;
import com.vote.core.dto.users.UserRegistrationByAdmin;
import com.vote.core.dto.users.UserWithoutPassword;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAdminService extends UserDetailsService {

  void add(@Valid UserRegistrationByAdmin userCreationByAdmin);

  void update(@Valid UserRegistrationByAdmin dto, UUID uuid, Long lastKnowUpdate);

  CustomPage<UserWithoutPassword> getCustomPage(int page, int size);

  UserWithoutPassword getUserByUuid(UUID uuid);

}
