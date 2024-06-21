package org.example.shoppingmall.service;

import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.example.shoppingmall.dto.ProductUpdateDTO;
import org.example.shoppingmall.entity.Product;
import org.example.shoppingmall.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productReposotory;


    public List<Product> getAllProducts() {
        return productReposotory.findAll();
    }

    public Product getProductById(int productId) {
        return productReposotory.findById(productId).get();
    }

    @Transactional
    public void addproduct(Product product) {
        productReposotory.save(product);
    }

    @Transactional
    public void updateproduct(ProductUpdateDTO productUpdateDTO) { //status만 변경 가능
        Product product = productReposotory.findById(productUpdateDTO.getProductId()).get();
        product.setStatus(productUpdateDTO.getStatus());
        productReposotory.save(product);

    }
}
