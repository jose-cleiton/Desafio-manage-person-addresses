package com.api.managepersonaddresses.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.managepersonaddresses.dtos.PersonDto;
import com.api.managepersonaddresses.models.PersonModel;
import com.api.managepersonaddresses.repositories.AddressRepository;
import com.api.managepersonaddresses.services.AddressService;
import com.api.managepersonaddresses.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonManegerAddress.class)
public class PersonManegerAddressTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PersonService personService;

  @MockBean
  private AddressService addressService;

  @MockBean
  private AddressRepository addressRepository;

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testCreatePerson() throws Exception {
    PersonDto personDto = new PersonDto();
    personDto.setName("John Doe");

    PersonModel personModel = new PersonModel();
    personModel.setName("John Doe");

    given(personService.existsByName(any(String.class))).willReturn(false);
    given(personService.save(any(PersonModel.class))).willReturn(personModel);

    mvc.perform(MockMvcRequestBuilders.post("/person-manager")

        .content(asJsonString(personDto))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

  }
  @Test
public void testGetAllPeople() throws Exception {
    // Arrange
    List<PersonModel> people = Arrays.asList(
        new PersonModel("John Doe"),
        new PersonModel("Jane Smith")
    );
    given(personService.findAll()).willReturn(people);

     // Act and Assert
    mvc.perform(MockMvcRequestBuilders.get("/person-manager")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }


  


}