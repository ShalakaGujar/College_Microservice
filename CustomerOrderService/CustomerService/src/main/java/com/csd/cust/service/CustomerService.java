package com.csd.cust.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csd.cust.model.Customer;
import com.csd.cust.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer obj = custRepo.save(c);
		return obj;
	}
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return custRepo.findAll();
	}
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer obj = custRepo.findById(c.getId()).get();
		obj.setName(c.getName());
		obj.setEmail(c.getEmail());
		obj = custRepo.save(obj);
		return obj;
	}
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		custRepo.deleteById(id);
		
	}
	
	
	public Customer getCustomerByEmail (String email)
	{
		return custRepo.findByEmail(email);
	}
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer cust = custRepo.findById(id).get();
		return cust;
	}	
}
