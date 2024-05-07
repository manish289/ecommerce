package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	@NotNull(message = "ItemName is Required ")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Enter Valid ItemName")
	private String itemName;
	
	@NotNull(message = "ItemPrice is Required")
	private Double itemPrice;
	
	@NotNull(message = "Please select valid category")
	private CategoryType categoryId;

}
