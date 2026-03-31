package com.csd.order.controller;

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

import com.csd.order.common.OrderResponse;
import com.csd.order.model.Order;
import com.csd.order.service.OrderService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired // field level
	private OrderService orderService;
	// Dependency Injection - 
	// field level, constructor level and setter
	
	@GetMapping("/cust/{custid}")
	public OrderResponse getOrdersWithCustId(@PathVariable("custid") Long custid)
	{
		return orderService.getOrdersWithCustId(custid);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order o)
	{
		Order obj = orderService.addOrder(o);
		if(obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok(null);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Order>> getOrders()
	{
		return ResponseEntity.ok(orderService.getOrders());
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> updateCustomer(@RequestBody Order o)
	{
		return ResponseEntity.ok(orderService.updateOrder(o));
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id)
	{
		System.out.println(id);
		orderService.deleteOrder(id);
		return ResponseEntity.ok("Order deleted successfully");
	}
}
