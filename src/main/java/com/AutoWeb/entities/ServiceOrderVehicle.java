package com.AutoWeb.entities;

public class ServiceOrderVehicle {
	private Long id;
	private Long orderId;
	private String plateVehicle;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getPlateVehicle() {
		return plateVehicle;
	}
	public void setPlateVehicle(String plateVehicle) {
		this.plateVehicle = plateVehicle;
	}
	
}
