package com.javaincubation.java.incubation.controller;

import com.javaincubation.java.incubation.dto.Customer;
import com.javaincubation.java.incubation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/non-stream")
    public List<Customer> getAllCustomer(){
        return customerService.loadAllCustomer();
    }

    @GetMapping(value = "/stream" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomerStream(){
        return customerService.loadAllCustomerStream();
    }
}
