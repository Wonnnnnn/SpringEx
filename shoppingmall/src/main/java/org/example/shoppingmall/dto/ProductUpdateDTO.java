package org.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shoppingmall.entity.ProductStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
    private int productId;
    private ProductStatus status;
}
