package com.igor.Nfes_integration_lab.exception.message;

public record FieldErrorResponse(
        String field,
        String message
) {
}
