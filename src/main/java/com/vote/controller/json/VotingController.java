package com.vote.controller.json;

import com.vote.core.dao.entity.Vote;
import com.vote.core.dto.CustomPage;
import com.vote.core.dto.VoteCreate;
import com.vote.service.api.IVoteService;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VotingController {

  @Autowired
  IVoteService voteService;

  @GetMapping("/page")
  public ResponseEntity<CustomPage<Vote>> findPaginated1(@RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size) {
    return new ResponseEntity<>(voteService.getCustomPage(page, size), HttpStatus.OK);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<Vote> getByUuid(@PathVariable UUID uuid) {
    return new ResponseEntity<>(voteService.getVoteByUuid(uuid), HttpStatus.OK);
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody VoteCreate dto) {
    voteService.add(dto);
  }

  @GetMapping("/candidate/result")
  public ResponseEntity<Map<String, Integer>>  getCandidateResult() {
    return new ResponseEntity<>(voteService.getCandidateResult(), HttpStatus.OK);
  }

  @GetMapping("/party/result")
  public ResponseEntity<Map<String, Integer>>  getPartyResult() {
    return new ResponseEntity<>(voteService.getPartyResult(), HttpStatus.OK);
  }

}
