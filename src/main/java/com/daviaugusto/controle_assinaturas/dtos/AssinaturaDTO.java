package com.daviaugusto.controle_assinaturas.dtos;

import java.util.UUID;

public class AssinaturaDTO {

    private UUID idPlano;
    private String emailCliente;


    public AssinaturaDTO() {
    }

    public AssinaturaDTO(UUID idPlano, String emailCliente) {
        this.idPlano = idPlano;
        this.emailCliente = emailCliente;
    }

    public UUID getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(UUID idPlano) {
        this.idPlano = idPlano;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
