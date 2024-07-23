package com.nttdata.pruebatecnica.cliente_persona_service.service;

import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;

public interface ClienteService {
	Iterable<ClienteDTO> getClientes();
	ClienteDTO getClienteById(Long id);
	ClienteDTO saveCliente(ClienteDTO clienteDto);
    void deleteCliente(Long id);
}
