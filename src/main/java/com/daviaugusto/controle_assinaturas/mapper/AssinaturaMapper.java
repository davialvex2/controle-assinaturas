package com.daviaugusto.controle_assinaturas.mapper;

import com.daviaugusto.controle_assinaturas.dtos.AssinaturaKafkaDTO;
import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssinaturaMapper {


    @Mapping(source = "id", target = "id")
    Assinatura paraAssinatura(AssinaturaKafkaDTO assinaturaDTO);

    @Mapping(source = "id", target = "id")
    AssinaturaKafkaDTO paraDTO(Assinatura assinatura);

}
