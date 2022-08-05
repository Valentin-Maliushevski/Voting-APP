package com.vote.service;

import com.vote.core.dao.api.ICandidateDao;
import com.vote.core.dao.entity.Candidate;
import com.vote.core.dto.candidate.CandidateCreateUpdate;
import com.vote.core.dto.candidate.CandidateRead;
import com.vote.core.dto.CustomPage;
import com.vote.service.api.ICandidateService;
import com.vote.service.converters.candidates.CandidateCreateToCandidateConverter;
import com.vote.service.converters.candidates.CandidateToCandidateReadConverter;
import com.vote.service.converters.candidates.CandidatePageToCustomPageConverter;
import com.vote.service.converters.candidates.CandidateUpdateToCandidateConverter;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Transactional(readOnly = true)
public class CandidateService implements ICandidateService {

    @Autowired
    ICandidateDao candidateDao;
    @Autowired
    CandidatePageToCustomPageConverter pageToCustomPageConverter;
    @Autowired
    CandidateToCandidateReadConverter candidateToCandidateReadConverter;
    @Autowired
    CandidateCreateToCandidateConverter candidateCreateToCandidateConverter;
    @Autowired
    CandidateUpdateToCandidateConverter candidateUpdateToCandidateConverter;
    @Autowired
    UserHolder holder;

    @Override
    public void add(@Valid CandidateCreateUpdate candidateCreate) {
        candidateDao.save(candidateCreateToCandidateConverter.convert(candidateCreate));
    }

    @Override
    public void update(@Valid CandidateCreateUpdate dto, UUID uuid, Long lastKnowUpdate) {
        Candidate candidate = candidateDao.findByUuid(uuid);

        if(candidate == null) {
            throw new IllegalArgumentException("Candidate with such uuid is not found");
        }

        Long update = candidate.getDtUpdate().toInstant().toEpochMilli();

        if(!update.equals(lastKnowUpdate) ) {
            throw new IllegalArgumentException("Update time is not valid");
        }

        if(holder.hasRoleAdmin()) {
            candidateDao.save(candidateUpdateToCandidateConverter.convert(dto, candidate));
        } else {
            throw new IllegalArgumentException("User is not Admin");
        }
    }

    @Override
    public CustomPage<CandidateRead> getCustomPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title"));
        Page page1 = candidateDao.findAll(pageable);
        return pageToCustomPageConverter.convert(page1);
    }

    @Override
    public CandidateRead getCandidateByUuid(UUID uuid) {
        Candidate candidate = candidateDao.findByUuid(uuid);
        if(candidate == null) {
            throw new IllegalArgumentException("Candidate with such uuid is not found");
        }
        return candidateToCandidateReadConverter.convert(candidate);
    }
}
