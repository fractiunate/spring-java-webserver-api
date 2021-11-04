package de.fractiunate.dfjspringbrewery.services;

import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import de.fractiunate.dfjspringbrewery.web.model.CustomerDto;
import de.fractiunate.dfjspringbrewery.web.model.SweetDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SweetsServiceImpl implements SweetsService {
  private final List<SweetDto> sweets = new ArrayList<SweetDto>(Arrays.asList(
    SweetDto.builder().sweetName("Zimtschnegge").createdBy("Betty").ingredients(List.of("Cinnamon")).build(),
    new SweetDto(UUID.fromString("f8e03ae2-9b72-47e2-98d2-4a6a2470da45"), "Donut", List.of("Fett"),"Nika")
  ));

//
//      new CustomerDto(UUID.fromString("f8e03ae2-9b72-47e2-98d2-4a6a2470da45"), "Donut"),
//      new CustomerDto(UUID.randomUUID(), "Zimtschnegge"),
//      new CustomerDto(UUID.randomUUID(), "Apfel-Zimtschnecke"),
//      new CustomerDto(UUID.randomUUID(), "Mama Simone"),
//      new CustomerDto(UUID.randomUUID(), "Jonas Bro")

  @Override
  public SweetDto getSweetById(UUID uuid) {
    return null;
  }

  @Override
  public SweetDto saveNewSweet(SweetDto sweet) {
    return null;
  }

  @Override
  public void updateSweet(UUID uuid, SweetDto sweet) {

  }

  @Override
  public void deleteSweetById(UUID uuid) {

  }

  @Override
  public List<SweetDto> getAllSweets() {
    return (sweets == null || sweets.isEmpty()) ? Collections.emptyList() : sweets;
  }
}
