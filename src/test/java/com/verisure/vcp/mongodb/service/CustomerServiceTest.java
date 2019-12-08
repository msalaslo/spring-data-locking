package com.verisure.vcp.mongodb.service;

import com.verisure.vcp.mongodb.domain.entity.Customer;
import com.verisure.vcp.mongodb.domain.repository.CustomerRepository;
import com.verisure.vcp.mongodb.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();

    @Mock
    private CustomerRepository customerRepository;


    @Test
    void findAll() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(Customer.builder().lastName("last name").build()));
        List<Customer> customers = customerService.getCustomers();
        assertEquals(customers.size(), 1);
        verify(customerRepository, times(1)).findAll();
    }


    @ParameterizedTest(name = "Customer Item  description: {0}, code: {1}")
    @CsvSource({
            "Description,    code",
            "Description 2,  code 2",
            "Description 3,  code 3",
            "Description 4, code 4"
    })
    void exampleParametrized(String firstName, String lastName) {
        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        List<Customer> customers = customerService.getCustomers();
        assertEquals(customers.size(), 1);
        assertEquals(customers.get(0), customer,
                () -> firstName + " should equal " + customer.getFirstName());

        verify(customerRepository, times(1)).findAll();
    }

}
