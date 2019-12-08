package com.verisure.vcp.mongodb.domain.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.verisure.vcp.mongodb.domain.entity.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String> {

//	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public Customer findByFirstName(String firstName);

//	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<Customer> findByLastName(String lastName);

}
