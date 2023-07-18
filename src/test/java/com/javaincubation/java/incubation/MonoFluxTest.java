package com.javaincubation.java.incubation;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Sample Test")
                .log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testMonoOnError(){
        Mono<?> monoString = Mono.just("Sample Test")
                .then(Mono.error(new RuntimeException("Runtime Exception")))
                .log();
        monoString.subscribe(System.out::println,(e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<?> fluxString = Flux.just("Thread1","Thread2","Thread3","Thread4")
                .concatWithValues("Thread5")
                .log();
        fluxString.subscribe();
    }

    @Test
    public void testFluxOnError(){
        Flux<?> fluxString = Flux.just("Thread1","Thread2","Thread3","Thread4")
                .concatWithValues("Thread5")
                .concatWith(Flux.error(new RuntimeException("Runtime Exception from Flux")))
                .log();
        fluxString.subscribe();
    }
}
