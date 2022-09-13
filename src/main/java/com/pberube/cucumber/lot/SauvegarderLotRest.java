package com.pberube.cucumber.lot;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SauvegarderLotRest {
    private SauvegarderLot sauvegarderLot;
    private String codeProvenance;
}
