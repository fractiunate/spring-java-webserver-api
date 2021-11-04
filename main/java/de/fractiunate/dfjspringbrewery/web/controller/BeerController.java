package de.fractiunate.dfjspringbrewery.web.controller;

import de.fractiunate.dfjspringbrewery.services.BeerService;
import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * baseurl for the entire class
 */
@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  private final static String HTTP_LOCATION_PREFIX = "/api/v1/beer/";

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

//  How can i bind multiple DTOs from one request body with multiple properties? --> Jackson (objectmapper)
  @PostMapping
  public ResponseEntity createBeer(@RequestBody BeerDto beer) {
    BeerDto savedDto = beerService.saveNewBeer(beer);

//      Create response entity with the Http Header pointing to that resource location
    HttpHeaders headers = new HttpHeaders();

//      Location => add server host name, endpoint, resource id
//      TODO add host name to url
    headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

//  204 --> by design no content in reponse body
//  PUT == IDEMPOTENT, no changes on multiple calls
  @PutMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handelUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDtoV2) {
    beerService.updateBeer(beerId, beerDtoV2);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("beerId") UUID beerId) {
    beerService.deleteBeerById(beerId);
  }

}