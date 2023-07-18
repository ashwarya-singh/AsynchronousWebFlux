package com.javaincubation.java.incubation.service;

import com.javaincubation.java.incubation.dao.CustomerDao;
import com.javaincubation.java.incubation.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDAO;

    public List<Customer> loadAllCustomer(){
        long startTime = System.currentTimeMillis();
        List<Customer> custList = customerDAO.getCustomerList();
        long endTime = System.currentTimeMillis();
        return custList;
    }

    public Flux<Customer> loadAllCustomerStream(){
        long startTime = System.currentTimeMillis();
        Flux<Customer> custList = customerDAO.getCustomerListStream();
        long endTime = System.currentTimeMillis();
        return custList;
    }
}
