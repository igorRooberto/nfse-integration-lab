package com.igor.Nfes_integration_lab.dto.request;

import java.math.BigDecimal;

public record ServiceRequest(
        String description,
        String serviceCode,
        BigDecimal amount
) {
}
