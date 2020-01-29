package com.example.restapi.bitest.repository;

import com.example.restapi.bitest.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, String> {
}
