package com.example.restapi.bitest.repository;

import com.example.restapi.bitest.model.Traffic;
import com.example.restapi.bitest.model.TrafficId;
import org.springframework.data.repository.CrudRepository;

public interface TrafficRepository extends CrudRepository<Traffic, TrafficId> {
}
