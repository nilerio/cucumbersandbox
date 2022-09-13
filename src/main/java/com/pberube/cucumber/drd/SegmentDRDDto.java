package com.pberube.cucumber.drd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SegmentDRDDto {
    private String typeOperation;
    private BigDecimal montant;
    private String nomBeneficiaire;
    private String dateTransaction0aajjj;
    private String noInstitutionFinanciere;
    private String noCompte;
    private String noReference;
    private String champReserveOrganisme;
    private String codeReglement;
}
