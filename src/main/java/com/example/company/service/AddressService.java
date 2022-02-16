package com.example.company.service;

import com.example.company.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();
    Address saveAddress(Address address);
    Address GetAddress(Long id);
    Address deleteAddress(Long id);

}
