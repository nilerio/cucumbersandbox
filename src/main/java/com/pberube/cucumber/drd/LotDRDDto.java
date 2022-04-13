package com.pberube.cucumber.drd;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotDRDDto {
    private String nomFichier;
    private String noOrganisme;
    private String nomAbregeOrganisme;
    private String nomOrganisme;
    private String noFichier;
    private String dateCreation0aajjj;
    private String noInstitutionRetour;
    private String noCompteRetour;
    private List<EnregistrementLogiqueDRDDesjardinsDto> enregistrements;
}
