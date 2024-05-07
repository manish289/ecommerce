package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.exception.ItemIdNotFoundException;
import com.example.demo.exception.OrderItemIdNotFoundException;
import com.example.demo.model.Items;
import com.example.demo.model.OrderItems;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Commons {
	
	private final ItemServiceImpl itemService;
	private final ManageOrderItemsService manageOrderItemsService;
	
	/*
	 * Validation to check Item is exists or not.
	 * */
	public void checkItemIdExistsorNot(Long itemId) throws ItemIdNotFoundException {

		Items data = itemService.getItemById(itemId);

		if (ObjectUtils.isEmpty(data)) {
			throw new ItemIdNotFoundException("Enter valid ItemId");
		}
	}
	
	/*
	 * Validation to check order is exists or not.
	 * */
	public void checkOrderIdExistsorNot(Long orderId) throws OrderItemIdNotFoundException {

		OrderItems data = manageOrderItemsService.getOrderItemsById(orderId);

		if (ObjectUtils.isEmpty(data)) {
			throw new OrderItemIdNotFoundException("Enter valid OrderId");
		}
	}

}
