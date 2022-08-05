package com.vote.service;

import com.vote.core.dao.api.IPartyDao;
import com.vote.core.dao.entity.Party;
import com.vote.core.dto.CustomPage;
import com.vote.core.dto.party.PartyCreateUpdate;
import com.vote.core.dto.party.PartyRead;
import com.vote.service.api.IPartyService;
import com.vote.service.converters.parties.PartyCreateToPartyConverter;
import com.vote.service.converters.parties.PartyPageToCustomPageConverter;
import com.vote.service.converters.parties.PartyToPartyReadConverter;
import com.vote.service.converters.parties.PartyUpdateToPartyConverter;
import java.util.UUID;
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
public class PartyService implements IPartyService {

    @Autowired
    IPartyDao partyDao;
    @Autowired
    PartyPageToCustomPageConverter partyPageToCustomPageConverter;
    @Autowired
    PartyToPartyReadConverter partyToPartyReadConverter;
    @Autowired
    PartyCreateToPartyConverter partyCreateToPartyConverter;
    @Autowired
    PartyUpdateToPartyConverter partyUpdateToPartyConverter;
    @Autowired
    UserHolder holder;

    @Override
    public void add(PartyCreateUpdate partyCreateUpdate) {
        partyDao.save(partyCreateToPartyConverter.convert(partyCreateUpdate));
    }

    @Override
    public void update(PartyCreateUpdate dto, UUID uuid, Long lastKnowUpdate) {
        Party party = partyDao.findByUuid(uuid);

        if(party == null) {
            throw new IllegalArgumentException("Party with such uuid is not found");
        }

        Long update = party.getDtUpdate().toInstant().toEpochMilli();

        if(!update.equals(lastKnowUpdate) ) {
            throw new IllegalArgumentException("Update time is not valid");
        }

        if(holder.hasRoleAdmin()) {
            partyDao.save(partyUpdateToPartyConverter.convert(dto, party));
        } else {
            throw new IllegalArgumentException("User is not Admin");
        }
    }

    @Override
    public CustomPage<PartyRead> getCustomPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title"));
        Page page1 = partyDao.findAll(pageable);
        return partyPageToCustomPageConverter.convert(page1);
    }

    @Override
    public PartyRead getPartyByUuid(UUID uuid) {
        Party party = partyDao.findByUuid(uuid);
        if(party == null) {
            throw new IllegalArgumentException("Party with such uuid is not found");
        }
        return partyToPartyReadConverter.convert(party);
    }
}
