package com.api.managepersonaddresses.controllers;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.AddressRepository;
import com.api.managepersonaddresses.repositories.PersonRepository;



@RunWith(MockitoJUnitRunner.class)
public class AddressControllerTest {

  @InjectMocks
  private AddressController controller;

  @Mock
  private AddressRepository repository;

  @Mock
  private PersonRepository personRepository;

  @Test
  public void create_ValidInput_ReturnsOkResponse() {
    //Arrange
    Long personId = 1L;
    AddressModel address = new AddressModel();
    address.setCity("São Paulo");
    address.setMain(true);
    address.setNumber("123");
    address.setPublicPlace("Av. Paulista");
    address.setZipCode("12345-678");
    PersonModel person = new PersonModel();
    person.setId(personId);
    when(personRepository.findById(personId)).thenReturn(Optional.of(person));
    when(repository.save(address)).thenReturn(address);
    //Act
    ResponseEntity<AddressModel> result = controller.create(personId, address);

    //Assert
    assert (result.getStatusCode() == HttpStatus.OK);
  }

  @Test
  public void create_InvalidInput_ReturnsBadRequestResponse() {
    //Arrange
    Long personId = 1L;
    AddressModel address = new AddressModel();
    address.setCity("São Paulo");
    address.setMain(true);
    address.setNumber("123");
    address.setPublicPlace("Av. Paulista");
    address.setZipCode("12345-678");

    //Act
    ResponseEntity<AddressModel> result = controller.create(personId, address);

    //Assert
    assert (result.getStatusCode() == HttpStatus.BAD_REQUEST);
  }

  @Test
public void findAll_ReturnsOkResponse() {
//Arrange
List<AddressModel> addresses = new ArrayList<>();
addresses.add(new AddressModel());
addresses.add(new AddressModel());
when(repository.findAll()).thenReturn(addresses);

//Act
ResponseEntity<List<AddressModel>> result = controller.findAll();

//Assert
assert (result.getStatusCode() == HttpStatus.OK);



  }



}
