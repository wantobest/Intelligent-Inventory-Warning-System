package com.example.inventoryalert.service;

import com.example.inventoryalert.entity.Inventory;
import com.example.inventoryalert.mapper.InventoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings({"all"})
@Service
public class InventoryService {
    private final InventoryMapper inventoryMapper;

    public InventoryService(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    public List<Inventory> getAllItems() {
        return inventoryMapper.selectAll();
    }

    public List<Inventory> getLowStockItems() {
        return inventoryMapper.selectLowStockItems();
    }

    public void updateStock(Long id, Integer quantity) {
        inventoryMapper.updateStock(id, quantity);
    }

    public int addItem(Inventory inventory) {
        return inventoryMapper.insert(inventory);
    }
    
    public int deleteItem(Long id) {
        return inventoryMapper.deleteById(id);
    }

    public Inventory getItemById(Long id) {
        return inventoryMapper.selectById(id);
    }
}