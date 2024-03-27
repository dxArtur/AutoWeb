package com.AutoWeb.entities;

public class ServiceOrder {

	
	private Long id;
	private String description;
	private Double value;
	private String plateVehicle;
	private String cpfCostumer;
	
	
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
	public String getPlateVehicle() {
		return plateVehicle;
	}
	public void setPlateVehicle(String plateVehicle) {
		this.plateVehicle = plateVehicle;
	}
	public String getCpfCostumer() {
		return cpfCostumer;
	}
	public void setCpfCostumer(String cpfCostumer) {
		this.cpfCostumer = cpfCostumer;
	}
	
	
	//implementar data?
	
	//cliente?
}
