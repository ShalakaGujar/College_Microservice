package com.csd.order.common;

import java.util.List;

import com.csd.order.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
	private Customer cust;
	private List<Order> orderList;
}
