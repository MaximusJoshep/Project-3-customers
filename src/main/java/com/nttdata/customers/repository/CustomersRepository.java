package com.nttdata.customers.repository;

import com.nttdata.customers.entity.Customers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomersRepository extends ReactiveMongoRepository<Customers, String> {

    Mono<Customers>findByCode(String code);
    Flux<Customers>findByCodProfile(String CodProfile);
}
