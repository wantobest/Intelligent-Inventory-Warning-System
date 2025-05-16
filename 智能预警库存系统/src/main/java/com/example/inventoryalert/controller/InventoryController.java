package com.example.inventoryalert.controller;

import com.example.inventoryalert.entity.Inventory;
import com.example.inventoryalert.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/items")
    public List<Inventory> getAll() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/items/low-stock")
    public List<Inventory> getLowStockItems() {
        return inventoryService.getLowStockItems();
    }

    @PutMapping("/{id}/update")
    public String updateStock(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        inventoryService.updateStock(id, request.get("quantity"));
        return "修改成功";
    }

    @PutMapping("/items/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        inventoryService.updateStock(id, request.get("quantity"));
        return "修改成功";
    }

    @GetMapping("/items/{id}")
    public Inventory getItemById(@PathVariable Long id) {
        return inventoryService.getItemById(id);
    }

    @PostMapping("/items")
    public String addItem(@RequestBody Inventory inventory) {
        inventoryService.addItem(inventory);
        return "添加成功";
    }
    
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return "删除成功";
    }
}