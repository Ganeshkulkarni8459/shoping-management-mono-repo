package org.dnyanyog.services;

import java.util.Optional;

import org.dnyanyog.dto.CancelOrderResponse;
import org.dnyanyog.dto.PlaceOrderRequest;
import org.dnyanyog.dto.PlaceOrderResponse;
import org.dnyanyog.entity.Orders;
import org.dnyanyog.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepo;
    
    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
        
        PlaceOrderResponse response = new PlaceOrderResponse();
        
        Orders orderTable = new Orders();
        
        orderTable.setOrderId(request.getOrderId());
        orderTable.setPrice(request.getPrice());
        orderTable.setProductIds(request.getProductIds());
        orderTable.setQuantity(request.getQuantity());
        
        orderTable = orderRepo.save(orderTable);
        response.setTotalPrice(OrderService.this.totalPrice(orderTable.getQuantity(), orderTable.getPrice(), orderTable.getOrderId()));
        response.setMessage("Ordered Placed Successfully");
        response.setOrderId(orderTable.getOrderId());
        
        return response;
    }

    public CancelOrderResponse cancelOrder(Long orderId) {
    	
    	CancelOrderResponse response = new CancelOrderResponse();
  
    	Optional<Orders> orderToDelete = orderRepo.findById(orderId);
    	
    	if(orderToDelete.isEmpty()) {
    		response.setMessage("No Order Found for Cancellation with ID "+orderId);
    	}
    	else {
    		Orders order = orderToDelete.get();
    		orderRepo.delete(order);
    		response.setOrderId(order.getOrderId());
    		response.setMessage("Order canceled Successfully");
    	}
        return response;
    } 	
    public double totalPrice(int quantity,double price,Long orderId) {
    	PlaceOrderRequest request = new PlaceOrderRequest();

    	Optional<Orders> orderTo = orderRepo.findById(orderId);
    	Orders order = orderTo.get();
    	System.out.println("Quantity :"+order.getQuantity());
    	System.out.println("Price :"+order.getPrice());
    	
    	double x = (float) (order.getQuantity() * order.getPrice());
    	
    	return x;
    	
    }
}
