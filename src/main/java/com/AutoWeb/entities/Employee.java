package com.AutoWeb.entities;

public class Employee {
    // funcionario
    
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String position;
    private Double salary;
    
    public Employee(Long id, String name, String email, String cpf, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.position = position;
        this.salary = salary;
    }
    public Employee() {
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
