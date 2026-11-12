package com.igor.Nfes_integration_lab.validation;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceCodeValidator {

    /*
     * Lista fictícia de códigos de serviço permitidos pelo NFSe Integration Lab.
     *
     * Estes códigos são utilizados exclusivamente para simular validações
     * de regras de negócio durante o processamento de uma NFS-e.
     *
     * Não representam uma tabela oficial da Receita Federal ou dos municípios.
     * Em uma integração real, os códigos e suas regras devem ser obtidos
     * conforme a legislação e as exigências do município/provedor integrado.
     */
    private static final Set<String> ALLOWED_CODES = Set.of(
            "0101",
            "0102",
            "0103"
    );

    public boolean isValid(String serviceCode) {
        if (serviceCode == null || serviceCode.isBlank()) {
            return false;
        }

        return ALLOWED_CODES.contains(serviceCode.trim());
    }
}
