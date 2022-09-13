package com.pberube.cucumber.generator;

import java.math.BigDecimal;

import static java.lang.Math.random;

public class DataGenerator {
    public String getRandomString(int length) {
        String values = "qwertyuiopasdfghjklzxcvbnm0123456789";
        int nbrValues = values.length();
        String value = "";
        for (int i = 0; i < length; i++) {
            int pos = (int) (random() * nbrValues);
            value += values.charAt(pos);
        }
        return value;
    }

    public String getRandomNumber(int length) {
        String values = "0123456789";
        int nbrValues = values.length();
        String value = "";
        for (int i = 0; i < length; i++) {
            int pos = (int) (random() * nbrValues);
            value += values.charAt(pos);
        }
        return value;
    }

    public String getRandomInArray(String[] strings) {
        int pos = (int) (random() * strings.length);
        return strings[pos];
    }

    public BigDecimal getRandomBigDecimal() {
        BigDecimal min = new BigDecimal(0);
        BigDecimal max = new BigDecimal(100000);
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
