package com.edzamo.rest.webservice.restfullwebservice.domain.model;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;
  private String name;
  private LocalDate birthDate;

}
