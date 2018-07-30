package com.app.retailstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.retailstore.model.Invoice;
import com.app.retailstore.model.Item;
import com.app.retailstore.model.User;
import com.app.retailstore.service.DiscountService;
import com.app.retailstore.service.ItemService;
import com.app.retailstore.service.UserService;
import com.app.retailstore.util.CustomErrorType;

/**
* The Invoice Controller is the application starting point 
* which has a Post method that takes an Invoice Object
* and renders the net payable amount.
* 
*
* @author  Rachit Kakkar
* @version 1.0
* @since   2018-07-30 
*/
@RestController
@RequestMapping("/retailStore")
public class InvoiceController {

	public static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private UserService userService; //Service which will do all data retrieval/manipulation work
	@Autowired
	private DiscountService discountService;
	@Autowired
	private ItemService itemService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/invoice/", method = RequestMethod.POST)
    public ResponseEntity<?> getNetPayable(@RequestBody Invoice invoice, UriComponentsBuilder ucBuilder) {
		   
	        logger.info("Creating Invoice : {}", invoice);
	        
	        //Null check for userId
	        User user = userService.findById(invoice.getUserId());
			if (user == null) {
				logger.error("User with id {} not found.", invoice.getUserId());
				return new ResponseEntity(new CustomErrorType("User with id " + invoice.getUserId()
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			//Null Check for item
			if(invoice.getItems().size()==0)
				return new ResponseEntity(new CustomErrorType("Item Set can't be null"), HttpStatus.NOT_FOUND);
			
			for(Long itemId:invoice.getItems()) {
						   Item item=itemService.findById(itemId);
						   if (item == null) {
								logger.error("Item with id {} not found.", itemId);
								return new ResponseEntity(new CustomErrorType("Item with id " + itemId
										+ " not found"), HttpStatus.NOT_FOUND);
			}
			}
	 
	        Double netPayable=discountService.getNetPayable(invoice);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/retailStore/invoice/{id}").buildAndExpand(invoice.getInvoiceId()).toUri());
	        return new ResponseEntity<Double>(netPayable, HttpStatus.CREATED);
    }

}