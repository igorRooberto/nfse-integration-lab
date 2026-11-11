package com.igor.Nfes_integration_lab.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProviderRequest(

        @NotBlank(message = "O CNPJ é obrigatório")
        String cnpj,

        @NotBlank(message = "A inscrição municipal é obrigatória")
        String municipalRegistration
) {
}
