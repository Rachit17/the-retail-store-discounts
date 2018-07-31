package com.app.retailstore.model;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Invoice {
	
	@NotNull
	@Min(1)
	private long invoiceId;
	@NotNull
	@Min(1)
	private long userId;
	@NotNull
	private Set<Long> items;
	@NotNull
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
