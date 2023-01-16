package com.api.managepersonaddresses.models;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AddressModelTest {

  @Test
  public void testCreateAddressModel() {
    AddressModel address = new AddressModel("Rua 1", "123", "Bairro", "Cidade", "Estado", "Pais", "CEP");

    assertNotNull(address);

  }


  

}