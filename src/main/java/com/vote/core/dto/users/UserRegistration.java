package com.vote.core.dto.users;

import javax.validation.constraints.NotBlank;

public class UserRegistration {

  @NotBlank
  private String identificationNumber;

  @NotBlank
  private String passportNumber;

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }
}
