package com.daviaugusto.controle_assinaturas.entidades;

import com.daviaugusto.controle_assinaturas.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Assinatura {

    @Id
    private UUID id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "plano_id")
    private Plano plano;
    private String emailCliente;
    private StatusEnum status;
    private LocalDate proximoPagamento;


    public Assinatura() {
    }

    public Assinatura(UUID id, Plano plano, String emailCliente, StatusEnum status, LocalDate proximoPagamento) {
        this.id = id;
        this.plano = plano;
        this.emailCliente = emailCliente;
        this.status = status;
        this.proximoPagamento = proximoPagamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
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
}
