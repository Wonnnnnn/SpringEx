package org.example.shoppingmall.service;

import jakarta.persistence.Entity;
import org.example.shoppingmall.entity.Product;
import org.junit.jupiter.api.Test;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Autowired
    private PropertyResolverUtils propertyResolverUtils;

    @Test
    public void addProduct() {
        //given
        Product product = new Product();

        //when
        productService.addproduct(product);
        List<Product> allProducts = productService.getAllProducts();
        //then
        assertThat(allProducts.size()).isEqualTo(1);
    }

}