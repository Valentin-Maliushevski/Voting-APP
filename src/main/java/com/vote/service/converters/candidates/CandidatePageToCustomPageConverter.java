package com.vote.service.converters.candidates;

import com.vote.core.dao.entity.Candidate;
import com.vote.core.dto.candidate.CandidateRead;
import com.vote.core.dto.CustomPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CandidatePageToCustomPageConverter implements Converter<Page<Candidate>, CustomPage<CandidateRead>> {

 @Autowired
 CandidateToCandidateReadConverter candidateToCandidateReadConverter;

  @Override
  public CustomPage<CandidateRead> convert(Page<Candidate> page) {
    CustomPage<CandidateRead> newPage = new CustomPage<>();
    List<CandidateRead> candidateContent = new ArrayList<>();

    for(Candidate candidate : page.getContent()) {
      candidateContent.add(candidateToCandidateReadConverter.convert(candidate));
    }

    newPage.setNumber(page.getNumber());
    newPage.setSize(page.getSize());
    newPage.setTotalPages(page.getTotalPages());
    newPage.setTotalElements(page.getTotalElements());
    newPage.setNumberOfElements(page.getNumberOfElements());
    newPage.setFirstPage(page.isFirst());
    newPage.setLastPage(page.isLast());
    newPage.setContent(candidateContent);

    return newPage;
  }
}
