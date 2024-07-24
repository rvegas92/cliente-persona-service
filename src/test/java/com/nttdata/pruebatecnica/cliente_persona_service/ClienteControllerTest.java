package com.nttdata.pruebatecnica.cliente_persona_service;


import com.nttdata.pruebatecnica.cliente_persona_service.model.ClienteDTO;
import com.nttdata.pruebatecnica.cliente_persona_service.service.ClienteService;
import com.nttdata.pruebatecnica.cliente_persona_service.controller.ClienteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClientes() {
        ClienteDTO cliente1 = new ClienteDTO();
        cliente1.setPersonaid(1L);
        cliente1.setNombre("John");
        cliente1.setGenero("M");
        cliente1.setEdad(30);
        cliente1.setIdentificacion("ID123");
        cliente1.setDireccion("123 Main St");
        cliente1.setTelefono("1234567890");
        cliente1.setContrasenia("password");
        cliente1.setEstado(true);

        ClienteDTO cliente2 = new ClienteDTO();
        cliente2.setPersonaid(2L);
        cliente2.setNombre("Jane");
        cliente2.setGenero("F");
        cliente2.setEdad(25);
        cliente2.setIdentificacion("ID456");
        cliente2.setDireccion("456 Elm St");
        cliente2.setTelefono("0987654321");
        cliente2.setContrasenia("password");
        cliente2.setEstado(true);

        when(clienteService.getClientes()).thenReturn(Arrays.asList(cliente1, cliente2));

        ResponseEntity<Iterable<ClienteDTO>> response = clienteController.getClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, ((List<ClienteDTO>) response.getBody()).size());
    }

    @Test
    public void testGetCliente() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setPersonaid(1L);
        cliente.setNombre("John");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("ID123");
        cliente.setDireccion("123 Main St");
        cliente.setTelefono("1234567890");
        cliente.setContrasenia("password");
        cliente.setEstado(true);

        when(clienteService.getClienteById(anyLong())).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.getCliente(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testSaveCliente() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setPersonaid(1L);
        cliente.setNombre("John");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("ID123");
        cliente.setDireccion("123 Main St");
        cliente.setTelefono("1234567890");
        cliente.setContrasenia("password");
        cliente.setEstado(true);

        when(clienteService.saveCliente(any(ClienteDTO.class))).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.saveCliente(cliente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testActualizarCliente() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setPersonaid(1L);
        cliente.setNombre("John");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("ID123");
        cliente.setDireccion("123 Main St");
        cliente.setTelefono("1234567890");
        cliente.setContrasenia("password");
        cliente.setEstado(true);

        when(clienteService.saveCliente(any(ClienteDTO.class))).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.actualizarCliente(cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteService).deleteCliente(anyLong());

        ResponseEntity<Void> response = clienteController.deleteCliente(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testGetClienteBuscar() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setPersonaid(1L);
        cliente.setNombre("John");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("ID123");
        cliente.setDireccion("123 Main St");
        cliente.setTelefono("1234567890");
        cliente.setContrasenia("password");
        cliente.setEstado(true);

        when(clienteService.getTermSearch(any(String.class))).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.getClienteBuscar("John");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }
}
