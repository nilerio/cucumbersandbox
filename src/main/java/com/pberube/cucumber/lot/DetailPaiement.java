package com.pberube.cucumber.lot;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class DetailPaiement {
    private String codeTypeTransaction;
    private String nomPayeur;
    private String reference1;
    private String reference2;
    private BigDecimal montantPaiement;
    private BigDecimal montantFrais;
    private String codeTypeOrigine;
    private String noInstitutionFinanciere;
    private String noTransitInstitution;
    private String noCentreService;
    private Date datePaiement;
}
