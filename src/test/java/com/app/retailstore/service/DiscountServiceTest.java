package com.app.retailstore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.retailstore.model.User;
import com.app.retailstore.util.Role;


@RunWith(SpringJUnit4ClassRunner.class)
public class DiscountServiceTest {
	

	
	@InjectMocks
	private UserServiceImpl userServiceMock;
	@InjectMocks
	private ItemServiceImpl itemServiceMock;
	@InjectMocks
	private DiscountServiceImpl discountServiceMock;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetDiscountByAmount100(){
		  Integer expectedDiscount = 5;
	      assertEquals(expectedDiscount, discountServiceMock.getDiscountByAmount(100.0));
	}
	@Test
	public void testGetDiscountByAmountLessThan100(){
		  Integer expectedDiscount = 0 ;
	      assertEquals(expectedDiscount, discountServiceMock.getDiscountByAmount(99.0));
	}
//	@Test
//	public void testGetDiscountByUserEmployee(){
//		   UserService userMock = org.mockito.Mockito.mock(UserService.class);
//		   DiscountService discountMock = org.mockito.Mockito.mock(DiscountServiceImpl.class);
//		   List<User> users = new ArrayList<User>();
//		   users.add(new User(1L, "Sam", "Rogers", "sam.rogers@gmail.com", LocalDate.of(2015, 02, 20), Role.Employee));
//		   when(userServiceMock.populateUsers()).thenReturn(users);
//		   //discountServiceMock.getDiscountByUser(1L);
//		   
//		   Double employeeDiscount = 30.0 ;
//	       //assertEquals(employeeDiscount, discountMock.getDiscountByUser(1L));
//	}
//	
	

}
