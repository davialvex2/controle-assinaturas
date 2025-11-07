package com.daviaugusto.controle_assinaturas.repositories;

import com.daviaugusto.controle_assinaturas.entidades.Assinatura;
import com.daviaugusto.controle_assinaturas.entidades.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, UUID> {
}
