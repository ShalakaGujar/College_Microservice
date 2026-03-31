package com.csd.cust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csd.cust.model.Customer;
import com.csd.cust.service.CustomerService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired // field level
	private CustomerService custService;
	// Dependency Injection - 
	// field level, constructor level and setter
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c)
	{
		Customer obj = custService.addCustomer(c);
		if(obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok(null);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id)
	{
		return ResponseEntity.ok(custService.getCustomerById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getCustomers()
	{
		return ResponseEntity.ok(custService.getCustomers());
	}
	
	@GetMapping("/get/email/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email)
	{
		return ResponseEntity.ok(custService.getCustomerByEmail(email));
	}
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c)
	{
		return ResponseEntity.ok(custService.updateCustomer(c));
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id)
	{
		System.out.println(id);
		custService.deleteCustomer(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}
}
