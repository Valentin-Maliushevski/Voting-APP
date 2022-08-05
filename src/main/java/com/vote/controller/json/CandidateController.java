package com.vote.controller.json;

import com.vote.core.dto.candidate.CandidateCreateUpdate;
import com.vote.core.dto.candidate.CandidateRead;
import com.vote.core.dto.CustomPage;
import com.vote.service.api.ICandidateService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  ICandidateService candidateService;

  @GetMapping("/page")
  public ResponseEntity<CustomPage<CandidateRead>> findPaginated(@RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "3") int size) {
    return new ResponseEntity<>(candidateService.getCustomPage(page, size), HttpStatus.OK);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<CandidateRead> getByUuid(@PathVariable UUID uuid) {
    return new ResponseEntity<>(candidateService.getCandidateByUuid(uuid), HttpStatus.OK);
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody CandidateCreateUpdate dto) {
    candidateService.add(dto);
  }

  @PutMapping("/{uuid}/dt_update/{dt_update}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody CandidateCreateUpdate dto, @PathVariable UUID uuid,  @PathVariable Long dt_update) {
    candidateService.update(dto, uuid, dt_update);
  }

}
