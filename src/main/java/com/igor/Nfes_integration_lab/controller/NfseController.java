package com.igor.Nfes_integration_lab.controller;

import com.igor.Nfes_integration_lab.dto.request.NfseRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfse")
public class NfseController {

    @GetMapping("/health")
    public String health(){
        return "NFSe Integration Lab is running!";
    }

    @PostMapping("/validate")
    public ResponseEntity<Void> validate(@RequestBody @Valid NfseRequest nfseRequest){
        return ResponseEntity.ok().build();
    }
}
