package com.AutoWeb.entities;

public class Sale {
	
	private Long id;
	private Double value;
	private String customerCpf;
	private Long idItems;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getCustomerCpf() {
		return customerCpf;
	}
	public void setCustomerCpf(User customer) {
		this.customerCpf = customer.getCpf();
	}
	public Long getIdItems() {
		return idItems;
	}
	public void setIdItems(Long idItems) {
		this.idItems = idItems;
	}
}
