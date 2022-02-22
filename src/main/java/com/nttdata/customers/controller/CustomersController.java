package com.nttdata.customers.controller;

import com.nttdata.customers.entity.Customers;
import com.nttdata.customers.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customers> getCustomers(){
        System.out.println("Listar clientes");
        return customersService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customers> saveCustomer(@RequestBody Customers customer){
        System.out.println("Guardar nuevo cliente");
        return customersService.save(customer);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Customers> updateCustomer(@RequestBody Customers customers){
        System.out.println("Actualizar datos de cliente");
        return customersService.update(customers);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Customers> deleteCustomer(@PathVariable String id){
        System.out.println("Eliminar cliente - cambiar de estado");
        return customersService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<Customers> findCustomerById(@PathVariable String id){
        System.out.println("Buscar cliente por id");
        return customersService.findById(id);
    }

    @GetMapping("/bycode/{code}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<Customers> findCustomerCode(@PathVariable String code){
        System.out.println("Buscar cliente por su codigo");
        return customersService.findByCode(code);
    }

    @GetMapping("/byprofile/{codProfile}")
    public Flux<Customers> getByProfileId(@PathVariable String codProfile){
        System.out.println("Listar clientes por perfil");
        return  customersService.findByCodProfile(codProfile);
    }
}
