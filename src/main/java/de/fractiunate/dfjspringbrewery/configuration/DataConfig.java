package de.fractiunate.dfjspringbrewery.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"de.fractiunate.dfjspringbrewery.*"})
@EntityScan(basePackages = "de.fractiunate.dfjspringbrewery.domain")
@EnableJpaRepositories({"de.fractiunate.dfjspringbrewery.repositories"})
public class DataConfig {

}
