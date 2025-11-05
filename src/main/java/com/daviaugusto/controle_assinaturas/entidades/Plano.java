package com.daviaugusto.controle_assinaturas.entidades;

import com.daviaugusto.controle_assinaturas.enums.CicloFaturamento;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @OneToMany(mappedBy = "plano")
    private List<Assinaturas> assinaturas = new ArrayList<>();

    public Plano() {
    }

    public Plano(UUID id, String nome, Double preco, CicloFaturamento cicloFaturamento, List<Assinaturas> assinaturas) {
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

    public List<Assinaturas> getAssinaturas() {
        return assinaturas;
    }

    public void setAssinaturas(List<Assinaturas> assinaturas) {
        this.assinaturas = assinaturas;
    }
}
