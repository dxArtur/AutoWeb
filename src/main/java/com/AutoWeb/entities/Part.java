package com.AutoWeb.entities;

public class Part {
//peça
	
	private Long id;
	private String description;
	private Double value;
	private Integer quantity;
	
    public Part(String description, Double value, Integer quantity) {
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }

    public Part(Long id, String description, Double value, Integer quantity) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
