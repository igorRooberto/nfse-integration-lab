package com.igor.Nfes_integration_lab.services;

import com.igor.Nfes_integration_lab.validation.CnpjValidator;
import com.igor.Nfes_integration_lab.validation.CpfValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NfseService {

    private final CpfValidator cpfValidator;
    private final CnpjValidator cnpjValidator;


}
