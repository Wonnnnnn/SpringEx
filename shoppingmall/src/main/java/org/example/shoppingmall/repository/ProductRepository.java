package org.example.shoppingmall.repository;

import org.example.shoppingmall.entity.OrderProduct;
import org.example.shoppingmall.entity.Product;
import org.example.shoppingmall.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStatus(ProductStatus status);
    List<Product> findByProductName(String productName);
}
