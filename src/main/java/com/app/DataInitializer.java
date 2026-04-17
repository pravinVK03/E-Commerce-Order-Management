package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ProductRepository repository;

    public DataInitializer(ProductRepository repository) { this.repository = repository; }

    @Override
    public void run(String... args) {
        Product p = new Product();
        p.setId(1L);
        p.setName("Laptop");
        p.setQuantity(10); // Start with 10 in stock
        repository.save(p);
    }
}
