package com.app.retailstore.model;

import java.util.Set;

public class Invoice {
	
	private long invoiceId;
	private long userId;
	private Set<Long> items;
	private Double amount;
	
	
	public Invoice(long invoiceId, long userId, Set<Long> items, Double amount) {
		super();
		this.invoiceId = invoiceId;
		this.userId = userId;
		this.items = items;
		this.amount = amount;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Set<Long> getItems() {
		return items;
	}
	public void setItems(Set<Long> items) {
		this.items = items;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	

}
