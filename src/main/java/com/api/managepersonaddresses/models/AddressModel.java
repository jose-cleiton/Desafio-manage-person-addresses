package com.api.managepersonaddresses.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressModel_SEQ")
    @SequenceGenerator(sequenceName = "AddressModel_SEQ", allocationSize = 1, name = "AddressModel_SEQ")
    private Integer id;

    private String city;
    private boolean main;
    private String number;
    private String publicPlace;
    private String zipCode;

    @ManyToOne
    private PersonModel person;


  public AddressModel(Integer id, String city, boolean main, String number, String publicPlace, String zipCode, PersonModel person) {
    this.id = id;
    this.city = city;
    this.main = main;
    this.number = number;
    this.publicPlace = publicPlace;
    this.zipCode = zipCode;
    this.person = person;
  }
  

    public AddressModel(String string, String city2, String string2, String number2, String publicPlace2, String zipCode2,
      String string3) {
  }


    public AddressModel() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMain() {
        return main;
    }

  public boolean getMain() {
    return this.main;
  }

  public void setMain(boolean main) {
    this.main = main;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
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

  public PersonModel getPerson() {
    return this.person;
  }

  public void setPerson(PersonModel person) {
    this.person = person;
  }




  }