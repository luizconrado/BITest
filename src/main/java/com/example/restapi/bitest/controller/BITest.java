package com.example.restapi.bitest.controller;

import com.example.restapi.bitest.model.MerchantAddress;
import com.example.restapi.bitest.model.MerchantContract;
import com.example.restapi.bitest.model.Order;
import com.example.restapi.bitest.model.Traffic;
import com.example.restapi.bitest.repository.MerchantAddressRepository;
import com.example.restapi.bitest.repository.MerchantContractRepository;
import com.example.restapi.bitest.repository.OrdersRepository;
import com.example.restapi.bitest.repository.TrafficRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BITest {

    private MerchantAddressRepository merchantAddressRepository;
    private MerchantContractRepository merchantContractRepository;
    private OrdersRepository ordersRepository;
    private TrafficRepository trafficRepository;

    public BITest(MerchantAddressRepository merchantAddressRepository, MerchantContractRepository merchantContractRepository,
                  OrdersRepository ordersRepository, TrafficRepository trafficRepository) {

        this.merchantAddressRepository = merchantAddressRepository;
        this.merchantContractRepository = merchantContractRepository;
        this.ordersRepository = ordersRepository;
        this.trafficRepository = trafficRepository;
//        merchantAddressRepository.findAll().forEach(System.out::println);

    }


//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
//    public String hello() {
//        return "Hello";
//    }


//--------------------------------------- TOKEN ENDPOINT --------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, path = "/token", produces = "application/json")
    public ResponseEntity<String> getCredentials(@RequestHeader HttpHeaders headers) {
        String username = null;
        String password = null;
        try {
            username = headers.get("username").get(0);
            password = headers.get("password").get(0);

            if ((!username.equals("bitest@finleap.com") || username == null) || (!password.equals("AkljdasHJSDkj86572Fga") || password == null)) {
                System.out.println(headers.entrySet());
                return new ResponseEntity<String>("{\"token\":\"snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!\"}", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("{\"error\":\"wrong username or password.\"}", HttpStatus.UNAUTHORIZED);
            }

        } catch (NullPointerException e) {
            return new ResponseEntity<String>("{\"error\":\"username or password not found.\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //--------------------------------------- DATA ENDPOINTS  --------------------------------------------------


    //--------------------------------------- Merchant Address --------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/merchantaddresses", produces = "application/json")
    public ResponseEntity<String> getMerchantAddresses(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.UNAUTHORIZED);
            }

        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "{\"error\":\"token not found.\"}");
//            return new ResponseEntity<String>("{\"error\":\"Token not found.\"}", HttpStatus.UNAUTHORIZED);
        }

        Iterable<MerchantAddress> all = merchantAddressRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String values = null;
        try {
            values = mapper.writeValueAsString(all);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(values);
    }


    //--------------------------------------- Merchant Contract --------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/merchantcontracts", produces = "application/json")
    public ResponseEntity<String> getMerchantContracts(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.UNAUTHORIZED);
            }

        } catch (NullPointerException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"error\":\"token not found.\"}");
            return new ResponseEntity<String>("{\"error\":\"Token not found.\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Iterable<MerchantContract> all = merchantContractRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String values = null;
        try {
            values = mapper.writeValueAsString(all);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(values);
    }


    //--------------------------------------- Orders --------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/orders", produces = "application/json")
    public ResponseEntity<String> getOrders(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.UNAUTHORIZED);
            }

        } catch (NullPointerException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"error\":\"token not found.\"}");
            return new ResponseEntity<String>("{\"error\":\"Token not found.\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Iterable<Order> all = ordersRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String values = null;
        try {
            values = mapper.writeValueAsString(all);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(values);
    }


    //--------------------------------------- Traffic --------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, path = "/traffic", produces = "application/json")
    public ResponseEntity<String> getTraffic(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.UNAUTHORIZED);
            }

        } catch (NullPointerException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"error\":\"token not found.\"}");
            return new ResponseEntity<String>("{\"error\":\"Token not found.\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Iterable<Traffic> all = trafficRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String values = null;
        try {
            values = mapper.writeValueAsString(all);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(values);
    }


}
