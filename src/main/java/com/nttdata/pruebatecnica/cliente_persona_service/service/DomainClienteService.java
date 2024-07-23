package com.nttdata.pruebatecnica.cliente_persona_service.service;

import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;
import com.nttdata.pruebatecnica.cliente_persona_service.repository.ClienteRepository;

public class DomainClienteService implements ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public DomainClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
	
	@Override
	public Iterable<ClienteDTO> getClientes() {
		// TODO Auto-generated method stub
		return this.clienteRepository.getClientes();
	}
	
	@Override
	public ClienteDTO getClienteById(Long id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.getClienteById(id).get();
	}

	@Override
	public ClienteDTO saveCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepository.saveCliente(cliente);
	}

	@Override
	public void deleteCliente(Long id) {
		// TODO Auto-generated method stub
		this.clienteRepository.deleteCliente(id);
	}

	@Override
	public ClienteDTO getTermSearch(String search) {
		// TODO Auto-generated method stub
		return this.clienteRepository.getTermSearch(search);
	}

}
