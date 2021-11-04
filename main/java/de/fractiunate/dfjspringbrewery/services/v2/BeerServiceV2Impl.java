package de.fractiunate.dfjspringbrewery.services.v2;

import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class BeerServiceV2Impl implements BeerServiceV2 {

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
