package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemsId;
    
	@NotNull(message = "add at least one item")
	private List<Long> itemId;
	
	@NotNull(message = "orderPrice is Required")
	private Double orderPrice;
	
	@NotNull(message = "status is Required")
	private OrderStatus status;
	
	private Date orderDate;
	
}
