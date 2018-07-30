package com.app.retailstore.service;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.retailstore.model.Item;
import com.app.retailstore.model.User;
import com.app.retailstore.util.Items;
import com.app.retailstore.util.Role;


@RunWith(SpringJUnit4ClassRunner.class)
public class ItemServiceTest {
	

	
	@InjectMocks
	private ItemServiceImpl itemServiceMock;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindByIdNull(){
		   ItemService itemMock = org.mockito.Mockito.mock(ItemService.class);
		   Set<Item> items = new HashSet<Item>();
		  
		   when(itemMock.populateItems()).thenReturn(items);
		   assertEquals(null, itemMock.findById(1L));
	}
	@Test
	public void testFindById(){
		ItemService itemMock = org.mockito.Mockito.mock(ItemService.class);
		   Set<Item> items = new HashSet<Item>();
		   items.add(new Item(1L, "Bakery", Items.Groceries));
		   
		   when(itemMock.populateItems()).thenReturn(items);
		   assertEquals(Items.Groceries, itemServiceMock.findById(1L).getType());
	}
	
	
	

}
