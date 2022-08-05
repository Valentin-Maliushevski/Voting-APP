package com.vote.core.dao.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "voice", schema = "voices")
public class Vote {

  @Id
  private UUID uuid;

  @Column(name = "user_uuid")
  private UUID userUuid;

  @Column(name = "candidate_uuid")
  private UUID candidateUuid;

  @Column(name = "party_uuid")
  private UUID partyUuid;

  @Column(name = "dt_create")
  private LocalDateTime dtCreate;

  public Vote() {
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public LocalDateTime getDtCreate() {
    return dtCreate;
  }

  public void setDtCreate(LocalDateTime dtCreate) {
    this.dtCreate = dtCreate;
  }

  public UUID getCandidateUuid() {
    return candidateUuid;
  }

  public void setCandidateUuid(UUID candidateUuid) {
    this.candidateUuid = candidateUuid;
  }

  public UUID getPartyUuid() {
    return partyUuid;
  }

  public void setPartyUuid(UUID partyUuid) {
    this.partyUuid = partyUuid;
  }

  public UUID getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(UUID userUuid) {
    this.userUuid = userUuid;
  }
}
