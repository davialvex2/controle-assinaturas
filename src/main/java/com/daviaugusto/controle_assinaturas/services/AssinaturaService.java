package com.daviaugusto.controle_assinaturas.services;

import ch.qos.logback.core.util.Duration;
import com.daviaugusto.controle_assinaturas.dtos.*;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.entidades.Evento;
import com.daviaugusto.controle_assinaturas.entidades.Plano;
import com.daviaugusto.controle_assinaturas.enums.CicloFaturamento;
import com.daviaugusto.controle_assinaturas.enums.StatusEnum;
import com.daviaugusto.controle_assinaturas.enums.StatusPagamentoEnum;
import com.daviaugusto.controle_assinaturas.mapper.AssinaturaMapper;
import com.daviaugusto.controle_assinaturas.mapper.PlanoMapper;
import com.daviaugusto.controle_assinaturas.repositories.AssinaturaRepository;
import com.daviaugusto.controle_assinaturas.repositories.PlanoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AssinaturaService {


    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, Evento> kafkaTemplate;

    @Autowired
    private AssinaturaMapper assinaturaMapper;

    @Autowired
    private PlanoMapper planoMapper;


    public Assinatura criarAssinatura(AssinaturaDTO assinaturaDTO) throws JsonProcessingException {
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
        Evento evento = new Evento();
        evento.setId(UUID.randomUUID());
        evento.setStatus(StatusPagamentoEnum.ASSINATURA_CRIADA);
        evento.setEventoProcessado(false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        System.out.println(assinatura.getPlano().getNome());
        System.out.println(assinatura.getPlano().getPreco());
        PlanoKafkaDTO planoKafkaDTO = planoMapper.paraDTO(assinatura.getPlano());
        AssinaturaKafkaDTO dto = assinaturaMapper.paraDTO(assinatura);
        dto.setPlano(planoKafkaDTO);
        String jsonString = objectMapper.writeValueAsString(dto);
        evento.setData(jsonString);
        kafkaTemplate.send("assinatura-criada", null, evento);

        return assinatura;
    }

    public AssinaturaResponseDTO cancelarAssinatura(String emailCliente){
        Assinatura assinatura = assinaturaRepository.findByEmailCliente(emailCliente).orElseThrow(() -> new RuntimeException("Assinatura não encontrada ou inexistente"));
        LocalDate dataAtual = LocalDate.now();
        Long dias = ChronoUnit.DAYS.between(dataAtual, assinatura.getProximoPagamento());
        AssinaturaResponseDTO assinaturaDTO = new AssinaturaResponseDTO();
        assinaturaDTO.setIdCliente(assinatura.getId());
        assinaturaDTO.setDiasRestantes(dias);
        assinatura.setStatus(StatusEnum.CANCELADA);
        return assinaturaDTO;
    }


    @KafkaListener(topics = "pagamento-processado")
    public void atualizarDataPagamento(Evento evento) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        System.out.println("Enviando evento: " + objectMapper.writeValueAsString(evento));
        PagamentoDTO pagamentoDTO = objectMapper.readValue(evento.getData(), PagamentoDTO.class);
        Assinatura assinatura = assinaturaRepository.findById(pagamentoDTO.getId_assinatura()).orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));
        if(assinatura.getPlano().getCicloFaturamento().equals(CicloFaturamento.ANUAL)){
            assinatura.setProximoPagamento(LocalDate.now().plusYears(1L));
            assinatura.setStatus(StatusEnum.ATIVA);
            assinaturaRepository.save(assinatura);
        }
        else{
            assinatura.setProximoPagamento(LocalDate.now().plusMonths(1L));
            assinatura.setStatus(StatusEnum.ATIVA);
            assinaturaRepository.save(assinatura);
        }
    }
}
