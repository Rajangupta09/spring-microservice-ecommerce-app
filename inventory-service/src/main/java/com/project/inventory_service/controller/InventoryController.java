package com.project.inventory_service.controller;

import com.project.inventory_service.dto.InventoryResponse;
import com.project.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

//    @GetMapping("/{sku-code}")
//    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
//        return inventoryService.isInStock(skuCode);
//    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStocks(@RequestParam List<String> skuCode) {
        return inventoryService.isInStocks(skuCode);
    }


}
