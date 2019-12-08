package com.verisure.vcp.mongodb.api.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.verisure.vcp.mongodb.api.converter.CustomerConverter;
import com.verisure.vcp.mongodb.domain.entity.Customer;
import com.verisure.vcp.mongodb.service.CustomerService;

@SpringBootTest
public class CustomerControllerTest {

    @Mock
    CustomerService applicationService;

    @Mock
    CustomerConverter customerConverter;

    @InjectMocks
    CustomerController applicationController;

    MockMvc mockMvc;

    Customer customer;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
        Customer.builder()
                .firstName("Pepe")
                .lastName("Palo")
                .build();
    }

    @Test
    void getAllCustomersOK() throws Exception {
        given(applicationService.getCustomers()).willReturn(Arrays.asList(customer));
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(1)));
    }

}
