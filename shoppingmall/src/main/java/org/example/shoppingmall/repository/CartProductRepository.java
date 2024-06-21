package org.example.shoppingmall.repository;

import org.example.shoppingmall.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
}
