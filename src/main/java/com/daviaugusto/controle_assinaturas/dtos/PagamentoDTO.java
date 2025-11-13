package com.daviaugusto.controle_assinaturas.dtos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;


public class PagamentoDTO {

    private UUID id;
    private UUID id_assinatura;
    private String evento;
    private Double valor;
    private LocalDate data;


    public PagamentoDTO() {
    }

    public PagamentoDTO(UUID id_assinatura, String evento, Double valor, LocalDate data) {
        this.id_assinatura = id_assinatura;
        this.evento = evento;
        this.valor = valor;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_assinatura() {
        return id_assinatura;
    }

    public void setId_assinatura(UUID id_assinatura) {
        this.id_assinatura = id_assinatura;
    }

    public String getEvento() {
        return evento;
    }

}
