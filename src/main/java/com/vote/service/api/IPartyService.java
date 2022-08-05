package com.vote.service.api;

import com.vote.core.dto.CustomPage;
import com.vote.core.dto.party.PartyCreateUpdate;
import com.vote.core.dto.party.PartyRead;
import java.util.UUID;
import javax.validation.Valid;

public interface IPartyService {

  void add(@Valid PartyCreateUpdate partyCreateUpdate);

  void update(@Valid PartyCreateUpdate dto, UUID uuid, Long lastKnowUpdate);

  CustomPage<PartyRead> getCustomPage(int page, int size);

  PartyRead getPartyByUuid(UUID uuid);

}
