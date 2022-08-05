package com.vote.core.dto.users;

import com.vote.core.dao.entity.Role;
import com.vote.core.dao.entity.UserStatus;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRegistrationByAdmin {

  @NotBlank
  private String identificationNumber;

  @Transient
  private Role role;

  @NotNull
  private UserStatus userStatus;

  @NotBlank
  private String passportNumber;

  public UserRegistrationByAdmin() {
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public UserStatus getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatus userStatus) {
    this.userStatus = userStatus;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }
}
