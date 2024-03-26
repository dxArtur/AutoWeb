package com.AutoWeb.entities;

public class SaleItem {
    
    private Long saleId;
    private Long partId;
    private int quantity;
    
    public Long getSaleId() {
        return saleId;
    }
    
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
    
    public Long getPartId() {
        return partId;
    }
    
    public void setPartId(Long partId) {
        this.partId = partId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
