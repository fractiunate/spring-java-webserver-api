package de.fractiunate.dfjspringbrewery.services;

import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerService {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beer);

  void updateBeer(UUID beerId, BeerDto beerDtoV2);

  void deleteBeerById(UUID beerId);
}
