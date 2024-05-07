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
import com.example.demo.exception.ItemIdNotFoundException;
import com.example.demo.model.Items;
import com.example.demo.service.Commons;
import com.example.demo.service.ItemServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Slf4j
public class ItemsController {
	
	@Autowired
	ItemServiceImpl itemService;
	
	@Autowired
	Commons commons;
	
	@PostMapping("/items")
	public ResponseEntity<Items> createItem(@Valid @RequestBody Items items){
		log.info("[createItem] for itemName:", items.getItemName());
		
		Items itemsData = itemService.createItem(items);
		return new ResponseEntity<Items>(itemsData, HttpStatus.CREATED);
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<Items>> getItems() {
		log.info("[getItems] all items");
		
		List<Items> list = itemService.getItemList();

		if (list.isEmpty()) {
			return new ResponseEntity<List<Items>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<Items> getItemById(@PathVariable Long itemId)
	  throws ItemIdNotFoundException {
		log.info("[getItemById] by itemId : {}", itemId);
		
		Items data = itemService.getItemById(itemId);
		
		if(ObjectUtils.isEmpty(data)){
			throw new ItemIdNotFoundException("Enter valid ItemId");
		}
		return new ResponseEntity<Items>(data, HttpStatus.OK);
	}
	

	@PutMapping("/items/{itemId}")
	public Items updateItems(@RequestBody Items item, @PathVariable Long itemId)
	  throws ItemIdNotFoundException {
		log.info("[updateItems] by itemId : {}", itemId);
		
		commons.checkItemIdExistsorNot(itemId);
		
		Items itemData = itemService.updateItemData(itemId, item);
		return itemData;
	}
	
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable Long itemId) throws ItemIdNotFoundException {
		log.info("[deleteItem] by itemId : {}", itemId);
		
		commons.checkItemIdExistsorNot(itemId);
		
		String data = itemService.deleteItemData(itemId);
		return data;
	}
	
}
