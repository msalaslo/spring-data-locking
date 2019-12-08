package com.verisure.vcp.mongodb.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import com.verisure.vcp.mongodb.domain.entity.Customer;
import com.verisure.vcp.mongodb.domain.repository.CustomerRepository;

@SpringBootTest
public class OptimisticLockingExceptionTest {

    @Mock
    private CustomerRepository repository;


    @Test
    void whenOptimisticLockingExceptionThrown_thenAssertionSucceds() {
    	
    	 Assertions.assertThrows(OptimisticLockingFailureException.class, () -> {
			// save a couple of customers
			repository.save(new Customer("Alice", "Smith"));
			repository.save(new Customer("Bob", "Smith"));
	
			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer);
			}
			System.out.println();
	
			// fetch an individual customer
			System.out.println("Customer found with findByFirstName('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(repository.findByFirstName("Alice"));
	
			System.out.println("Customers found with findByLastName('Smith'):");
			System.out.println("--------------------------------");
			for (Customer customer : repository.findByLastName("Smith")) {
				System.out.println(customer);
			}
			
			Customer alice = repository.findByFirstName("Alice");
			alice.setLastName("Moro");
			
			Customer alice2 = repository.findByFirstName("Alice");
			alice2.setLastName("Cris");
	
		
			repository.save(alice);
			repository.save(alice2);
    	});
    }
}
