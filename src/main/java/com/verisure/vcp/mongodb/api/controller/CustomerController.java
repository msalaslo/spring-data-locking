package com.verisure.vcp.mongodb.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.verisure.vcp.mongodb.api.converter.CustomerConverter;
import com.verisure.vcp.mongodb.api.dto.CustomerDTO;
import com.verisure.vcp.mongodb.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;



/**
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@RestController
@RequestMapping("/customers")
@Tag(name = "Customer controller")
public class CustomerController {

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    @Operation(
            description = "view the list of ALL customers",
            responses = {
                    @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerDTO.class))), responseCode = "200")
            }
    )
    public List<CustomerDTO> getCustomers() {
        LOGGER.debug("getItems::Trying to retrieve all items");
        return customerService.getCustomers().stream()
                .map(customerConverter::toCustomerDto)
                .collect(Collectors.toList());
    }
    
    

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Create an customer"
    )
    public void createCustomer(@Valid @RequestBody CustomerDTO request) {
        LOGGER.debug("Creating an item: {}", request.toString());
        customerService.createCustomer(customerConverter.toCustomer(request));
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Create an customer"
    )
    public void modifyCustomer(@Valid String firstName, String lastName) {
        LOGGER.debug("Modifying an item: {}", firstName);
        customerService.findAndModifyCustomer(firstName, lastName);
    }

}
