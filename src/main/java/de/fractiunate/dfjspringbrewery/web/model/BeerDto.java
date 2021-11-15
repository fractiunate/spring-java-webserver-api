package de.fractiunate.dfjspringbrewery.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  @Null
  private UUID id;
  @Null
  private long version;
  @Null
  private Timestamp createdDate;
  @Null
  private Timestamp lastModifiedDate;

  @NotBlank
  private String beerName;
  @NotBlank
  private String beerStyle;

  @Positive
  @NotNull
  private Long upc;
  @Positive
  @NotNull
  private BigDecimal price;

  private Integer minOnHand;
  private Integer quantityToBrew;

}
