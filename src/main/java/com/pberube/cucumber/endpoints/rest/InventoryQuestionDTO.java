package com.pberube.cucumber.endpoints.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InventoryQuestionDTO {    
    @JsonProperty
    private int qtyInStock;
}
