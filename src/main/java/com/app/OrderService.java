package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public String processOrder(Long productId, int quantity) {
        // 1. Fetch Product
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product ID not found!"));

        // 2. Inventory Check
        if (product.getQuantity() < quantity) {
            return "FAILURE: Insufficient stock. Available: " + product.getQuantity();
        }

        // 3. Payment Handling (Simulated)
        boolean paymentAuthorized = (quantity > 0); 
        if (!paymentAuthorized) return "FAILURE: Payment declined.";

        // 4. Update Inventory
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        return "SUCCESS: Order processed! Remaining stock: " + product.getQuantity();
    }
}
