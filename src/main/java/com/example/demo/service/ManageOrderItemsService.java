package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.OrderItemsRepository;
import com.example.demo.model.OrderItems;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ManageOrderItemsService implements OrderItemsService {
	
	@Autowired
	OrderItemsRepository orderItemsRepository;

	@Override
	public OrderItems placeOrderItems(OrderItems orderItems) {
		log.info("[placeOrderItems]");
		return orderItemsRepository.save(orderItems);
	}

	@Override
	public List<OrderItems> getOrderList() {
		log.info("[getOrderList] get all");
		return orderItemsRepository.findAll();
	}

	@Override
	public OrderItems getOrderItemsById(Long orderId) {
	   log.info("[getOrderItemsById] by orderId: {}", orderId);
	   Optional<OrderItems> data = orderItemsRepository.findById(orderId);
	   return data.orElse(null);
	}

	@Override
	public OrderItems updateOrderData(Long orderId, OrderItems orderItem) {
		log.info("[updateOrderData] by orderId: {}", orderId);
		Optional<OrderItems> op = orderItemsRepository.findById(orderId);
		
		if (op.isPresent()) {
			OrderItems data = op.get();
			data.setItemId(orderItem.getItemId());
			data.setOrderPrice(orderItem.getOrderPrice());
			data.setStatus(orderItem.getStatus());
			data.setOrderDate(orderItem.getOrderDate());
			return orderItemsRepository.save(data);
		} else {
			return null;
		}
	}

	@Override
	public String deleteOrderItemData(Long orderId) {
		log.info("[deleteOrderItemData] by orderId: {}", orderId);
		orderItemsRepository.deleteById(orderId);
		return "Order Data Deleted Successfully";
	}

}
