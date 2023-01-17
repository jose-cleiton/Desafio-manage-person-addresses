package com.api.managepersonaddresses.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.managepersonaddresses.dtos.AddressDto;
import com.api.managepersonaddresses.dtos.PersonDto;
import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.AddressRepository;
import com.api.managepersonaddresses.services.AddressService;
import com.api.managepersonaddresses.services.PersonService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person-manager")
public class PersonManegerAddress {

  final PersonService person;
  final AddressService address;
  final AddressRepository addressRepository;

  public PersonManegerAddress(PersonService person, AddressService address, AddressRepository addressRepository) {
    this.person = person;
    this.address = address;
    this.addressRepository = addressRepository;
  }

  @PostMapping
  public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDto personDto) {

    if (person.existsByName(personDto.getName())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person already exists");
    }

    var personModel = new PersonModel();
    BeanUtils.copyProperties(personDto, personModel);
    var addresses = new ArrayList<AddressModel>();
    for (AddressDto addressDto : personDto.getAddresses()) {
      var addressModel = new AddressModel();
      BeanUtils.copyProperties(addressDto, addressModel);
      addressModel.setPerson(personModel);
      addresses.add(addressModel);
    }
    personModel.setAddresses(addresses);

    personModel = person.save(personModel);

    for (AddressModel address : addresses) {
      address.setPerson(personModel);
      addressRepository.save(address);
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(personModel);
  }
  
  @GetMapping
  public ResponseEntity<List<PersonModel>> getAllPeople() {
    return ResponseEntity.ok(person.findAll());
  }
  
  
  @GetMapping("/{id}")
  public ResponseEntity<Object> getPersonById(@PathVariable(value = "id") Long id) {
    Optional<PersonModel> personModelOptional = (Optional<PersonModel>) person.findById(id);
    if (!personModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
    }
    return ResponseEntity.ok(personModelOptional.get());
  }
  
  @PutMapping("{id}")
  public ResponseEntity<Object> updatePerson(
   @PathVariable(value = "id") Long id,
   @RequestBody @Valid PersonDto personDto) {
    Optional<PersonModel> personModelOptional = person.findById(id);
    if (!personModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
    }
    var personModel = personModelOptional.get();
    personModel.setName(personDto.getName());
    personModel.setBirthDate(personDto.getBirthDate());
    
    var res = person.save(personModel);
    return ResponseEntity.status(HttpStatus.OK).body(res);

}

}