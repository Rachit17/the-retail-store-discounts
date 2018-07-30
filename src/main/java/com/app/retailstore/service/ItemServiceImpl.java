package com.app.retailstore.service;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.app.retailstore.model.Item;
import com.app.retailstore.util.Items;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

private static final AtomicLong counter = new AtomicLong();
	
	private static Set<Item> items;
	
	static{
		items = populateDummyItems();
	}

	public Set<Item> populateItems() {
		return items;
	}
	
	public Item findById(long id) {
		for(Item item : items){
			if(item.getId() == id){
				return item;
			}
		}
		return null;
	}

	private static Set<Item> populateDummyItems(){
		Set<Item> items = new HashSet<Item>();
		items.add(new Item(counter.incrementAndGet(), "Bakery", Items.Groceries));
		items.add(new Item(counter.incrementAndGet(), "Diary", Items.Groceries));
		items.add(new Item(counter.incrementAndGet(), "Sticky Notes", Items.General));
		items.add(new Item(counter.incrementAndGet(), "Magic Chart", Items.General));
		
		return items;
	}
	
	

}
