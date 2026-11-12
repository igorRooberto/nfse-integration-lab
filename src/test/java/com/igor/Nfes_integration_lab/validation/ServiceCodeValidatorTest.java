package com.igor.Nfes_integration_lab.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceCodeValidatorTest {

    private final ServiceCodeValidator validator =
            new ServiceCodeValidator();

    @Test
    void shouldReturnTrueWhenServiceCodeIsAllowed() {
        assertTrue(validator.isValid("0101"));
    }

    @Test
    void shouldReturnTrueWhenServiceCodeIsAllowedWithSpaces() {
        assertTrue(validator.isValid(" 0102 "));
    }

    @Test
    void shouldReturnFalseWhenServiceCodeIsNotAllowed() {
        assertFalse(validator.isValid("9999"));
    }

    @Test
    void shouldReturnFalseWhenServiceCodeIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalseWhenServiceCodeIsEmpty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldReturnFalseWhenServiceCodeHasInvalidFormat() {
        assertFalse(validator.isValid("ABC1"));
    }

    @Test
    void shouldReturnFalseWhenServiceCodeHasIncorrectLength() {
        assertFalse(validator.isValid("101"));
    }
}
