package com.nttdata.pruebatecnica.cliente_persona_service.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nttdata.pruebatecnica.cliente_persona_service.repository.ClienteRepository;
import com.nttdata.pruebatecnica.cliente_persona_service.service.ClienteService;
import com.nttdata.pruebatecnica.cliente_persona_service.service.DomainClienteService;

@Configuration
public class BeanClienteConfiguration {

    @Bean
    ClienteService clienteBeanService(final ClienteRepository clienteRepository){
        return new DomainClienteService(clienteRepository);
    }
    
}
