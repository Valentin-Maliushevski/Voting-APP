package com.vote.service.converters.parties;

import com.vote.core.dao.entity.Party;
import com.vote.core.dto.party.PartyCreateUpdate;
import org.springframework.stereotype.Component;

@Component
public class PartyUpdateToPartyConverter {

  public Party convert(PartyCreateUpdate partyUpdate, Party partyFromDB) {

    partyFromDB.setTitle(partyUpdate.getTitle());
    partyFromDB.setDescription(partyUpdate.getDescription());
    partyFromDB.setStatus(partyUpdate.getStatus());

    return partyFromDB;
  }

}
