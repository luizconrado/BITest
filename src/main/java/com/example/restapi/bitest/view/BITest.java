package com.example.restapi.bitest.view;

import com.example.restapi.bitest.controller.MerchantAddress;
import com.example.restapi.bitest.controller.MerchantContract;
import com.example.restapi.bitest.model.MerchantAddressRepository;
import com.example.restapi.bitest.model.MerchantContractRepository;
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

    public BITest(MerchantAddressRepository merchantAddressRepository, MerchantContractRepository merchantContractRepository) {
        this.merchantAddressRepository = merchantAddressRepository;
        this.merchantContractRepository = merchantContractRepository;
//        merchantAddressRepository.findAll().forEach(System.out::println);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello";
    }





    @RequestMapping(method = RequestMethod.GET, path = "/merchantaddress", produces = "application/json")
    public ResponseEntity<String> merchantAddress(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.FORBIDDEN);
            }


        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "{\"error\":\"token not found.\"}");
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





    @RequestMapping(method = RequestMethod.GET, path = "/merchantcontract", produces = "application/json")
    public ResponseEntity<String> merchantContract(@RequestHeader HttpHeaders headers) {

        String token = null;
        try {
            token = headers.get("token").get(0);

            if (!token.equals("snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!")) {
                return new ResponseEntity<String>("{\"error\":\"Bad Token.\"}", HttpStatus.FORBIDDEN);
            }

        } catch (NullPointerException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"error\":\"token not found.\"}");
            return new ResponseEntity<String>("{\"error\":\"Token not found.\"}", HttpStatus.FORBIDDEN);
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




    @RequestMapping(method = RequestMethod.POST, path = "/token", produces = "application/json")
    public ResponseEntity<String> getCredentials(@RequestHeader HttpHeaders headers) {
        String username;
        String password;
        try {
            username = headers.get("username").get(0);
            password = headers.get("password").get(0);

        } catch (NullPointerException e) {
            return new ResponseEntity<String>("{\"error\":\"username or password not found.\"}", HttpStatus.OK);
        }
        System.out.println(headers.entrySet());
        return new ResponseEntity<String>("{\"token\":\"snEj3vGHD7Qa4PKvN6dkBz9fZYjrDqaa!@!\"}", HttpStatus.OK);

    }


}
