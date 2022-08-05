package com.vote.service.converters.candidates;

import com.vote.core.dao.entity.Candidate;
import com.vote.core.dto.candidate.CandidateCreateUpdate;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CandidateCreateToCandidateConverter implements Converter<CandidateCreateUpdate, Candidate> {

  @Override
  public Candidate convert(CandidateCreateUpdate candidateCreate) {
    Candidate candidate = new Candidate();

    candidate.setUuid(UUID.randomUUID());
    candidate.setTitle(candidateCreate.getTitle());
    candidate.setDescription(candidateCreate.getDescription());
    candidate.setStatus(candidateCreate.getStatus());
    candidate.setDtCreate(OffsetDateTime.now());
    candidate.setDtUpdate(candidate.getDtCreate());

    return candidate;
  }
}
