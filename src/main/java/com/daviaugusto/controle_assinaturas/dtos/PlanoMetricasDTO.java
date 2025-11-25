package com.daviaugusto.controle_assinaturas.dtos;

import java.util.UUID;

public class PlanoMetricasDTO {

    private UUID planoID;
    private String nome;
    private Integer assinantesAtivos;


    public PlanoMetricasDTO() {
    }

    public PlanoMetricasDTO(UUID planoID, String nome, Integer assinantesAtivos) {
        this.planoID = planoID;
        this.nome = nome;
        this.assinantesAtivos = assinantesAtivos;
    }

    public UUID getPlanoID() {
        return planoID;
    }

    public void setPlanoID(UUID planoID) {
        this.planoID = planoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAssinantesAtivos() {
        return assinantesAtivos;
    }

    public void setAssinantesAtivos(Integer assinantesAtivos) {
        this.assinantesAtivos = assinantesAtivos;
    }
}
