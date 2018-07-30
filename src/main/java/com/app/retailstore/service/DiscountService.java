package com.app.retailstore.service;

import com.app.retailstore.model.Invoice;


public interface DiscountService {
	
	Double  getNetPayable(Invoice invoice);
	Double  getDiscountByUser(Long userId);
	Integer getDiscountByAmount(Double amount);
	

}
