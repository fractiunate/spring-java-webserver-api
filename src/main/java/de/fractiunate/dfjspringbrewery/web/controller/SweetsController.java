package de.fractiunate.dfjspringbrewery.web.controller;

import de.fractiunate.dfjspringbrewery.services.SweetsService;
import de.fractiunate.dfjspringbrewery.web.model.SweetDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/sweets/")
@RestController
public class SweetsController {
  private final SweetsService sweetsService;

  public SweetsController(SweetsService sweetsService) {
    this.sweetsService = sweetsService;
  }


  @GetMapping({"/list"})
  public ResponseEntity<List<SweetDto>> getAllSweets() {
    return new ResponseEntity<>(sweetsService.getAllSweets(), HttpStatus.OK);
  }

}
