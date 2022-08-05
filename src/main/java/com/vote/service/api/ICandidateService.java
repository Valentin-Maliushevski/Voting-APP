package com.vote.service.api;

import com.vote.core.dto.candidate.CandidateCreateUpdate;
import com.vote.core.dto.candidate.CandidateRead;
import com.vote.core.dto.CustomPage;
import java.util.UUID;
import javax.validation.Valid;

public interface ICandidateService {

  void add(@Valid CandidateCreateUpdate candidateCreateUpdate);

  void update(@Valid CandidateCreateUpdate dto, UUID uuid, Long lastKnowUpdate);

  CustomPage<CandidateRead> getCustomPage(int page, int size);

  CandidateRead getCandidateByUuid(UUID uuid);

}
