package com.nttdata.pruebatecnica.cliente_persona_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.pruebatecnica.cliente_persona_service.entity.Cliente;

public interface ClienteRepositorySqlServer extends JpaRepository<Cliente, Long>{

}
