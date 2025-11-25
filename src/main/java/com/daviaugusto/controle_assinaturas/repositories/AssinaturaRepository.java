package com.daviaugusto.controle_assinaturas.repositories;

import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, UUID> {

    Optional<Assinatura> findByEmailCliente(String emailCliente);

    @Query(value = "SELECT * FROM assinatura WHERE status = :tipoStatus", nativeQuery = true)
    List<Assinatura> buscarAssinaturaStatus(@Param("tipoStatus")String tipoStatus);

}
