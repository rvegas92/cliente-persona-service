package com.nttdata.pruebatecnica.cliente_persona_service;

import org.junit.jupiter.api.Test;
import com.nttdata.pruebatecnica.cliente_persona_service.entity.Cliente;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testClienteCreation() {
        // Datos de prueba
        Long id = 1L;
        String nombre = "Jose Lema";
        String genero = "F";
        Integer edad = 30;
        String identificacion = "11111111";
        String direccion = "Otavalo sn y principal";
        String telefono = "098254785";
        String contraseña = "1234";
        Boolean estado = true;

        // Crear objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setPersonaid(id);
        cliente.setNombre(nombre);
        cliente.setGenero(genero);
        cliente.setEdad(edad);
        cliente.setIdentificacion(identificacion);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setContrasenia(contraseña);
        cliente.setEstado(estado);

        // Validar que los campos se establecieron correctamente
        assertEquals(id, cliente.getPersonaid());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(genero, cliente.getGenero());
        assertEquals(edad, cliente.getEdad());
        assertEquals(identificacion, cliente.getIdentificacion());
        assertEquals(direccion, cliente.getDireccion());
        assertEquals(telefono, cliente.getTelefono());
        assertEquals(contraseña, cliente.getContrasenia());
        assertEquals(estado, cliente.getEstado());
    }
}
