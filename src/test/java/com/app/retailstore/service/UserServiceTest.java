package com.app.retailstore.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.retailstore.model.User;
import com.app.retailstore.util.Role;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	

	
	@InjectMocks
	private UserServiceImpl userServiceMock;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindByIdNull(){
		   UserService userMock = org.mockito.Mockito.mock(UserService.class);
		   List<User> users = new ArrayList<User>();
		   when(userMock.populateUsers()).thenReturn(users);
		   assertEquals(null, userMock.findById(1L));
	}
	@Test
	public void testFindById(){
		   UserService userMock = org.mockito.Mockito.mock(UserService.class);
		   List<User> users = new ArrayList<User>();
		   users.add(new User(1L, "Sam", "Rogers", "sam.rogers@gmail.com", LocalDate.of(2015, 02, 20), Role.Employee));
		   when(userMock.populateUsers()).thenReturn(users);
		   
		  
	       assertEquals(Role.Employee, userServiceMock.findById(1L).getRole());
	}
	
	
	

}
