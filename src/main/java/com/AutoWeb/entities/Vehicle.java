package com.AutoWeb.entities;

public class Vehicle {
    // veiculo
    
    private String model;
    private Integer manufactureYear;
    private String plate;
    
    public Vehicle(String plate, String model, Integer manufactureYear) {
        this.plate = plate;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }
    
    // Getters e setters
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getManufactureYear() {
        return manufactureYear;
    }
    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
}
