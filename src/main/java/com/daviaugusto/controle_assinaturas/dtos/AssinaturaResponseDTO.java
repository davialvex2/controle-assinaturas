package com.daviaugusto.controle_assinaturas.dtos;

import java.util.UUID;

public class AssinaturaResponseDTO {

    private UUID idCliente;
    private Long diasRestantes;

    public AssinaturaResponseDTO(){
    }

    public AssinaturaResponseDTO(UUID idCliente, Long diasRestantes) {
        this.idCliente = idCliente;
        this.diasRestantes = diasRestantes;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public Long getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(Long diasRestantes) {
        this.diasRestantes = diasRestantes;
    }
}
