package org.example.shoppingmall.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.shoppingmall.entity.Product;
import org.example.shoppingmall.entity.Stock;
import org.example.shoppingmall.entity.StockReason;
import org.example.shoppingmall.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockService {
    private final StockRepository stockRepository;

    public List<Stock> getAllStockByWarehouse(String warehouse) {
        return stockRepository.findByWarehouse(warehouse);
    }
    public List<Stock> getAllStockByProductId(int productId) {
        return stockRepository.findByProduct(productId);
    }

    @Transactional
    public int addStock(Stock stock) {
        return stockRepository.save(stock).getId();
    }

    @Transactional
    public void increaseStock(String warehouse, int productId, int quantity) {
        Stock temp = stockRepository.findByWarehouseAndProduct(warehouse, productId);
        temp.manipulateQuantity(StockReason.A, quantity);
    }

    @Transactional
    public void decreaseStock(String warehouse, int productId, int quantity) {
        Stock temp = stockRepository.findByWarehouseAndProduct(warehouse, productId);
        temp.manipulateQuantity(StockReason.B, quantity);
    }
}
