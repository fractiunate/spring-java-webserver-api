package de.fractiunate.dfjspringbrewery.web.services.v2;

import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerServiceV2 {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beer);

  void updateBeer(UUID beerId, BeerDto beerDtoV2);

  void deleteBeerById(UUID beerId);
}
