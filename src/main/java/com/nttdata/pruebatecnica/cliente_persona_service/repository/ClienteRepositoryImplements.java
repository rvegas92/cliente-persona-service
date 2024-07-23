package com.nttdata.pruebatecnica.cliente_persona_service.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.nttdata.pruebatecnica.cliente_persona_service.entity.Cliente;
import com.nttdata.pruebatecnica.cliente_persona_service.exceptions.ResourceNotFoundException;
import com.nttdata.pruebatecnica.cliente_persona_service.mapper.ClienteMapper;
import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ClienteRepositoryImplements implements ClienteRepository {
	
	private final ClienteRepositorySqlServer clienteRepositorySqlServer;
	private final ClienteMapper clienteMapper;
	
	public ClienteRepositoryImplements(ClienteRepositorySqlServer clienteRepositorySqlServer, ClienteMapper clienteMapper) {
        this.clienteRepositorySqlServer = clienteRepositorySqlServer;
        this.clienteMapper = clienteMapper;
    }
	
	@Override
	public Iterable<ClienteDTO> getClientes() {
		// TODO Auto-generated method stub
		log.info("Fetching all clientes");
		return this.clienteMapper.toClientes(this.clienteRepositorySqlServer.findAll());
	}
	
	@Override
	public Optional<ClienteDTO> getClienteById(Long id) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepositorySqlServer.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.clienteMapper.toClienteDTO(cliente));
	}

	@Override
	public ClienteDTO saveCliente(ClienteDTO clienteDto) {
		Cliente cliente = this.clienteMapper.toClienteEntity(clienteDto);
        System.out.println("Id persona: "+ cliente.getPersonaid());
        return this.clienteMapper.toClienteDTO(this.clienteRepositorySqlServer.save(cliente));
	}

	@Override
	public void deleteCliente(Long id) {
		Cliente productEntity = this.clienteRepositorySqlServer.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.clienteRepositorySqlServer.deleteById(productEntity.getPersonaid());
	}

}
