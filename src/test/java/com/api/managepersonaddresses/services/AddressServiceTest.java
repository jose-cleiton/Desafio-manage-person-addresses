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
    // Cria um novo endereço
    AddressModel address = new AddressModel("Rua 1", "123", "Bairro", "Cidade", "Estado", "Pais", "CEP");

    // Adiciona o endereço usando o método addAddress
    addressService.addAddress(address);

    // Verifica se o endereço foi adicionado ao repositório
    assertThat(addressRepository.findAll()).contains(address);
  }
  @Test
    public void testUpdateAddress() {
        // Cria um novo endereço e adiciona ao repositório
        AddressModel address = new AddressModel("Rua 1", "123", "Bairro", "Cidade", "Estado", "Pais", "CEP");
        address = addressRepository.save(address);

        // Atualiza o endereço
        address.setPublicPlace("Rua 2");
        addressService.updateAddress(address);
    // Verifica se o endereço foi atualizado no repositório
    assertThat(addressRepository.findById(address.getId()).get().getPublicPlace()).isEqualTo("Rua 2");
}



}