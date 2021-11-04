package de.fractiunate.dfjspringbrewery.web.model;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SweetDto {

  private UUID uuid;
  private String sweetName;
  private List<String> ingredients;
  private String createdBy;


}
