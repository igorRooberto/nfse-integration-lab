package com.igor.Nfes_integration_lab.dto.request;

import jakarta.validation.Valid;

public record NfseRequest(

        @Valid
        ProviderRequest provider,

        @Valid
        CustomerRequest customer,

        @Valid
        ServiceRequest service
) {
}
