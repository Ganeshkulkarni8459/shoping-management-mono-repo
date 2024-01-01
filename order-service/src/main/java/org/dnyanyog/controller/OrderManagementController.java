package org.dnyanyog.controller;

import org.dnyanyog.dto.CancelOrderResponse;
import org.dnyanyog.dto.PlaceOrderRequest;
import org.dnyanyog.dto.PlaceOrderResponse;
import org.dnyanyog.repo.OrderRepository;
import org.dnyanyog.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@RestController
public class OrderManagementController {
	
	@Autowired
	OrderService orderServices;
	
	@PostMapping(path = "/api/v1/order/place")
	public PlaceOrderResponse orderService(@RequestBody PlaceOrderRequest orderRequest) {
		return orderServices.placeOrder(orderRequest);
			
	}
	@DeleteMapping(path = "/api/v1/user/delete/{orderId}")
	public CancelOrderResponse canceledOrder(@PathVariable Long orderId) {
		
		return orderServices.cancelOrder(orderId);
	}
}
