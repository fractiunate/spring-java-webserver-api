package de.fractiunate.dfjspringbrewery.web.services;

import de.fractiunate.dfjspringbrewery.web.model.SweetDto;
import java.util.List;
import java.util.UUID;

public interface SweetsService {

  SweetDto getSweetById(UUID uuid);

  SweetDto saveNewSweet(SweetDto sweet);

  void updateSweet(UUID uuid, SweetDto sweet);

  void deleteSweetById(UUID uuid);

  List<SweetDto> getAllSweets();
}
