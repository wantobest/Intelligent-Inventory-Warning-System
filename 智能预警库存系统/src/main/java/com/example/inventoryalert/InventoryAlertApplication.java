package com.example.inventoryalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InventoryAlertApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryAlertApplication.class, args);
    }
}