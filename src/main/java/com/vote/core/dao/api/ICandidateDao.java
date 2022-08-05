package com.vote.core.dao.api;

import com.vote.core.dao.entity.Candidate;;
import com.vote.core.dao.entity.CandidateOrPartyStatus;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidateDao extends JpaRepository<Candidate, Long> {

  Candidate findByUuid(UUID uuid);

  Candidate findByUuidAndStatus(UUID uuid, CandidateOrPartyStatus status);

}
