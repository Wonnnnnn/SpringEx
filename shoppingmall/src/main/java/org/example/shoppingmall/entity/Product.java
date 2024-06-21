package org.example.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(length = 20)
    private String productName;
    private int cost;  //구입 가격
    private int price; //판매 가격

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    //상품 등록일, 상태 변경일, ...
}
