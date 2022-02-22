package com.nttdata.customers.controller;

import static org.mockito.Mockito.when;

import java.sql.Date;

import com.nttdata.customers.entity.Customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(CustomersController.class)
public class CustomersControllerTest {
    @Autowired
	private  WebTestClient webClient;
	
	
	@MockBean
	CustomersController service;

  
  Customers customer;

  
    @BeforeEach
	void setUp() throws Exception {
		customer=new Customers("1","Jose","dni","72838193","1","1",new Date(2022-02-16),true);
		
	}
    @Test
    void testDeleteCustomer() {
        Mockito.when(service.deleteCustomer(customer.getId()))
        .thenReturn(Mono.just(customer));
        webClient.put().uri("/customers/delete/1")
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(customer), Customers.class)
				.exchange()
				.expectStatus().isEqualTo(200);

                
    }
    @Test
    void testFindCustomerById() {
        Mockito.when(service.findCustomerById(customer.getId()))
        .thenReturn(Mono.just(customer));
      ((RequestBodySpec) webClient.get().uri("/customers/1")
				.accept(MediaType.APPLICATION_JSON))
				.body(Mono.just(customer), Customers.class)
				.exchange()
				.expectStatus()
        .isEqualTo(200);
        
    }
    @Test
    void testFindCustomerCode() {
        Mockito.when(service.findCustomerCode(customer.getCode()))
        .thenReturn(Mono.just(customer));
        ((RequestBodySpec) webClient.get().uri("/customers/bycode/1")
				.accept(MediaType.APPLICATION_JSON))
				.body(Mono.just(customer), Customers.class)
				.exchange()
				.expectStatus()
        .isEqualTo(200);
    }


    @Test
    void testGetByProfileId() {
        Flux<Customers> customerFlux = Flux.just(customer);
        Mockito.when(service.getByProfileId(customer.getCodProfile()))
        .thenReturn(customerFlux);

        webClient.get().uri("/customers/byprofile/1")
	    		.accept(MediaType.APPLICATION_JSON)
				  .exchange()
				  .expectStatus().isOk()
				  .returnResult(Customers.class)
				  .getResponseBody();
	   
    }


    @Test
    void testGetCustomers() {
      Flux<Customers> customerFlux = Flux.just(customer);
      Mockito.when(service.getCustomers())
      .thenReturn(customerFlux);

      webClient.get().uri("/customers")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .returnResult(Customers.class)
        .getResponseBody();
    }


    @Test
    void testSaveCustomer() {
        Mockito.when(service.saveCustomer(customer))
          .thenReturn(Mono.just(customer));
          
        webClient.post().uri("/customers")
              .accept(MediaType.APPLICATION_JSON)
              .body(Mono.just(customer), Customers.class)
              .exchange()
              .expectStatus().isCreated();
        
    }


    @Test
    void testUpdateCustomer() {
      Mockito.when(service.updateCustomer(customer))
		    .thenReturn(Mono.just(customer));

		  webClient.put().uri("/customers/update")
				  .accept(MediaType.APPLICATION_JSON)
				  .body(Mono.just(customer), Customers.class)
				  .exchange()
				  .expectStatus().isEqualTo(200);
        
    }
    
}
