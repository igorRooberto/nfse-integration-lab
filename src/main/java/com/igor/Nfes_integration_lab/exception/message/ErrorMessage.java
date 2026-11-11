package com.igor.Nfes_integration_lab.exception.message;

import java.time.Instant;

public record ErrorMessage(
        Instant timeStamp,
        int status,
        String error,
        String message,
        String path
) {
}
