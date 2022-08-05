package com.vote.service.converters.candidates;

import com.vote.core.dao.entity.Candidate;
import com.vote.core.dto.candidate.CandidateCreateUpdate;
import org.springframework.stereotype.Component;

@Component
public class CandidateUpdateToCandidateConverter {

  public Candidate convert(CandidateCreateUpdate candidateCreate, Candidate candidateFromDB) {

    candidateFromDB.setTitle(candidateCreate.getTitle());
    candidateFromDB.setDescription(candidateCreate.getDescription());
    candidateFromDB.setStatus(candidateCreate.getStatus());

    return candidateFromDB;
  }

}
