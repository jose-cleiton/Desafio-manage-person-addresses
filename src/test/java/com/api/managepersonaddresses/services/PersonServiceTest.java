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
    // Cria uma nova pessoa
    PersonModel person = new PersonModel("Nome");

    // Salva a pessoa usando o método save
    personService.save(person);

    // Verifica se a pessoa foi salva no repositório
    assertThat(personRepository.findById(person.getId()).get()).isEqualTo(person);
  }
  @Test
  @Transactional
  public void testUpdatePerson() {
    // Cria uma nova pessoa e adiciona ao repositório
    PersonModel person = new PersonModel("John Doe");
    personRepository.save(person);

    // Atualiza a pessoa
    person.setName("Jane Doe");
    personService.save(person);

    // Verifica se a pessoa foi atualizada no repositório
    assertThat(personRepository.findById(person.getId()).get().getName()).isEqualTo("Jane Doe");

  }
  
  
  



}