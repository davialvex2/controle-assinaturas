package com.daviaugusto.controle_assinaturas.entidades;

import com.daviaugusto.controle_assinaturas.enums.CicloFaturamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Plano {

    @Id
    private UUID id;
    private String nome;
    private Double preco;
    private CicloFaturamento cicloFaturamento;
    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL)
    private List<Assinatura> assinaturas = new ArrayList<>();

    public Plano() {
    }

    public Plano(UUID id, String nome, Double preco, CicloFaturamento cicloFaturamento, List<Assinatura> assinaturas) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.cicloFaturamento = cicloFaturamento;
        this.assinaturas = assinaturas;
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

    public List<Assinatura> getAssinaturas() {
        return assinaturas;
    }

    public void setAssinaturas(List<Assinatura> assinaturas) {
        this.assinaturas = assinaturas;
    }
}
