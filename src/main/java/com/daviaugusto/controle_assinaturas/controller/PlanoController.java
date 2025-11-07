package com.daviaugusto.controle_assinaturas.controller;

import com.daviaugusto.controle_assinaturas.entidades.Plano;
import com.daviaugusto.controle_assinaturas.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plano")
public class PlanoController {


    @Autowired
    private PlanoService planoService;


    @PostMapping
    public ResponseEntity<Plano> criarPlano(@RequestBody Plano plano){
        return ResponseEntity.ok(planoService.criarPlano(plano));
    }


}
