package com.api.managepersonaddresses.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonModelTest {

  @Test
  public void testCreatePersonModel() {
    PersonModel person = new PersonModel(null, "John Doe", "01/01/2000", null);

    assertNotNull(person);
    assertEquals("John Doe", person.getName());
    assertEquals("01/01/2000", person.getBirthDate());
    assertNull(person.getAddresses());
  }
  @Test
  public void testSetPersonModelProperties() {
    PersonModel person = new PersonModel();
    person.setName("John Doe");
    person.setBirthDate("01/01/2000");
    person.setAddresses(null);

    assertEquals("John Doe", person.getName());
    assertEquals("01/01/2000", person.getBirthDate());
    assertNull(person.getAddresses());
  }
  
  





}