package com.api.managepersonaddresses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.AddressRepository;
import com.api.managepersonaddresses.repositories.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/address")
public class AddressController {

  private final AddressRepository repository;
  private final PersonRepository personRepository;

  public AddressController(AddressRepository repository, PersonRepository personRepository) {
    this.repository = repository;
    this.personRepository = personRepository;
  }

  @GetMapping
  public ResponseEntity<List<AddressModel>> findAll() {
    List<AddressModel> result = repository.findAll();
    return ResponseEntity.ok(result);
  }
  

  @GetMapping(value = "/page")
  public ResponseEntity<Page<AddressModel>> findAllPage(Pageable pageable) {
    Page<AddressModel> result = repository.findAll(pageable);
    return ResponseEntity.ok(result);
  }

  @PostMapping
  public ResponseEntity<AddressModel> create(@RequestParam("personId") Integer personId,
      @RequestBody AddressModel address) {
    Optional<PersonModel> person = personRepository.findById(personId);
    if (!person.isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    address.setPerson(person.get());
    AddressModel result = repository.save(address);
    return ResponseEntity.ok(result);
  }
  
  @GetMapping("{personId}")
public ResponseEntity<List<AddressModel>> encontrarEnderecosPorPessoa(@PathVariable("personId") Integer personId) {
    Optional<PersonModel> person = personRepository.findById(personId);
    if(!person.isPresent()) {
        return ResponseEntity.badRequest().build();
    }
    List<AddressModel> addresses = repository.findByPerson(person.get());
    return ResponseEntity.ok(addresses);
}


@GetMapping(value = "/main/{personId}")
public ResponseEntity<Map<String, Object>> findMainAddressByPersonId(@PathVariable Integer personId) {
    Optional<AddressModel> address = repository.findByPersonIdAndMainTrue(personId);
    if(!address.isPresent()) {
        return ResponseEntity.notFound().build();
    }
    Map<String, Object> response = new HashMap<>();
    response.put("id", address.get().getId());
    response.put("city", address.get().getCity());
    response.put("main", address.get().getMain());
    response.put("number", address.get().getNumber());
    response.put("publicPlace", address.get().getPublicPlace());
    response.put("zipCode", address.get().getZipCode());
    return ResponseEntity.ok(response);
}





  
}