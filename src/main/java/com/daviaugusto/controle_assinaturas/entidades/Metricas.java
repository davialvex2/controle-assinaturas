package com.daviaugusto.controle_assinaturas.entidades;

import com.daviaugusto.controle_assinaturas.dtos.PlanoMetricasDTO;

import java.util.List;

public class Metricas {

    private Integer totalGeralAssinates;
    private Integer totalAssinaturasCanceladas;
    private List<PlanoMetricasDTO> plano;


    public Metricas(){
    }

    public Metricas(Integer totalGeralAssinates, Integer totalAssinaturasCanceladas, List<PlanoMetricasDTO> plano) {
        this.totalGeralAssinates = totalGeralAssinates;
        this.totalAssinaturasCanceladas = totalAssinaturasCanceladas;
        this.plano = plano;
    }

    public Integer getTotalGeralAssinates() {
        return totalGeralAssinates;
    }

    public void setTotalGeralAssinates(Integer totalGeralAssinates) {
        this.totalGeralAssinates = totalGeralAssinates;
    }

    public Integer getTotalAssinaturasCanceladas() {
        return totalAssinaturasCanceladas;
    }

    public void setTotalAssinaturasCanceladas(Integer totalAssinaturasCanceladas) {
        this.totalAssinaturasCanceladas = totalAssinaturasCanceladas;
    }

    public List<PlanoMetricasDTO> getPlano() {
        return plano;
    }

    public void setPlano(List<PlanoMetricasDTO> plano) {
        this.plano = plano;
    }

}
