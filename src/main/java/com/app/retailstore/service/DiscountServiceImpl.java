package com.app.retailstore.service;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.retailstore.model.Invoice;
import com.app.retailstore.util.Items;
import com.app.retailstore.util.Role;


@Service("discountService")
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	
	public static final double employeeDiscount   = 30.0;
	public static final double affiliateDiscount   = 10.0;
	public static final double oldCustomerDiscount   = 5.0;

	/**
	* This method performs the calculation as per the user
	* role,user longevity ,item type and bill amount.
	* Returns net payable amount.
	* 
	*
	* @author  Rachit Kakkar
	* @version 1.0
	* @since   2018-07-30 
	*/
	public Double getNetPayable(Invoice invoice) {
		
		   Double amount=invoice.getAmount();
           Double netPayable=0.0;
		   Double intermediatePrice=0.0;
		   
		   
		   intermediatePrice=amount-getDiscountByAmount(amount);
		   netPayable=intermediatePrice;
		   
		   for(Long itemId:invoice.getItems()) {
			   Items itemType=itemService.findById(itemId).getType();
			   if(!itemType.equals(Items.Groceries))
				   netPayable=intermediatePrice-intermediatePrice*(getDiscountByUser(invoice.getUserId())/100);
		   }
		   
			
			return netPayable;
		}

	@Override
	public Double getDiscountByUser(Long userId) {
		   Double userDiscount=0.0;
		   boolean isOldCustomer=false;
		   
		   Role userRole = userService.findById(userId).getRole();
		   LocalDate creationDate = userService.findById(userId).getCreatedDate();
		   LocalDate currentDate = LocalDate.now();
		     
	       Period intervalPeriod = Period.between(creationDate, currentDate);
	       
	       isOldCustomer=(intervalPeriod.getYears()>=2) && (intervalPeriod.getDays()>0 || intervalPeriod.getMonths()>0);
		   
		   // Returning higher of two discounts
	       if((userRole.equals(Role.Employee) && isOldCustomer) || userRole.equals(Role.Employee))
			   userDiscount=employeeDiscount;
		   else if(userRole.equals(Role.Affiliate) && isOldCustomer || userRole.equals(Role.Affiliate))
			   userDiscount=affiliateDiscount;
		   else if(isOldCustomer)
			   userDiscount=oldCustomerDiscount;
		   return userDiscount;
	}


	@Override
	public Integer getDiscountByAmount(Double amount) {
		   return 5*(amount.intValue()/100);
		   
	}


	
}
