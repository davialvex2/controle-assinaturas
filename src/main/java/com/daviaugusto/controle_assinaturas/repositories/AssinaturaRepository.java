package com.daviaugusto.controle_assinaturas.repositories;

import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, UUID> {

    Optional<Assinatura> findByEmailCliente(String emailCliente);

}
