package com.app.retailstore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.app.retailstore.model.User;
import com.app.retailstore.util.Role;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> populateUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Sam", "Rogers", "sam.rogers@gmail.com", LocalDate.of(2015, 02, 20), Role.Employee));
		users.add(new User(counter.incrementAndGet(), "Sam", "Rogers1", "sam.rogers1@gmail.com", LocalDate.of(2017, 02, 20), Role.Employee));
		users.add(new User(counter.incrementAndGet(), "Peter", "Hawkins", "peter.hawkins@gmail.com", LocalDate.of(2016, 02, 20), Role.Affiliate));
		users.add(new User(counter.incrementAndGet(), "Peter", "Hawkins1", "peter.hawkins1@gmail.com", LocalDate.of(2017, 02, 20), Role.Affiliate));
		users.add(new User(counter.incrementAndGet(), "Jerome", "Peters", "jerome.peters@gmail.com", LocalDate.of(2016, 02, 20), Role.General));
		users.add(new User(counter.incrementAndGet(), "Jerome", "Peters1", "jerome.peters1@gmail.com", LocalDate.of(2017, 02, 20), Role.General));
		return users;
	}

}
