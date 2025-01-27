package com.project.inventory_service.service;

import com.project.inventory_service.model.Inventory;
import com.project.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> bySkuCode = inventoryRepository.findBySkuCode(skuCode);
        return bySkuCode.isPresent() && bySkuCode.get().getQuantity() > 0;
    }
}
