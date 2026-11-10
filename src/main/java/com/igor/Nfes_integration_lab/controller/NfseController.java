package com.igor.Nfes_integration_lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nfse")
public class NfseController {

    @GetMapping("/health")
    public String health(){
        return "NFSe Integration Lab is running!";
    }
}
