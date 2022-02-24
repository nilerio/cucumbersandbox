package com.pberube.cucumber.endpoints.rest;

import com.pberube.cucumber.services.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("rest-api")
public class Handler {

    final InventoryService inventoryService;

    @Autowired
    public Handler(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("getQty/{name}")
    public InventoryQuestionDTO getQty(@PathVariable String name){
        InventoryQuestionDTO inventoryQuestionDTO = new InventoryQuestionDTO();
        inventoryQuestionDTO.setQtyInStock(inventoryService.getQty(name));
        return inventoryQuestionDTO;
    }

}
