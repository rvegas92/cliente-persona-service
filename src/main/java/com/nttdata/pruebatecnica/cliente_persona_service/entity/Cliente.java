package com.nttdata.pruebatecnica.cliente_persona_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "personaid")
@Getter
@Setter
@ToString
public class Cliente extends Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personaid;
	private String contrasenia; 
	private Boolean estado;
	
}
