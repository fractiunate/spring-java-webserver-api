package de.fractiunate.dfjspringbrewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude= {})
@Configuration
@EnableAutoConfiguration

public class DfJspringBreweryApplication {

  public static void main(String[] args) {
    SpringApplication.run(DfJspringBreweryApplication.class, args);
  }

}
