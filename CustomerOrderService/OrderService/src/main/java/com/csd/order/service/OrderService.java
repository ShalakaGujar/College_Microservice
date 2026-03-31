package com.csd.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.csd.order.common.Customer;
import com.csd.order.common.OrderResponse;
import com.csd.order.model.Order;
import com.csd.order.repository.OrderRepository;

import reactor.core.publisher.Mono;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private WebClient webClient;
    
	public Order addOrder(Order c) {
		// TODO Auto-generated method stub
		Order obj = orderRepo.save(c);
		return obj;
	}
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}
	public Order updateOrder(Order o) {
		// TODO Auto-generated method stub
		Order obj = orderRepo.findById(o.getId()).get();
//		obj.se(o.getName());
//		obj.setEmail(o.getEmail());
		obj = orderRepo.save(obj);
		return obj;
	}
	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
		
	}
	public List<Order> getOrdersByCustId(Long custid)
	{
		List<Order> orderList = orderRepo.findAllByCustomerId(custid);
		return orderList;
	}

	public OrderResponse getOrdersWithCustId(Long custid) {  
		// TODO Auto-generated method stub
		// Get list of Order objects by custid
		List<Order> orderList =  getOrdersByCustId(custid);
		// webclient - customer object
		Customer cust =  webClient.get()
				.uri("/cust/"+custid)
				.retrieve()
				.bodyToMono(Customer.class)
				.block();
		return new OrderResponse(cust, orderList);
		
		
		/*
		 *  one customer has multiple orders
		 *  C-O=>1-M
		 *  order table - orderid, custid
		 *  
		 */
	}
}
