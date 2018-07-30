package com.app.retailstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.retailstore.service.ItemService;
import com.app.retailstore.service.UserService;

@SpringBootApplication
public class RetailStoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(RetailStoreApplication.class, args);
    }
    
    @Bean
    CommandLineRunner init(UserService userService,ItemService itemService) {
        return (args) -> {
            userService.populateUsers();
            itemService.populateItems();
        };
    }

}
