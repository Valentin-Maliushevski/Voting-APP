package com.vote.service.converters.parties;

import com.vote.core.dao.entity.Party;
import com.vote.core.dto.party.PartyCreateUpdate;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PartyCreateToPartyConverter implements Converter<PartyCreateUpdate, Party> {

  @Override
  public Party convert(PartyCreateUpdate partyCreate) {
    Party party = new Party();

    party.setUuid(UUID.randomUUID());
    party.setTitle(partyCreate.getTitle());
    party.setDescription(partyCreate.getDescription());
    party.setStatus(partyCreate.getStatus());
    party.setDtCreate(OffsetDateTime.now());
    party.setDtUpdate(party.getDtCreate());

    return party;
  }
}
