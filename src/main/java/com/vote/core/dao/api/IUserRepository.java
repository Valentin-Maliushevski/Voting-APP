package com.vote.core.dao.api;

import com.vote.core.dao.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

  User findByIdentificationNumber(String identificationNumber);

  User findByUuid(UUID uuid);

}
