package com.daviaugusto.controle_assinaturas.dtos;

import com.daviaugusto.controle_assinaturas.enums.StatusEnum;

import java.time.LocalDate;
import java.util.UUID;

public class AssinaturaKafkaDTO {


    private UUID id;
    private String emailCliente;
    private StatusEnum status;
    private LocalDate proximoPagamento;
    private PlanoKafkaDTO plano;

    public AssinaturaKafkaDTO() {
    }

    public AssinaturaKafkaDTO(UUID id, String emailCliente, StatusEnum status, LocalDate proximoPagamento, PlanoKafkaDTO plano) {
        this.id = id;
        this.emailCliente = emailCliente;
        this.status = status;
        this.proximoPagamento = proximoPagamento;
        this.plano = plano;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDate getProximoPagamento() {
        return proximoPagamento;
    }

    public void setProximoPagamento(LocalDate proximoPagamento) {
        this.proximoPagamento = proximoPagamento;
    }

    public PlanoKafkaDTO getPlano() {
        return plano;
    }

    public void setPlano(PlanoKafkaDTO plano) {
        this.plano = plano;
    }
}
