package com.nttdata.pruebatecnica.cliente_persona_service.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}
