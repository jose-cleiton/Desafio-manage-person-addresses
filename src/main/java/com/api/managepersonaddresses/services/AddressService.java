package com.api.managepersonaddresses.services;


import org.springframework.stereotype.Service;

import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.repositories.AddressRepository;


@Service
public class AddressService {


  final AddressRepository addressRepository;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }


  public AddressModel save(AddressModel addressModel) {
    return addressRepository.save(addressModel);
    }


    public void addAddress(AddressModel address) {
      addressRepository.save(address);
  }

  public void updateAddress(AddressModel address) {
      addressRepository.save(address);
  }
}