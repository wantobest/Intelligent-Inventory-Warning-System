package com.example.inventoryalert.mapper;

import com.example.inventoryalert.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@SuppressWarnings({"all"})
@Mapper
public interface InventoryMapper {
    // 获取所有库存项
    List<Inventory> selectAll();
    
    // 根据ID获取库存项
    Inventory selectById(Long id);
    
    // 更新库存数量
    int updateStock(@Param("id") Long id, @Param("quantity") Integer quantity);
    
    // 查询低于最低库存的项
    List<Inventory> selectLowStockItems();
    
    int insert(Inventory inventory);
    
    int deleteById(Long id);
}