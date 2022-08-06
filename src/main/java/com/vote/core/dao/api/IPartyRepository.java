package com.vote.core.dao.api;

import com.vote.core.dao.entity.CandidateOrPartyStatus;
import com.vote.core.dao.entity.Party;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartyRepository extends JpaRepository<Party, UUID> {

  Party findByUuid(UUID uuid);

  Party findByUuidAndStatus(UUID uuid, CandidateOrPartyStatus status);

}
