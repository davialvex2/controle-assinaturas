package com.daviaugusto.controle_assinaturas.controller;

import com.daviaugusto.controle_assinaturas.dtos.AssinaturaDTO;
import com.daviaugusto.controle_assinaturas.dtos.AssinaturaResponseDTO;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.services.AssinaturaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assinatura")
public class AssinaturaController {



    @Autowired
    private AssinaturaService assinaturaService;


    @PostMapping
    public ResponseEntity<Assinatura> criarAssinatura(@RequestBody AssinaturaDTO assinaturaDTO) throws JsonProcessingException {
        return ResponseEntity.ok(assinaturaService.criarAssinatura(assinaturaDTO));
    }

    @DeleteMapping
    public ResponseEntity<AssinaturaResponseDTO> calcelarAssinatura(@RequestParam String emailCliente){
        return ResponseEntity.ok(assinaturaService.cancelarAssinatura(emailCliente));
    }

}
