package com.igor.Nfes_integration_lab.validation;

import org.springframework.stereotype.Component;

@Component
public class CnpjValidator {

    private static final int[] FIRST_WEIGHTS =
            {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static final int[] SECOND_WEIGHTS =
            {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public boolean isValid(String cnpj) {
        if (cnpj == null) {
            return false;
        }

        String cnpjClean = cnpj
                .trim()
                .replace(".", "")
                .replace("/", "")
                .replace("-", "")
                .toUpperCase();

        if (!cnpjClean.matches("[A-Z0-9]{12}\\d{2}")) {
            return false;
        }

        if (cnpjClean.matches("(.)\\1{13}")) {
            return false;
        }

        String base = cnpjClean.substring(0, 12);

        int firstDigit = calculateCheckDigit(base, FIRST_WEIGHTS);

        String baseWithFirstDigit = base + firstDigit;

        int secondDigit = calculateCheckDigit(
                baseWithFirstDigit,
                SECOND_WEIGHTS
        );

        int informedFirstDigit =
                Character.getNumericValue(cnpjClean.charAt(12));

        int informedSecondDigit =
                Character.getNumericValue(cnpjClean.charAt(13));

        return firstDigit == informedFirstDigit
                && secondDigit == informedSecondDigit;
    }

    private int calculateCheckDigit(String value, int[] weights) {
        int sum = 0;

        for (int i = 0; i < value.length(); i++) {
            int characterValue = value.charAt(i) - 48;
            sum += characterValue * weights[i];
        }

        int remainder = sum % 11;

        return remainder < 2 ? 0 : 11 - remainder;
    }
}

