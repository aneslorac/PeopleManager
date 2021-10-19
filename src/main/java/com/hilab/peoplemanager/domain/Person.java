package com.hilab.peoplemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("people")
public class Person {
  @Id
  private String id;

  @NotNull(message = "Status is required")
  private Status status;

  @NotNull(message = "givenName is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "givenName must be a string")
  private String givenName;

  @NotNull(message = "familyName is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "familyName must be a string")
  private String familyName;

  @DateTimeFormat
  private String birthDate;

  @NotNull(message = "address is required")
  private Address address;

  private List<String> numbers;
}
