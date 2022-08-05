package com.vote.core.dto.party;

import com.vote.core.dao.entity.CandidateOrPartyStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PartyCreateUpdate {

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotNull
  private CandidateOrPartyStatus status;

  public PartyCreateUpdate() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CandidateOrPartyStatus getStatus() {
    return status;
  }

  public void setStatus(CandidateOrPartyStatus status) {
    this.status = status;
  }
}
