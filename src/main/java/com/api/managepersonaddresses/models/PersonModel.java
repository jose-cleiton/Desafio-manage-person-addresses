package com.api.managepersonaddresses.models;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class PersonModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    
    @Column(name = "birthDate", nullable = false,length = 10)
    private String birthDate;

    @OneToMany(mappedBy = "person")
    private List<AddressModel> addresses;
    
    public PersonModel(String string) {
    }
    
    public PersonModel(String string, String string2) {
    }
    
    public PersonModel(Long id, String name, String birthDate, List<AddressModel> addresses) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }
    
    public PersonModel() {
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public List<AddressModel> getAddresses() {
        return addresses;
    }
    
    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }
}
