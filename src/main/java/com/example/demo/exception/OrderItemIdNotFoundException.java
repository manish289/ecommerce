package com.example.demo.exception;

public class OrderItemIdNotFoundException extends Exception {
	
	public OrderItemIdNotFoundException(String s) {
		super(s);
	}
	
	public OrderItemIdNotFoundException() {
		super();
	}

}