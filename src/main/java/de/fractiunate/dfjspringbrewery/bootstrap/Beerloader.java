package de.fractiunate.dfjspringbrewery.bootstrap;

import de.fractiunate.dfjspringbrewery.domain.Beer;
import de.fractiunate.dfjspringbrewery.repositories.BeerRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Beerloader implements CommandLineRunner {

  private final BeerRepository beerRepository;

  public Beerloader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() == 0) {
      beerRepository.save(Beer.builder()
                              .beerName("Mango Bobs")
                              .beerStyle("IPA")
                              .quantityToBrew(200)
                              .upc(337010000001L)
                              .minOnHand(1)
                              .price(new BigDecimal(12.95))
                              .build());

      beerRepository.save(Beer.builder()
                              .beerName("Mahrs Brau")
                              .beerStyle("Ungespundet")
                              .quantityToBrew(300)
                              .upc(337010000002L)
                              .minOnHand(1)
                              .price(new BigDecimal(14.99))
                              .build());

      System.out.println("loaded Beers: " +beerRepository.count());
    }
  }
}
