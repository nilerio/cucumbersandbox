package com.pberube.cucumber.lot;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class SauvegarderLot {
    private String noOrganisme;
    private String numeroFichierBanque;
    private String nomFichierBanque;
    private Date dateProdBanque;
    private Integer nombrePaiements;
    private BigDecimal montantPaiements;
    private BigDecimal montantFraisPaiements;
    private Integer nombreCorrections;
    private BigDecimal montantCorrections;
    private BigDecimal montantFraisCorrections;
    private List<DetailPaiement> paiements;
}
