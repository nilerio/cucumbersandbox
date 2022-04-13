package com.pberube.cucumber.drd;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class FichierLotsDRDDto {

    List<LotDRDDto> lots = new ArrayList<>();

    public List<LotDRDDto> getLots() {
        return lots;
    }

    public void setLots(List<LotDRDDto> lots) {
        this.lots = lots;
    }

    public void addLot(LotDRDDto lot) {
        lots.add(lot);
    }

    @Override
    public String toString() {
        return "FichierLotsDRDDesjardinsDto [lots=" + lots + "]";
    }

}