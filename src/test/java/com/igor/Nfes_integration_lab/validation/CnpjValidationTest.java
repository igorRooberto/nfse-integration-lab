package com.igor.Nfes_integration_lab.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CnpjValidationTest {
    private final CnpjValidator validator = new CnpjValidator();

    @Test
    void shouldReturnTrueWhenNumericCnpjIsValid() {
        assertTrue(validator.isValid("11.222.333/0001-81"));
    }

    @Test
    void shouldReturnTrueWhenAlphanumericCnpjIsValid() {
        assertTrue(validator.isValid("12.ABC.345/01DE-35"));
    }

    @Test
    void shouldReturnTrueWhenCnpjHasNoFormatting() {
        assertTrue(validator.isValid("12ABC34501DE35"));
    }

    @Test
    void shouldReturnTrueWhenCnpjContainsLowercaseLetters() {
        assertTrue(validator.isValid("12.abc.345/01de-35"));
    }

    @Test
    void shouldReturnTrueWhenCnpjHasSpacesAtTheEdges() {
        assertTrue(validator.isValid(" 12.ABC.345/01DE-35 "));
    }

    @Test
    void shouldReturnFalseWhenFirstCheckDigitIsInvalid() {
        assertFalse(validator.isValid("12.ABC.345/01DE-45"));
    }

    @Test
    void shouldReturnFalseWhenSecondCheckDigitIsInvalid() {
        assertFalse(validator.isValid("12.ABC.345/01DE-34"));
    }

    @Test
    void shouldReturnFalseWhenCnpjHasInvalidLength() {
        assertFalse(validator.isValid("12.ABC.345/01D-35"));
    }

    @Test
    void shouldReturnFalseWhenCnpjContainsInvalidCharacters() {
        assertFalse(validator.isValid("12#ABC.345/01DE-35"));
    }

    @Test
    void shouldReturnFalseWhenCheckDigitsContainLetters() {
        assertFalse(validator.isValid("12.ABC.345/01DE-AB"));
    }

    @Test
    void shouldReturnFalseWhenCnpjContainsOnlyRepeatedDigits() {
        assertFalse(validator.isValid("00.000.000/0000-00"));
    }

    @Test
    void shouldReturnFalseWhenCnpjIsEmpty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldReturnFalseWhenCnpjIsNull() {
        assertFalse(validator.isValid(null));
    }
}
