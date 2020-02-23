package com.verisure.vcp.mongodb.service;


import java.util.List;

import com.verisure.vcp.mongodb.domain.entity.Address;
import com.verisure.vcp.mongodb.domain.entity.Customer;

/**
 * Sample service interface used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
public interface CustomerService {

	/**
	 * Creates a customer.
	 * 
	 * @param customer The customer to create.
	 */
    void createCustomer(Customer customer);
    
	/**
	 * Find by last name and modifies name of a customer.
	 * 
	 * @param name The customer to modify.
	 */
    void findAndModifyCustomer(String firstName, String lastName);
    
	/**
	 * Find by id and modifies name of a customer.
	 * 
	 * @param name The customer to modify.
	 */
    void setAddress(long id, Address address);

	/**
	 * Gets all the customers.
	 * 
	 * @return The list of customers.
	 */
    List<Customer> getCustomers();

}
