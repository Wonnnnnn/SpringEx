package org.example.shoppingmall.repository;

import org.example.shoppingmall.entity.Product;
import org.example.shoppingmall.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByWarehouseAndProduct(String warehouse, int productId);
    List<Stock> findByWarehouse(String warehouse);
    List<Stock> findByProduct(int productId);
}
