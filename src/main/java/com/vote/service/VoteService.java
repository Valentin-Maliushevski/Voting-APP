package com.vote.service;

import com.vote.core.dao.api.ICandidateDao;
import com.vote.core.dao.api.IPartyDao;
import com.vote.core.dao.api.IVoteDao;
import com.vote.core.dao.entity.Candidate;
import com.vote.core.dao.entity.CandidateOrPartyStatus;
import com.vote.core.dao.entity.Party;
import com.vote.core.dao.entity.Vote;
import com.vote.core.dto.CustomPage;
import com.vote.core.dto.VoteCreate;
import com.vote.service.api.IVoteService;
import com.vote.service.converters.votes.VoteCreateToVoteConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VoteService implements IVoteService {

  @Autowired
  IVoteDao voteDao;
  @Autowired
  ICandidateDao candidateDao;
  @Autowired
  IPartyDao partyDao;
  @Autowired
  UserHolder holder;
  @Autowired
  VoteCreateToVoteConverter voteCreateToVoteConverter;

  @Override
  public void check(VoteCreate voteCreate) {
    if(voteDao.findByUserUuid(holder.getUser().getUuid()) != null) {
      throw new IllegalArgumentException("User has already voted");
    }
    if(candidateDao.findByUuidAndStatus(voteCreate.getCandidate(), CandidateOrPartyStatus.ACTIVE) == null) {
      throw new IllegalArgumentException("Candidate is not found or not active");
    }
    if(partyDao.findByUuidAndStatus(voteCreate.getParty(), CandidateOrPartyStatus.ACTIVE) == null) {
      throw new IllegalArgumentException("Party is not found or not active");
    }
  }

  @Override
  public void add(VoteCreate voteCreate) {
    check(voteCreate);
    voteDao.save(voteCreateToVoteConverter.convert(voteCreate));
  }

  @Override
  public CustomPage<Vote> getCustomPage(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page page1 = partyDao.findAll(pageable);

    CustomPage<Vote> newPage = new CustomPage<>();
    newPage.setNumber(page1.getNumber());
    newPage.setSize(page1.getSize());
    newPage.setTotalPages(page1.getTotalPages());
    newPage.setTotalElements(page1.getTotalElements());
    newPage.setNumberOfElements(page1.getNumberOfElements());
    newPage.setFirstPage(page1.isFirst());
    newPage.setLastPage(page1.isLast());
    newPage.setContent(page1.getContent());

    return newPage;
  }

  @Override
  public Vote getVoteByUuid(UUID uuid) {
    Vote vote = voteDao.findByUuid(uuid);
    if(vote == null) {
      throw new IllegalArgumentException("Vote with such uuid is not found");
    }
    return vote;
  }

  @Override
  public Map<String, Integer> getCandidateResult() {
    Map<String, Integer> candidateResult = new HashMap<>();

    for(Candidate candidate : candidateDao.findAll()) {
      int result = voteDao.getCountOfCandidate(candidate.getUuid());
      candidateResult.put(candidate.getTitle(), result);
    }
    return candidateResult;
  }

  @Override
  public Map<String, Integer> getPartyResult() {
    Map<String, Integer> partyResult = new HashMap<>();

    for(Party party : partyDao.findAll()) {
      int result = voteDao.getCountOfParty(party.getUuid());
      partyResult.put(party.getTitle(), result);
    }
    return partyResult;
  }
}
