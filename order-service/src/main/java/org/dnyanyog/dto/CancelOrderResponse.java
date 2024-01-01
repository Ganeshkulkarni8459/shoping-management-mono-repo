package org.dnyanyog.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CancelOrderResponse {
	private Long orderId;
	private String message;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
