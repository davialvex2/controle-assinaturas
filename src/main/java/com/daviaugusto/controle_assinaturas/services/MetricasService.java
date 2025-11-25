package com.daviaugusto.controle_assinaturas.services;

import com.daviaugusto.controle_assinaturas.dtos.PlanoMetricasDTO;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.entidades.Metricas;
import com.daviaugusto.controle_assinaturas.entidades.Plano;
import com.daviaugusto.controle_assinaturas.enums.StatusEnum;
import com.daviaugusto.controle_assinaturas.repositories.AssinaturaRepository;
import com.daviaugusto.controle_assinaturas.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricasService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private AssinaturaRepository assinaturaRepository;


    public Metricas consultarMetricas(){
        List<Assinatura> assinaturas = assinaturaRepository.buscarAssinaturaStatus(StatusEnum.ATIVA.toString());
        List<Assinatura> assinaturasCanceladas = assinaturaRepository.buscarAssinaturaStatus(StatusEnum.CANCELADA.toString());
        Metricas metricas = new Metricas();
        metricas.setTotalGeralAssinates(assinaturas.size());
        metricas.setTotalAssinaturasCanceladas(assinaturasCanceladas.size());
        List<Plano> listaPlanos = planoRepository.findAll();
        List<Plano> lista = listaPlanos.stream().map(this::buscarAssinantesAtivos).toList();
        List<PlanoMetricasDTO> listaDTO = lista.stream().map(x-> new PlanoMetricasDTO(x.getId(), x.getNome(), x.getAssinaturas().size())).toList();
        metricas.setPlano(listaDTO);
        return metricas;
    }

    public Plano buscarAssinantesAtivos(Plano plano){
        List<Assinatura> listaAssinaturas = plano.getAssinaturas();
        plano.setAssinaturas(listaAssinaturas.stream().filter(x -> x.getStatus().equals(StatusEnum.ATIVA)).toList());
        return plano;
    }




}
