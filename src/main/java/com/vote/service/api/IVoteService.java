package com.vote.service.api;

import com.vote.core.dao.entity.Vote;
import com.vote.core.dto.CustomPage;
import com.vote.core.dto.VoteCreate;
import java.util.Map;
import java.util.UUID;

public interface IVoteService {

  void check(VoteCreate voteCreate);

  void add(VoteCreate voteCreate);

  CustomPage<Vote> getCustomPage(int page, int size);

  Vote getVoteByUuid(UUID uuid);

  Map<String, Integer> getCandidateResult();

  Map<String, Integer> getPartyResult();

}
