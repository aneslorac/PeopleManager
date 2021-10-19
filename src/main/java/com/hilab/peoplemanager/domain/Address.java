package com.hilab.peoplemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @NotNull(message = "type is required")
  private AddressType type;

  @NotNull(message = "zipcode is required")
  @Pattern(regexp="^\\d{5}-\\d{3}$", message = "must be a string")
  private String zipCode;

  @NotNull(message = "state is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "must be a string")
  private String state;

  @NotNull(message = "city is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "must be a string")
  private String city;

  @NotNull(message = "street is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "must be a string")
  private String street;

  @NotNull(message = "number is required")
  @Pattern(regexp="^[0-9]+$", message = "must contain only integers")
  private String number;

  private String complement;

  @NotNull(message = "district is required")
  @Pattern(regexp="^[a-zA-Z ]+$", message = "must be a string")
  private String district;
}
