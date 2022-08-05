package com.vote.core.dto.candidate;

import com.vote.core.dao.entity.CandidateOrPartyStatus;
import java.util.UUID;

public class CandidateRead {

  private UUID uuid;

  private String title;

  private String description;

  private CandidateOrPartyStatus status;

  public CandidateRead() {
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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
