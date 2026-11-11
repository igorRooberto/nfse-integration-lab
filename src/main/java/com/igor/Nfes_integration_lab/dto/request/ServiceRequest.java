package com.igor.Nfes_integration_lab.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ServiceRequest(

        @NotBlank(message = "A descrição do serviço é obrigatória")
        String description,

        @NotBlank(message = "o codigo do serviço é obrigatório")
        String serviceCode,

        @NotNull(message = "o valor do serviço é obrigatório")
        @Positive(message = "o valor do serviço deve ser maior que zero")
        BigDecimal amount
) {
}
