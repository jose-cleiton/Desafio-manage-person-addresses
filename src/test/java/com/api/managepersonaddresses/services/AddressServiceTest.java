package com.api.managepersonaddresses.services;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.repositories.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AddressServiceTest {
  @Autowired
  private AddressService addressService;
  @Autowired
  private AddressRepository addressRepository;

  @Test
  public void testAddAddress() {
    AddressModel address = new AddressModel("Rua 1", "123", "Bairro", "Cidade", "Estado", "Pais", "CEP");

    addressService.addAddress(address);

    assertThat(addressRepository.findAll()).contains(address);
  }
  @Test
    public void testUpdateAddress() {
        AddressModel address = new AddressModel("Rua 1", "123", "Bairro", "Cidade", "Estado", "Pais", "CEP");
        address = addressRepository.save(address);

        address.setPublicPlace("Rua 2");
        addressService.updateAddress(address);
    assertThat(addressRepository.findById(address.getId()).get().getPublicPlace()).isEqualTo("Rua 2");
}



}