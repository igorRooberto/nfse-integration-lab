package com.igor.Nfes_integration_lab.validation;

import org.springframework.stereotype.Component;

@Component
public class CpfValidator {

    public boolean isValid(String cpf){

        if (cpf == null) {
            return false;
        }

        String cpfClean = cpf.trim().replaceAll("[.-]", "");

        if(!(cpfClean.length() == 11)){
            return false;
        }

        if(cpfClean.matches("^(\\d)\\1{10}$")){
            return false;
        }

        int firstDigit = calculateFirstDigit(cpfClean);

       String firstTenDigits = cpfClean + firstDigit;

        int secondDigit = calculateSecondDigit(firstTenDigits);

        int firstInformed = Character.getNumericValue(cpfClean.charAt(9));
        int secondInformed = Character.getNumericValue(cpfClean.charAt(10));

        return firstDigit == firstInformed
                && secondDigit == secondInformed;

    }

    private int calculateFirstDigit(String cpf){
        int sum = 0;

        for(int i = 0; i < 9; i++){
            char character = cpf.charAt(i);
            int currentNumber = Character.getNumericValue(character);

            sum += currentNumber * (10 - i);
        }

        int remainder = sum % 11;

        return remainder < 2 ? 0 : 11 - remainder;
    }

    private int calculateSecondDigit(String cpf){
        int sum = 0;

        for(int i = 0; i < 10; i++){
            char character = cpf.charAt(i);
            int currentNumber = Character.getNumericValue(character);

            sum += currentNumber * (11 - i);
        }

        int remainder = sum % 11;

        return remainder < 2 ? 0 : 11 - remainder;
    }


}
