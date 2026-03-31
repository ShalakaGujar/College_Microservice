package com.csd.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csd.order.model.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{
	
	public List<Order> findAllByCustomerId(Long custid);
}
