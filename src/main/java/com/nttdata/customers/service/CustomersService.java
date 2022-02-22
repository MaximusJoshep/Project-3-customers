package com.nttdata.customers.service;

import com.nttdata.customers.entity.Customers;
import com.nttdata.customers.model.Profiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomersService extends CrudService<Customers, String>{
    Mono<Customers>findById(String id);
    Mono<Customers>findByCode(String code);
    Flux<Customers>findByCodProfile(String CodProfile);
}
