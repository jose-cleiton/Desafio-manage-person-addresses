package com.api.managepersonaddresses.dtos;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {
  private Long id;


    @NotBlank
    private boolean main;

    @NotBlank
    private String publicPlace;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String number;

    @NotBlank
    private String city;


    private Long personId;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isMain() {
    return this.main;
  }

  public boolean getMain() {
    return this.main;
  }

  public void setMain(boolean main) {
    this.main = main;
  }

  public String getPublicPlace() {
    return this.publicPlace;
  }

  public void setPublicPlace(String publicPlace) {
    this.publicPlace = publicPlace;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Long getPersonId() {
    return this.personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }
   

    
}