package com.daviaugusto.controle_assinaturas.services;


import com.daviaugusto.controle_assinaturas.entidades.Plano;
import com.daviaugusto.controle_assinaturas.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class PlanoService {


    @Autowired
    private PlanoRepository planoRepository;


    public Plano criarPlano(Plano plano){
        if(Objects.isNull(plano)){
            throw new RuntimeException("O Plano não pode ser nulo");
        }
        plano.setId(UUID.randomUUID());
        return planoRepository.save(plano);
    }



}
