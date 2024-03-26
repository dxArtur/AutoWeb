package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.SaleItem;


public class SaleItemDAO {
    private Connection connection;

    public SaleItemDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addSaleItem(SaleItem saleItem) {
        String sql = "INSERT INTO sale_items (sale_id, part_id, quantity) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, saleItem.getSaleId());
            stmt.setLong(2, saleItem.getPartId());
            stmt.setInt(3, saleItem.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSaleItem(SaleItem saleItem) {
        String sql = "UPDATE sale_items SET quantity = ? WHERE sale_id = ? AND part_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, saleItem.getQuantity());
            stmt.setLong(2, saleItem.getSaleId());
            stmt.setLong(3, saleItem.getPartId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SaleItem> getAllSaleItems() {
        List<SaleItem> saleItems = new ArrayList<>();
        String sql = "SELECT * FROM sale_items";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                SaleItem saleItem = new SaleItem();
                saleItem.setSaleId(resultSet.getLong("sale_id"));
                saleItem.setPartId(resultSet.getLong("part_id"));
                saleItem.setQuantity(resultSet.getInt("quantity"));
                saleItems.add(saleItem);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens vendidos: " + e.getMessage());
        }

        return saleItems;
    }

    public void deleteSaleItem(long saleId, long partId) {
        String sql = "DELETE FROM sale_items WHERE sale_id = ? AND part_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, saleId);
            stmt.setLong(2, partId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar item vendido: " + e.getMessage());
        }
    }
}
