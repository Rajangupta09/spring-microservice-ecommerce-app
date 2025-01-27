package com.project.inventory_service.service;

import com.project.inventory_service.dto.InventoryResponse;
import com.project.inventory_service.model.Inventory;
import com.project.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

//    @Transactional(readOnly = true)
//    public boolean isInStock(String skuCode) {
//        Optional<Inventory> bySkuCode = inventoryRepository.findBySkuCode(skuCode);
//        return bySkuCode.isPresent() && bySkuCode.get().getQuantity() > 0;
//    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStocks(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                      InventoryResponse.builder()
                                       .skuCode(inventory.getSkuCode())
                                       .isInStock(inventory.getQuantity()>0)
                                       .build()
                ).toList();
    }
}
