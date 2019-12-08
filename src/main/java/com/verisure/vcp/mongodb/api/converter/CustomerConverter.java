package com.verisure.vcp.mongodb.api.converter;

import org.mapstruct.Mapper;

import com.verisure.vcp.mongodb.api.dto.CustomerDTO;
import com.verisure.vcp.mongodb.domain.entity.Customer;

/**
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Mapper(componentModel = "spring")
public interface CustomerConverter {

    CustomerDTO toCustomerDto(Customer item);
    Customer toCustomer(CustomerDTO entry);

}