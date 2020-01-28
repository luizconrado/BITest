package com.example.restapi.bitest.model;

import com.example.restapi.bitest.controller.MerchantAddress;
import org.springframework.data.repository.CrudRepository;

public interface MerchantAddressRepository extends CrudRepository<MerchantAddress, String> {
}
