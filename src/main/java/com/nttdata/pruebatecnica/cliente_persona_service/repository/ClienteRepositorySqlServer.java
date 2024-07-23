package com.nttdata.pruebatecnica.cliente_persona_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nttdata.pruebatecnica.cliente_persona_service.entity.Cliente;
public interface ClienteRepositorySqlServer extends JpaRepository<Cliente, Long>{
	
	@Query(nativeQuery = true, value = "select p.*,c.contrasenia, c.estado from persona p join cliente c on p.personaid = c.personaid\r\n"
			+ "where p.nombre like ?1")
    List<Cliente> findBySearchTerm(@Param("search") String search);
}
