package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Items;
import jakarta.validation.Valid;

public interface ItemService {
	
	public Items createItem(@Valid Items items);
	
	public List<Items> getItemList();
	
	public Items getItemById(Long itemId);

	Items updateItemData(Long itemId, Items item);

	String deleteItemData(Long itemId);

}
