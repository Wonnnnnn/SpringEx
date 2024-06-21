package org.example.shoppingmall.dto;

import lombok.Data;

@Data
public class StockCreateDTO {
    private String warehouse;
    private int productId;
    private int quantity;
}
