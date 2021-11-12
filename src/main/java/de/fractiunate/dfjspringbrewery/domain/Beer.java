package de.fractiunate.dfjspringbrewery.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by jt on 2019-05-25.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
  private UUID id;

  @Version
  private long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdDate;
  @LastModifiedDate
  private Timestamp lastModifiedDate;
  private String beerName;
  private String beerStyle;

  @Column(unique = true)
  private Long upc;
  private BigDecimal price;
  private Integer minOnHand;
  private Integer quantityToBrew;

}
