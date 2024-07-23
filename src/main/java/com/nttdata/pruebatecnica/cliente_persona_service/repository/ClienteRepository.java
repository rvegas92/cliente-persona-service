package com.nttdata.pruebatecnica.cliente_persona_service.repository;

import java.util.Optional;

import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;

public interface ClienteRepository {
	Iterable<ClienteDTO> getClientes();
	Optional<ClienteDTO> getClienteById (Long id);
	ClienteDTO saveCliente (ClienteDTO clienteDto);
    void deleteCliente(Long id);
}
