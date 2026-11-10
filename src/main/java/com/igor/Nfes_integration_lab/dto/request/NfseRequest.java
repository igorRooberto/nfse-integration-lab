package com.igor.Nfes_integration_lab.dto.request;

public record NfseRequest(
        ProviderRequest providerRequest,
        CustomerRequest customerRequest,
        ServiceRequest serviceRequest
) {
}
