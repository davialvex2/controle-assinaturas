package com.daviaugusto.controle_assinaturas.mapper;

import com.daviaugusto.controle_assinaturas.dtos.AssinaturaKafkaDTO;
import com.daviaugusto.controle_assinaturas.dtos.PlanoKafkaDTO;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.entidades.Plano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanoMapper {


    @Mapping(source = "id", target = "id")
    Plano paraPlano(PlanoKafkaDTO planoDTO);


    @Mapping(source = "id", target = "id")
    PlanoKafkaDTO paraDTO(Plano plano);



}
