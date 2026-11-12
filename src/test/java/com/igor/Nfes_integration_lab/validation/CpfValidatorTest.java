package com.igor.Nfes_integration_lab.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfValidatorTest {

    private final CpfValidator validator = new CpfValidator();

    @Test
    void shouldReturnTrueWhenCpfIsValid() {
        assertTrue(validator.isValid("529.982.247-25"));
    }

    @Test
    void shouldReturnTrueWhenCpfHasNoFormatting() {
        assertTrue(validator.isValid("52998224725"));
    }

    @Test
    void shouldReturnTrueWhenCpfHasSpacesAtTheEdges() {
        assertTrue(validator.isValid(" 529.982.247-25 "));
    }

    @Test
    void shouldReturnFalseWhenFirstCheckDigitIsInvalid() {
        assertFalse(validator.isValid("529.982.247-35"));
    }

    @Test
    void shouldReturnFalseWhenSecondCheckDigitIsInvalid() {
        assertFalse(validator.isValid("529.982.247-24"));
    }

    @Test
    void shouldReturnFalseWhenCpfHasInvalidLength() {
        assertFalse(validator.isValid("529.982.247-2"));
    }

    @Test
    void shouldReturnFalseWhenCpfContainsLetters() {
        assertFalse(validator.isValid("529.982.24A-25"));
    }

    @Test
    void shouldReturnFalseWhenCpfContainsInvalidCharacters() {
        assertFalse(validator.isValid("529#982#247-25"));
    }

    @Test
    void shouldReturnFalseWhenCpfContainsOnlyRepeatedZeros() {
        assertFalse(validator.isValid("000.000.000-00"));
    }

    @Test
    void shouldReturnFalseWhenCpfContainsOnlyRepeatedOnes() {
        assertFalse(validator.isValid("111.111.111-11"));
    }

    @Test
    void shouldReturnFalseWhenCpfIsEmpty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldReturnFalseWhenCpfContainsOnlySpaces() {
        assertFalse(validator.isValid("   "));
    }

    @Test
    void shouldReturnFalseWhenCpfIsNull() {
        assertFalse(validator.isValid(null));
    }
}
