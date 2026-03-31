package com.csd.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csd.cust.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

	// non primary key get
	public Customer findByEmail(String email);
}
