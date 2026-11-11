package com.igor.Nfes_integration_lab.exception.message;

import java.time.Instant;
import java.util.List;

public record ValidationErrorMessage(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        List<FieldErrorResponse> details
) {
}
