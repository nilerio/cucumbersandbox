package com.pberube.cucumber.generator.drd;

import com.pberube.cucumber.drd.EnregistrementLogiqueDRDDesjardinsDto;
import com.pberube.cucumber.drd.FichierLotsDRDDto;
import com.pberube.cucumber.drd.LotDRDDto;
import com.pberube.cucumber.drd.SegmentDRDDto;

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

    public FichierLotsDRDDto genrateFichierDRD() {
        FichierLotsDRDDto dto = new FichierLotsDRDDto();
        dto.addLot(genrateLot());
        dto.addLot(genrateLot());
        return dto;
    }

    private LotDRDDto genrateLot() {
        LotDRDDto dto = LotDRDDto.builder()
                .nomFichier(getRandomString(NOM_FICHIER_LENGTH-4)+".drd")
                .noOrganisme(getRandomNumber(NO_ORGANISME_LENGTH))
                .nomAbregeOrganisme(getRandomString(NOM_ABREGE_ORGANISME_LENGTH))
                .nomOrganisme(getRandomString(NOM_ORGANISME_LENGTH))
                .noFichier(getRandomString(NO_FICHIER_LENGTH))
                .dateCreation0aajjj("022180")
                .noInstitutionRetour(getRandomNumber(NO_INSTITUTION_RETOUR_LENGTH))
                .noCompteRetour(getRandomString(NO_COMPTE_RETOUR_LENGTH))
                .enregistrements(generateEnregistrement())
                .build();

        return dto;
    }

    private String getRandomString(int length) {
        String values = "qwertyuiopasdfghjklzxcvbnm0123456789";
        int nbrValues = values.length();
        String value = "";
        for (int i = 0; i < length; i++) {
            int pos = (int) (random() * nbrValues);
            value += values.charAt(pos);
        }
        return value;
    }

    private String getRandomNumber(int length) {
        double number = Math.random();
        String value = String.valueOf(number);
        return value.substring(2, length);
    }

    private List<EnregistrementLogiqueDRDDesjardinsDto> generateEnregistrement() {

        int initialCapacity = 30;
        ArrayList<EnregistrementLogiqueDRDDesjardinsDto> dtos = new ArrayList<>(initialCapacity);
        for (int i = 0; i < 30; i++) {
            EnregistrementLogiqueDRDDesjardinsDto dto = EnregistrementLogiqueDRDDesjardinsDto.builder()
                    .typeEnregistrementLogique(getRandomInArray(new String[]{"C", "D"}))
                    .segments(generateSegments(((int) (random() * 6)) + 1))
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    private String getRandomInArray(String[] strings) {
        int pos = (int) (random() * strings.length);
        return strings[pos];
    }

    private List<SegmentDRDDto> generateSegments(int numberToGenerate) {
        ArrayList<SegmentDRDDto> dtos = new ArrayList<>();
        for (int i = 0; i < numberToGenerate; i++) {
            var dto = SegmentDRDDto.builder()
                    .typeOperation(getRandomString(TYPE_OPERATION_LENGTH))
                    .montant(getRandomBigDecimal())
                    .dateTransaction0aajjj("022180")
                    .noInstitutionFinanciere(getRandomNumber(NO_INSTITUTION_FINANCIERE_LENGTH))
                    .noCompte(getRandomString(NO_COMPTE_LENGTH))
                    .noReference(getRandomString(NO_REFERENCE_LENGTH))
                    .champReserveOrganisme(getRandomString(CHAMP_RESERVE_ORGANISME_LENGTH))
                    .codeReglement(getRandomString(CODE_REGLEMENT_LENGTH))
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    private BigDecimal getRandomBigDecimal() {
        BigDecimal min = new BigDecimal(0);
        BigDecimal max = new BigDecimal(100000);
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
