package de.fractiunate.dfjspringbrewery.services;

import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// GPA or Mongo instead of Impl for specialization
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID())
                  .beerName("Vogelbräu").beerStyle("Pale Ale")
                  .build();
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beer) {
    return BeerDto.builder()
                  .id(UUID.randomUUID())
                  .build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDtoV2) {

  }

  @Override
  public void deleteBeerById(UUID beerId) {

  }

}
