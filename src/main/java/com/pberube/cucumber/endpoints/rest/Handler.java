package com.pberube.cucumber.endpoints.rest;

import com.pberube.cucumber.drd.FichierLotsDRDDto;
import com.pberube.cucumber.generator.drd.FichierDrdPayloadGenerator;
import com.pberube.cucumber.generator.lot.SauvegarderLotRestGenerator;
import com.pberube.cucumber.lot.SauvegarderLotRest;
import com.pberube.cucumber.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping("rest-api")
public class Handler {

    final InventoryService inventoryService;

    @Autowired
    public Handler(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
/*
    @GetMapping("getQty/{name}")
    public InventoryQuestionDTO getQty(@PathVariable String name) {
        InventoryQuestionDTO inventoryQuestionDTO = new InventoryQuestionDTO();
        inventoryQuestionDTO.setQtyInStock(inventoryService.getQty(name));
        return inventoryQuestionDTO;
    }
*/
    @GetMapping("hello/{name}")
    public HelloDto hello(@PathVariable String name) {
        HelloDto helloDto = new HelloDto();
        helloDto.setName(name);
        return helloDto;
    }

    @GetMapping("generate/DRD")
    public FichierLotsDRDDto generateDrd() {
        return new FichierDrdPayloadGenerator().genrateFichierDRD();
    }

    @GetMapping("generate/Lot")
    public SauvegarderLotRest generateLot() {
        return new SauvegarderLotRestGenerator().genrateSauvegarderLotRest();
    }

}
