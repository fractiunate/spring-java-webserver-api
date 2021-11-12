package de.fractiunate.dfjspringbrewery;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fractiunate.dfjspringbrewery.web.controller.BeerController;
import de.fractiunate.dfjspringbrewery.web.model.BeerDto;
import de.fractiunate.dfjspringbrewery.web.services.BeerService;
import java.util.UUID;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTests {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  BeerService beerService;

  BeerDto validBeer;

  @BeforeEach
  public void setUp() {
    validBeer = BeerDto.builder()
                       .beerName("Beer1")
                       .beerStyle("Pale_Ale")
                       .upc(123456870012L)
                       .build();
  }

  @SneakyThrows
  @Test
  public void init_beerDto() {
//
    BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build(); //expceted result
    BeerDto beerDtoV2 = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build(); //expceted result
    String beerDtoJson = objectMapper.writeValueAsString(beerDtoV2);

  }

  @Test
  public void handleUpadte() throws Exception {
//    given

    BeerDto beerDto = validBeer;
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    System.out.println(beerDtoJson);
    //    when
    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
           .andExpect(status().isNoContent());

    then(beerService).should().updateBeer(any(),any());

  }


}
