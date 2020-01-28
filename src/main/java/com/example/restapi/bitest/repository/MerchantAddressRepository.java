package com.example.restapi.bitest.repository;

import com.example.restapi.bitest.model.MerchantAddress;
import org.springframework.data.repository.CrudRepository;

public interface MerchantAddressRepository extends CrudRepository<MerchantAddress, String> {
}
