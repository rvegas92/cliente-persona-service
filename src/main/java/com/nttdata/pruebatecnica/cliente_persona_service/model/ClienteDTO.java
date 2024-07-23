package com.nttdata.pruebatecnica.cliente_persona_service.model;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private Long personaid;
	private String nombre; 
	private String genero; 
	private Integer edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String contrasenia; 
	private Boolean estado;
    
}
