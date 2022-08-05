package com.vote.core.dao.api;

import com.vote.core.dao.entity.Vote;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IVoteDao extends JpaRepository<Vote, UUID> {

  @Query(value = "SELECT COUNT(*) FROM votes WHERE candidate_uuid = :uuid",
      nativeQuery = true)
  int getCountOfCandidate( @Param("uuid") UUID candidateUuid);

  @Query(value = "SELECT COUNT(*) FROM votes WHERE party_uuid = :uuid",
      nativeQuery = true)
  int getCountOfParty( @Param("uuid") UUID partyUuid);

  Vote findByUserUuid(UUID uuid);

  Vote findByUuid(UUID uuid);
}
