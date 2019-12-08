package com.verisure.vcp.mongodb.service;


import com.verisure.vcp.mongodb.domain.entity.Customer;
import java.util.List;

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
	 * Gets all the customers.
	 * 
	 * @return The list of customers.
	 */
    List<Customer> getCustomers();

}
