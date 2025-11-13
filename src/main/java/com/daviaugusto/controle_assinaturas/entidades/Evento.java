package com.daviaugusto.controle_assinaturas.entidades;



import com.daviaugusto.controle_assinaturas.enums.StatusPagamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.UUID;


@Entity
public class Evento {

    @Id
    private UUID id;
    private StatusPagamentoEnum status;

    @Lob
    private String data;
    private Boolean eventoProcessado;


    public Evento() {
    }

    public Evento(UUID id, StatusPagamentoEnum status, String data, Boolean eventoProcessado) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.eventoProcessado = eventoProcessado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StatusPagamentoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPagamentoEnum status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getEventoProcessado() {
        return eventoProcessado;
    }

    public void setEventoProcessado(Boolean eventoProcessado) {
        this.eventoProcessado = eventoProcessado;
    }
}
