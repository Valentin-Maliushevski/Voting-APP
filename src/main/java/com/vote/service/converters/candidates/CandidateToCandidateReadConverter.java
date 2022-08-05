package com.vote.service.converters.candidates;

import com.vote.core.dao.entity.Candidate;
import com.vote.core.dto.candidate.CandidateRead;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CandidateToCandidateReadConverter implements Converter<Candidate, CandidateRead> {

  @Override
  public CandidateRead convert(Candidate candidate) {
    CandidateRead candidateRead = new CandidateRead();
    candidateRead.setUuid(candidate.getUuid());
    candidateRead.setTitle(candidate.getTitle());
    candidateRead.setDescription(candidate.getDescription());
    candidateRead.setStatus(candidate.getStatus());
    return candidateRead;
  }
}
