package de.fractiunate.dfjspringbrewery;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fractiunate.dfjspringbrewery.services.BeerService;
import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import java.util.UUID;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class BeerControllerTests {

  @Autowired
  ObjectMapper objectMapper;

  @Mock
  BeerService beerService;

  @SneakyThrows
  @Test
  public void init_beerDto(){
//
    BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build(); //expceted result
    BeerDto beerDtoV2 = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build(); //expceted result
    String beerDtoJson = objectMapper.writeValueAsString(beerDtoV2);



  }

}
