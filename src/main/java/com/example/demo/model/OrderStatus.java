package com.example.demo.model;

public enum OrderStatus {
	
	PENDING(0, "PENDING"),
	PROCESSING(1, "PROCESSING"),
	SHIPEED(2, "SHIPEED"),
	DELIVERED(3, "DELIVERED"),
	CANCELLED(4, "CANCELLED");

	private final Integer orderStatus;
	private final String orderStatusName;

	OrderStatus(Integer orderStatus, String orderStatusName) {
		this.orderStatus = orderStatus;
		this.orderStatusName = orderStatusName;
	}

	public static OrderStatus valueOf(Integer text) {
		for (OrderStatus b : OrderStatus.values()) {
			if (b.orderStatus == text) {
				return b;
			}
		}
		return null;
	}

	public Integer orderStatus() {
		return orderStatus;
	}

	public String orderStatusName() {
		return orderStatusName;
	}

}
