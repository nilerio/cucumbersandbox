package com.pberube.cucumber.generator.lot;

import com.pberube.cucumber.generator.DataGenerator;
import com.pberube.cucumber.lot.DetailPaiement;
import com.pberube.cucumber.lot.SauvegarderLot;
import com.pberube.cucumber.lot.SauvegarderLotRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SauvegarderLotRestGenerator {
    DataGenerator gen = new DataGenerator();

    public SauvegarderLotRest genrateSauvegarderLotRest() {
        SauvegarderLotRest sauvegarderLotRest = SauvegarderLotRest.builder()
                .sauvegarderLot(genrateSauvegarder())
                .codeProvenance(gen.getRandomString(5))
                        .build();
        return sauvegarderLotRest;
    }

    private SauvegarderLot genrateSauvegarder() {
        List<DetailPaiement> paiements = generateDetailPaiment(6);
        SauvegarderLot sauvegarderLot = SauvegarderLot.builder()
                .dateProdBanque(new Date())
                .montantCorrections(gen.getRandomBigDecimal())
                .montantFraisCorrections(gen.getRandomBigDecimal())
                .montantFraisPaiements(gen.getRandomBigDecimal())
                .montantPaiements(gen.getRandomBigDecimal())
                .nombreCorrections(gen.getRandomBigDecimal().intValue())
                .nombrePaiements(paiements.size())
                .nomFichierBanque(gen.getRandomString(10))
                .noOrganisme(gen.getRandomString(10))
                .numeroFichierBanque(gen.getRandomString(10))
                .paiements(paiements)
                .build();
        return sauvegarderLot;
    }

    private List<DetailPaiement> generateDetailPaiment(int numberOfPaiments) {
        List paiements = new ArrayList<DetailPaiement>();
        for (int i = 0 ; i < numberOfPaiments; ++i){
            var paiement = DetailPaiement.builder()
                    .datePaiement(new Date())
                    .codeTypeOrigine(gen.getRandomString(1))
                    .montantPaiement(gen.getRandomBigDecimal())
                    .codeTypeTransaction(gen.getRandomString(1))
                    .montantFrais(gen.getRandomBigDecimal())
                    .noCentreService(gen.getRandomString(10))
                    .noInstitutionFinanciere(gen.getRandomString(10))
                    .nomPayeur(gen.getRandomString(10))
                    .noTransitInstitution(gen.getRandomString(10))
                    .reference1(gen.getRandomString(10))
                    .reference2(gen.getRandomString(10))
                    .build();
            paiements.add(paiement);
        }
        return paiements;
    }
}
