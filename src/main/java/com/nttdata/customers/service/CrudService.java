package com.nttdata.customers.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService <T, ID> {
    Flux<T> findAll();
    Mono<T> save(T entity);
    Mono<T> update(T entity);
    Mono<T> delete(ID id);
}
