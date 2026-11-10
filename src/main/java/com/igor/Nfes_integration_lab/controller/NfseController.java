package com.igor.Nfes_integration_lab.controller;

import com.igor.Nfes_integration_lab.dto.request.NfseRequest;
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
    public ResponseEntity<Void> validate(@RequestBody NfseRequest nfseRequest){
        return ResponseEntity.ok().build();
    }
}
