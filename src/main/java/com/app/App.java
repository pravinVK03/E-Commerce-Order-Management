package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // Add this import
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class App {

    public static void main(String[] args) {
        // Capture the context to read actual runtime properties
        ApplicationContext context = SpringApplication.run(App.class, args);
        
        // Get the actual port being used
        String port = context.getEnvironment().getProperty("local.server.port");
        if (port == null) port = "9090"; // Fallback to your intended port

        System.out.println("------------------------------------------------");
        System.out.println("Order Management System is running on http://localhost:" + port);
        System.out.println("------------------------------------------------");
    }
}
