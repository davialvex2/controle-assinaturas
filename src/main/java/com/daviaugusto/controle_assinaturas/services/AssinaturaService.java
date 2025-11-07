package com.daviaugusto.controle_assinaturas.services;

import ch.qos.logback.core.util.Duration;
import com.daviaugusto.controle_assinaturas.dtos.AssinaturaDTO;
import com.daviaugusto.controle_assinaturas.dtos.AssinaturaResponseDTO;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.entidades.Plano;
import com.daviaugusto.controle_assinaturas.enums.CicloFaturamento;
import com.daviaugusto.controle_assinaturas.enums.StatusEnum;
import com.daviaugusto.controle_assinaturas.repositories.AssinaturaRepository;
import com.daviaugusto.controle_assinaturas.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class AssinaturaService {


    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    AssinaturaRepository assinaturaRepository;


    public Assinatura criarAssinatura(AssinaturaDTO assinaturaDTO){
        Plano plano = planoRepository.findById(assinaturaDTO.getIdPlano()).orElseThrow(() -> new RuntimeException("Plano não encontrado"));
        Assinatura assinatura = new Assinatura();
        List<Assinatura> assinantes = plano.getAssinaturas();
        assinatura.setId(UUID.randomUUID());
        assinatura.setStatus(StatusEnum.PEDENTE);
        assinatura.setProximoPagamento(LocalDate.now());
        assinatura.setEmailCliente(assinaturaDTO.getEmailCliente());
        assinatura.setPlano(plano);
        assinantes.add(assinatura);
        plano.setAssinaturas(assinantes);
        planoRepository.save(plano);
        return assinatura;
    }

    public AssinaturaResponseDTO cancelarAssinatura(String emailCliente){
        Assinatura assinatura = assinaturaRepository.findByEmailCliente(emailCliente).orElseThrow(() -> new RuntimeException("Assinatura não encontrada ou inexistente"));
        LocalDate dataAtual = LocalDate.now();
        Long dias = ChronoUnit.DAYS.between(dataAtual, assinatura.getProximoPagamento());
        AssinaturaResponseDTO assinaturaDTO = new AssinaturaResponseDTO();
        assinaturaDTO.setIdCliente(assinatura.getId());
        assinaturaDTO.setDiasRestantes(dias);
        assinaturaRepository.deleteById(assinatura.getId());
        return assinaturaDTO;
    }

    public void atualizarDataPagamento(UUID idAssinatura){
        Assinatura assinatura = assinaturaRepository.findById(idAssinatura).orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));
        if(assinatura.getPlano().getCicloFaturamento().equals(CicloFaturamento.ANUAL)){
            assinatura.setProximoPagamento(LocalDate.now().plusYears(1L));
        }
        else{
            assinatura.setProximoPagamento(LocalDate.now().plusMonths(1L));
        }
    }
}
