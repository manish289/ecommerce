package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.OrderItemIdNotFoundException;
import com.example.demo.model.OrderItems;
import com.example.demo.service.Commons;
import com.example.demo.service.ManageOrderItemsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderController {
	
	@Autowired
	ManageOrderItemsService orderItemsService;
	
	@Autowired
	Commons commons;
	
	@PostMapping("/orders")
	public ResponseEntity<OrderItems> createOrder(@Valid @RequestBody OrderItems orderItems){
		log.info("[createOrder] for order:");
		
		OrderItems orderData = orderItemsService.placeOrderItems(orderItems);
		return new ResponseEntity<OrderItems>(orderData, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderItems>> getOrders() {
		log.info("[getOrders] all orders");
		
		List<OrderItems> list = orderItemsService.getOrderList();

		if (list.isEmpty()) {
			return new ResponseEntity<List<OrderItems>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderItems>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<OrderItems> getOrderItemById(@PathVariable Long orderId)
	  throws OrderItemIdNotFoundException {
		log.info("[getOrderItemById] by orderId : {}", orderId);
		
		OrderItems data = orderItemsService.getOrderItemsById(orderId);
		
		if(ObjectUtils.isEmpty(data)){
			throw new OrderItemIdNotFoundException("Enter valid orderId");
		}
		return new ResponseEntity<OrderItems>(data, HttpStatus.OK);
	}
	
	@PutMapping("/orders/{orderId}")
	public OrderItems updateOrderItems(@RequestBody OrderItems orderItem, @PathVariable Long orderId)
	  throws OrderItemIdNotFoundException {
		log.info("[updateOrderItems] by orderId : {}", orderId);
		
		commons.checkOrderIdExistsorNot(orderId);
		
		OrderItems data = orderItemsService.updateOrderData(orderId, orderItem);
		return data;
	}
	
	@DeleteMapping("/orders/{orderId}")
	public String deleteOrderItem(@PathVariable Long orderId) throws OrderItemIdNotFoundException {
		log.info("[deleteOrderItem] by orderId : {}", orderId);
		
		commons.checkOrderIdExistsorNot(orderId);
		
		String data = orderItemsService.deleteOrderItemData(orderId);
		return data;
	}

}
