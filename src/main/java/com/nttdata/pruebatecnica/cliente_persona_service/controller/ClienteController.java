package com.nttdata.pruebatecnica.cliente_persona_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.pruebatecnica.cliente_persona_service.exceptions.ResourceNotFoundException;
import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;
import com.nttdata.pruebatecnica.cliente_persona_service.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
    private final ClienteService clienteService;
    
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ClienteDTO>> getClientes(){
        return new ResponseEntity<>(this.clienteService.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id){
        log.info("Id "+id);
        log.info("Cliente {}",this.clienteService.getClienteById(id));
        return new ResponseEntity<>(this.clienteService.getClienteById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDto){
        return new ResponseEntity<>(this.clienteService.saveCliente(clienteDto), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        log.info("Updating client with personaid: {}", clienteDTO.getPersonaid());
        try {
            ClienteDTO updatedCliente = this.clienteService.saveCliente(clienteDTO);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Client with id {} not found", clienteDTO.getPersonaid());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
    	log.info("Deleting client with id: {}", id);
        try {
        	this.clienteService.deleteCliente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            log.error("Client with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
