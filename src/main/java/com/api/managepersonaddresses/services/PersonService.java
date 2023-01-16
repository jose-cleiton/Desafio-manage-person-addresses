package com.api.managepersonaddresses.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.PersonRepository;


@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Transactional
  public PersonModel save(PersonModel personModel) {
    return personRepository.save(personModel);
  }

  public boolean existsByName(String name) {
    return personRepository.existsByName(name);
  }

  public List<PersonModel> findAll() {
    return personRepository.findAll();
  }

  public Optional<PersonModel> findById(Integer id) {
    return personRepository.findById(id);
  }

  public void addPerson(PersonModel person) {
    personRepository.save(person);
  }

  
}
