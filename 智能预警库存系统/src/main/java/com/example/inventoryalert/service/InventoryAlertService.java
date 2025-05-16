package com.example.inventoryalert.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;
@SuppressWarnings({"all"})
@Service
public class InventoryAlertService {
    private final InventoryService inventoryService;
    private final EmailService emailService;
    
    public InventoryAlertService(InventoryService inventoryService, EmailService emailService) {
        this.inventoryService = inventoryService;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 10000)//每10s检查一次
    public void checkLowStockItems() {
        inventoryService.getLowStockItems().forEach(item -> {
            emailService.sendLowStockAlert(
                Arrays.asList(
                        "1274370263@qq.com"
                ),
                item.getProductName(),
                item.getStockQuantity()
            );
        });
    }
}