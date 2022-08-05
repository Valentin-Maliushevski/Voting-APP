package com.vote.service.converters.votes;

import com.vote.core.dao.entity.Vote;
import com.vote.core.dto.VoteCreate;
import com.vote.service.UserHolder;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VoteCreateToVoteConverter implements Converter<VoteCreate, Vote> {

  @Autowired
  UserHolder holder;

  @Override
  public Vote convert(VoteCreate voteCreate) {
    Vote vote = new Vote();

    vote.setUuid(holder.getUser().getUuid());
    vote.setDtCreate(LocalDateTime.now());
    vote.setCandidateUuid(voteCreate.getCandidate());
    vote.setPartyUuid(voteCreate.getParty());

    return vote;
  }
}
