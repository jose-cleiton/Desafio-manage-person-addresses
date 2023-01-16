package com.api.managepersonaddresses.services;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.PersonRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonServiceTest {
  @Autowired
  private PersonService personService;
  @Autowired
  private PersonRepository personRepository;

  @Test
  public void testSave() {
    
    PersonModel person = new PersonModel("Nome");

    personService.save(person);

    assertThat(personRepository.findById(person.getId()).get()).isEqualTo(person);
  }
  @Test
  @Transactional
  public void testUpdatePerson() {
    PersonModel person = new PersonModel("John Doe");
    personRepository.save(person);

    person.setName("Jane Doe");
    personService.save(person);

    assertThat(personRepository.findById(person.getId()).get().getName()).isEqualTo("Jane Doe");

  }
  
  
  



}