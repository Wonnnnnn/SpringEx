package org.example.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public void manipulateQuantity(StockReason reason, int quantity) {
        if(reason == StockReason.A) {
            this.quantity += quantity;
        } else if(reason == StockReason.B) {
            if(this.quantity >= quantity) {
                this.quantity -= quantity;
            }
            else {
                throw new NotEnoughStockException("재고 수량 부족");
            }
        }
    }
}
