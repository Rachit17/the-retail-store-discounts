package com.app.retailstore.service;


import java.util.List;

import com.app.retailstore.model.User;

public interface UserService {
	
	User findById(long id);

	List<User> populateUsers();
}
