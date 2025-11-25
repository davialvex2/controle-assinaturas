package com.daviaugusto.controle_assinaturas.dtos;

import com.daviaugusto.controle_assinaturas.enums.CicloFaturamento;

import java.util.UUID;

public class PlanoKafkaDTO {

    private UUID id;
    private String nome;
    private Double preco;
    private CicloFaturamento cicloFaturamento;

    public PlanoKafkaDTO() {
    }

    public PlanoKafkaDTO(UUID id, String nome, Double preco, CicloFaturamento cicloFaturamento) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.cicloFaturamento = cicloFaturamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public CicloFaturamento getCicloFaturamento() {
        return cicloFaturamento;
    }

    public void setCicloFaturamento(CicloFaturamento cicloFaturamento) {
        this.cicloFaturamento = cicloFaturamento;
    }
}
