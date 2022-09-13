package com.pberube.cucumber.generator.drd;

import com.pberube.cucumber.drd.EnregistrementLogiqueDRDDesjardinsDto;
import com.pberube.cucumber.drd.FichierLotsDRDDto;
import com.pberube.cucumber.drd.LotDRDDto;
import com.pberube.cucumber.drd.SegmentDRDDto;
import com.pberube.cucumber.generator.DataGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class FichierDrdPayloadGenerator {
    private static final int NOM_FICHIER_LENGTH = 20;
    private static final int NO_ORGANISME_LENGTH = 10;
    private static final int NOM_ABREGE_ORGANISME_LENGTH = 15;
    private static final int NOM_ORGANISME_LENGTH = 30;
    private static final int NO_FICHIER_LENGTH = 4;
    private static final int NO_INSTITUTION_RETOUR_LENGTH = 9;
    private static final int NO_COMPTE_RETOUR_LENGTH = 12;
    private static final int TYPE_OPERATION_LENGTH = 3;
    private static final int NO_INSTITUTION_FINANCIERE_LENGTH = 9;
    private static final int NO_COMPTE_LENGTH = 12;
    private static final int NO_REFERENCE_LENGTH = 19;
    private static final int CHAMP_RESERVE_ORGANISME_LENGTH = 15;
    private static final int CODE_REGLEMENT_LENGTH = 2;
    private static final int NOM_BENEFICIERE_LENGTH = 30;
    private DataGenerator dataGenerator = new DataGenerator();

    public FichierLotsDRDDto generateSimpleFichierDRD() {
        FichierLotsDRDDto dto = new FichierLotsDRDDto();
        dto.addLot(generateSimpleLot());
        dto.addLot(generateSimpleLot());
        return dto;
    }

    private LotDRDDto generateSimpleLot() {
        LotDRDDto lot = LotDRDDto.builder()
                .nomFichier(dataGenerator.getRandomString(NOM_FICHIER_LENGTH-4)+".drd")
                .noOrganisme("1")
                .nomAbregeOrganisme("2")
                .nomOrganisme("3")
                .noFichier("4")
                .dateCreation0aajjj("022180")
                .noInstitutionRetour("5")
                .noCompteRetour("6")
                .enregistrements(generateSimpleEnregistrement())
                .build();
        return lot;
    }

    private List<EnregistrementLogiqueDRDDesjardinsDto> generateSimpleEnregistrement() {
        int initialCapacity = 20;
        ArrayList<EnregistrementLogiqueDRDDesjardinsDto> enregistrementLogiques = new ArrayList<>(initialCapacity);
        for (int i = 0; i < 30; i++) {
            EnregistrementLogiqueDRDDesjardinsDto enregistrementLogique = EnregistrementLogiqueDRDDesjardinsDto.builder()
                    .typeEnregistrementLogique(dataGenerator.getRandomInArray(new String[]{"C", "D"}))
                    .segments(generateSimpleSegments(((int) (random() * 6)) + 1))
                    .build();
            enregistrementLogiques.add(enregistrementLogique);
        }
        return enregistrementLogiques;
    }

    private List<SegmentDRDDto> generateSimpleSegments(int numberToGenerate) {
        ArrayList<SegmentDRDDto> segmentDRDDtos = new ArrayList<>();
        for (int i = 0; i < numberToGenerate; i++) {
            var segmentDRDDto = SegmentDRDDto.builder()
                    .typeOperation("1")
                    .montant(new BigDecimal(1.00))
                    .dateTransaction0aajjj("022180")
                    .nomBeneficiaire("2")
                    .noInstitutionFinanciere("3")
                    .noCompte("4")
                    .noReference("5")
                    .champReserveOrganisme("6")
                    .codeReglement("7")
                    .build();
            segmentDRDDtos.add(segmentDRDDto);
        }
        return segmentDRDDtos;
    }


    public FichierLotsDRDDto genrateFichierDRD() {
        FichierLotsDRDDto dto = new FichierLotsDRDDto();
        dto.addLot(genrateLot());
        dto.addLot(genrateLot());
        return dto;
    }

    private LotDRDDto genrateLot() {
        LotDRDDto dto = LotDRDDto.builder()
                .nomFichier(dataGenerator.getRandomString(NOM_FICHIER_LENGTH-4)+".drd")
                .noOrganisme(dataGenerator.getRandomNumber(NO_ORGANISME_LENGTH))
                .nomAbregeOrganisme(dataGenerator.getRandomString(NOM_ABREGE_ORGANISME_LENGTH))
                .nomOrganisme(dataGenerator.getRandomString(NOM_ORGANISME_LENGTH))
                .noFichier(dataGenerator.getRandomString(NO_FICHIER_LENGTH))
                .dateCreation0aajjj("022180")
                .noInstitutionRetour(dataGenerator.getRandomNumber(NO_INSTITUTION_RETOUR_LENGTH))
                .noCompteRetour(dataGenerator.getRandomString(NO_COMPTE_RETOUR_LENGTH))
                .enregistrements(generateEnregistrement())
                .build();

        return dto;
    }

    private List<EnregistrementLogiqueDRDDesjardinsDto> generateEnregistrement() {

        int initialCapacity = 30;
        ArrayList<EnregistrementLogiqueDRDDesjardinsDto> dtos = new ArrayList<>(initialCapacity);
        for (int i = 0; i < 30; i++) {
            EnregistrementLogiqueDRDDesjardinsDto dto = EnregistrementLogiqueDRDDesjardinsDto.builder()
                    .typeEnregistrementLogique(dataGenerator.getRandomInArray(new String[]{"C", "D"}))
                    .segments(generateSegments(((int) (random() * 6)) + 1))
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }



    private List<SegmentDRDDto> generateSegments(int numberToGenerate) {
        ArrayList<SegmentDRDDto> dtos = new ArrayList<>();
        for (int i = 0; i < numberToGenerate; i++) {
            var dto = SegmentDRDDto.builder()
                    .typeOperation(dataGenerator.getRandomString(TYPE_OPERATION_LENGTH))
                    .montant(dataGenerator.getRandomBigDecimal())
                    .dateTransaction0aajjj("022180")
                    .nomBeneficiaire(dataGenerator.getRandomString(NOM_BENEFICIERE_LENGTH))
                    .noInstitutionFinanciere(dataGenerator.getRandomNumber(NO_INSTITUTION_FINANCIERE_LENGTH))
                    .noCompte(dataGenerator.getRandomString(NO_COMPTE_LENGTH))
                    .noReference(dataGenerator.getRandomString(NO_REFERENCE_LENGTH))
                    .champReserveOrganisme(dataGenerator.getRandomString(CHAMP_RESERVE_ORGANISME_LENGTH))
                    .codeReglement(dataGenerator.getRandomString(CODE_REGLEMENT_LENGTH))
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }
}
