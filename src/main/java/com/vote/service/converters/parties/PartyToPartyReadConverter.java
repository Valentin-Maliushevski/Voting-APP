package com.vote.service.converters.parties;

import com.vote.core.dao.entity.Party;
import com.vote.core.dto.party.PartyRead;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PartyToPartyReadConverter implements Converter<Party, PartyRead> {

  @Override
  public PartyRead convert(Party party) {
    PartyRead partyRead = new PartyRead();
    partyRead.setUuid(party.getUuid());
    partyRead.setTitle(party.getTitle());
    partyRead.setDescription(party.getDescription());

    return partyRead;
  }
}
