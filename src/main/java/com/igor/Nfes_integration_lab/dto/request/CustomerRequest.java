package com.igor.Nfes_integration_lab.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(

        @NotBlank(message = "O nome do remetente é obrigatório")
        String name,

        @NotBlank(message = "O número do documento é obrigatório")
        String document
) {
}
