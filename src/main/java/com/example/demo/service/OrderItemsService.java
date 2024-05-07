package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrderItems;


public interface OrderItemsService {

	OrderItems placeOrderItems(OrderItems orderItems);

	List<OrderItems> getOrderList();

	OrderItems getOrderItemsById(Long orderId);

	OrderItems updateOrderData(Long orderId, OrderItems orderItem);

	String deleteOrderItemData(Long orderId);

}