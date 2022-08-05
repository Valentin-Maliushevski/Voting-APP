package com.vote.service.exception;

public class ErrorDefinition {

  private final String logref = "error";
  private String message;

  public ErrorDefinition(String message) {
    this.message = message;
  }

  public String getLogref() {
    return logref;
  }

  public String getMessage() {
    return message;
  }

}
