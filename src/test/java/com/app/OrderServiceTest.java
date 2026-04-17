package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void testOrderSuccess() {
        // Product 1 is initialized with 10 units in DataInitializer
        String result = orderService.processOrder(1L, 5);
        assertTrue(result.contains("SUCCESS"), "Order should succeed when stock is available");
    }

    @Test
    void testOrderFailureInsufficientStock() {
        // Trying to buy 100 units when only 10 are available (or 5 left from previous test)
        String result = orderService.processOrder(1L, 100);
        assertTrue(result.contains("FAILURE"), "Order should fail when stock is insufficient");
    }
}
