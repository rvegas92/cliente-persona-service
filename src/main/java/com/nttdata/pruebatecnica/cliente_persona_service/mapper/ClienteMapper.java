package com.nttdata.pruebatecnica.cliente_persona_service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.nttdata.pruebatecnica.cliente_persona_service.entity.Cliente;
import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mappings({
    		@Mapping(source = "personaid", target = "personaid"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "genero", target = "genero"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "identificacion", target = "identificacion"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "contrasenia", target = "contrasenia"),
            @Mapping(source = "estado", target = "estado")
    })
    
    ClienteDTO toClienteDTO(Cliente cliente);
    Iterable<ClienteDTO> toClientes(Iterable<Cliente> cliente);

    @InheritInverseConfiguration
    Cliente toClienteEntity(ClienteDTO clienteDto);

}