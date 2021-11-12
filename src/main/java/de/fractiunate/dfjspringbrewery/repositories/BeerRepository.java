package de.fractiunate.dfjspringbrewery.repositories;

import de.fractiunate.dfjspringbrewery.domain.Beer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
