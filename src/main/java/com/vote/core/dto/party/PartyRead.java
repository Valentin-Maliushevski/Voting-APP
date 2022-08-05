package com.vote.core.dto.party;

import java.util.UUID;

public class PartyRead {

  private UUID uuid;

  private String title;

  private String description;

  public PartyRead() {
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
}
