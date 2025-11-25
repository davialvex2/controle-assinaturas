package com.daviaugusto.controle_assinaturas.controller;


import com.daviaugusto.controle_assinaturas.entidades.Metricas;
import com.daviaugusto.controle_assinaturas.services.MetricasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metricas")
public class MetricasController {



    @Autowired
    private MetricasService metricasService;


    @GetMapping
    public ResponseEntity<Metricas> buscarMetricas(){
        return ResponseEntity.ok(metricasService.consultarMetricas());
    }

}
