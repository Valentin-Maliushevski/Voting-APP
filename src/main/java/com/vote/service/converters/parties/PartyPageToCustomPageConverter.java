package com.vote.service.converters.parties;

import com.vote.core.dao.entity.Party;
import com.vote.core.dto.CustomPage;
import com.vote.core.dto.party.PartyRead;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PartyPageToCustomPageConverter implements Converter<Page<Party>, CustomPage<PartyRead>> {

  @Autowired
  PartyToPartyReadConverter partyToPartyReadConverter;

  @Override
  public CustomPage<PartyRead> convert(Page<Party> page) {
    CustomPage<PartyRead> newPage = new CustomPage<>();
    List<PartyRead> partyContent = new ArrayList<>();

    for(Party party : page.getContent()) {
      partyContent.add(partyToPartyReadConverter.convert(party));
    }

    newPage.setNumber(page.getNumber());
    newPage.setSize(page.getSize());
    newPage.setTotalPages(page.getTotalPages());
    newPage.setTotalElements(page.getTotalElements());
    newPage.setNumberOfElements(page.getNumberOfElements());
    newPage.setFirstPage(page.isFirst());
    newPage.setLastPage(page.isLast());
    newPage.setContent(partyContent);

    return newPage;
  }
}
