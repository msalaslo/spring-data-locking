package com.verisure.vcp.mongodb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.verisure.vcp.mongodb.domain.entity.Address;
import com.verisure.vcp.mongodb.domain.entity.Customer;
import com.verisure.vcp.mongodb.domain.repository.CustomerRepository;
import com.verisure.vcp.mongodb.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * Sample service implementation.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
    	customerRepository.save(customer);
    }
    
	/**
	 * Find by last name and modifies name of a customer.
	 *
	 * @param name The customer to modify.
	 */
    public void findAndModifyCustomer(String firstName, String lastName) {
        LOGGER.debug("findAndModifyCustomer::Trying to retrieve items by lastName:" + lastName + ", firstName:" + firstName);
    	Customer customer = customerRepository.findByLastName(lastName).get(0);
    	customer.setFirstName(firstName);
        LOGGER.debug("findAndModifyCustomer::Trying to save items by lastName:" + lastName + ", firstName:" + firstName);
    	customerRepository.save(customer);
        LOGGER.debug("findAndModifyCustomer::TSaved item by lastName:" + lastName + ", firstName:" + firstName);
    }
    
	/**
	 * Find by last name and modifies name of a customer.
	 *
	 * @param name The customer to modify.
	 */
    @Transactional(readOnly = false, timeout = 3, propagation = Propagation.REQUIRED)
    public void findAndModifyCustomers(String firstName, String lastName) {
        LOGGER.debug("findAndModifyCustomers::Trying to retrieve items by lastName:" + lastName + ", firstName:" + firstName);
    	List<Customer> customers = customerRepository.findByLastName(lastName);
    	for (Customer customer : customers) {
    	   	customer.setFirstName(firstName);
            LOGGER.debug("findAndModifyCustomers::Trying to save items by lastName:" + lastName + ", firstName:" + firstName);
        	customerRepository.save(customer);
            LOGGER.debug("findAndModifyCustomers::TSaved item by lastName:" + lastName + ", firstName:" + firstName);
		}
    }
    
	/**
	 * Find by id and modifies name of a customer.
	 * 
	 * @param name The customer to modify.
	 */
    public void setAddress(long id, Address address) {
        LOGGER.debug("setAddress::Trying to retrieve items by id:" + id);
    	Optional<Customer> customerOp = customerRepository.findById(id);
    	if (customerOp.isPresent()) {
    	   	Customer customer = customerOp.get();
    	   	customer.setAddress(address);
            LOGGER.debug("findAndModifyCustomers::Trying to save items by id:" + id);
        	customerRepository.save(customer);
            LOGGER.debug("findAndModifyCustomers::Saved item by id:" + id);
		}
    }

    @Override
    public List<Customer> getCustomers() {
      return customerRepository.findAll();
    }

}
