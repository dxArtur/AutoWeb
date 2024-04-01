package com.AutoWeb.entities;

public class ServiceOrder {

    private Long id;
    private String description;
    private Double value;
    private Vehicle vehicle; // Adicionando o atributo Vehicle
    private String cpfCostumer;
    
    // Getters e setters para os atributos existentes
    // Getters e setters para o novo atributo Vehicle

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getCpfCostumer() {
        return cpfCostumer;
    }

    public void setCpfCostumer(String cpfCostumer) {
        this.cpfCostumer = cpfCostumer;
    }
}
