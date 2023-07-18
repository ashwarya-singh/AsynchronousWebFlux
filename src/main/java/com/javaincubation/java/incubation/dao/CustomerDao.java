package com.javaincubation.java.incubation.dao;

import com.javaincubation.java.incubation.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getCustomerList() {
       return IntStream.rangeClosed(1,10)
               .peek(CustomerDao::sleepExecution)
               .peek(i-> System.out.println("Processing Count" +i))
               .mapToObj(i->new Customer(i,"Customer"+i,"CustomerAddress"+i))
               .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerListStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing Count in Stream Flow" + i))
                .map(i -> new Customer(i, "Customer" + i, "CustomerAddress" + i));
    }

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Flux<Customer> getCustomerFunctionalList() {
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("Processing Count in Stream Flow" + i))
                .map(i -> new Customer(i, "Customer" + i, "CustomerAddress" + i));
    }

    public Flux<Customer> getCustomerFunctionalStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing Count in Stream Flow" + i))
                .map(i -> new Customer(i, "Customer" + i, "CustomerAddress" + i));
    }

    public Flux<Customer> getCustomerByCustomerId() {
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("Processing Count in Stream Flow" + i))
                .map(i -> new Customer(i, "Customer" + i, "CustomerAddress" + i));
    }
}
