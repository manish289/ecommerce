package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ItemRepository;
import com.example.demo.model.Items;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Items createItem(Items items) {
		log.info("[createItem]");
		return itemRepository.save(items);
	}

	@Override
	public List<Items> getItemList() {
		log.info("[getItemList]");
		return itemRepository.findAll();
	}

	public Items getItemById(Long itemId) {
		log.info("[getItemById] by itemId: {}", itemId);
		Optional<Items> data = itemRepository.findById(itemId);
		return data.orElse(null);
	}

	@Override
	public Items updateItemData(Long itemId, Items item) {
		log.info("[updateItemData] by itemId: {}", itemId);
		Optional<Items> op = itemRepository.findById(itemId);
		
		if (op.isPresent()) {
			Items data = op.get();
			data.setItemName(item.getItemName());
			data.setItemPrice(item.getItemPrice());
			data.setCategoryId(item.getCategoryId());
			return itemRepository.save(data);
		} else {
			return null;
		}
	}

	@Override
	public String deleteItemData(Long itemId) {
	  log.info("[deleteItemData] by itemId: {}", itemId);
	  itemRepository.deleteById(itemId);
	  return "Item Data Deleted Successfully";
	}

}
