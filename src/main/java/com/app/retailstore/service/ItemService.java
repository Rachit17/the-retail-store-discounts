package com.app.retailstore.service;

import java.util.Set;

import com.app.retailstore.model.Item;

public interface ItemService {
	
	Item findById(long id);

	Set<Item> populateItems();
}
