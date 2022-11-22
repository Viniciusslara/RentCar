package ClientesDAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rentcarproject.controller.ClienteDAO;
import rentcarproject.models.Cliente;

class testClientes {

	static Cliente cliente = new Cliente();
	static ClienteDAO clienteMock = mock(ClienteDAO.class);
	
	
	@BeforeEach
	void inicializar() {
		 
		cliente.setCnh("00000000000");
		cliente.setCpf("00000000000");
		cliente.setDataNasc("14/04/1999");
		cliente.setId(1);
		cliente.setNome("Vinicius");
		cliente.setTelefone("40028922");

	}
	
	@Test
	void testInclude() {
		
		when(clienteMock.create(cliente)).thenReturn("Cliente cadastrado com sucesso");
		
		var res = clienteMock.create(cliente);
		
		assertEquals("Cliente cadastrado com sucesso", res);
	}

	@Test
	void testUpdate() {
		
		when(clienteMock.update(cliente)).thenReturn("Alterado com sucesso");
		
		var res = clienteMock.update(cliente);
		
		assertEquals("Alterado com sucesso", res);
		
	}
	
	@Test
	void testDelete() {
		
		when(clienteMock.delete(cliente)).thenReturn("Excluido com sucesso");
		
		var res = clienteMock.update(cliente);
		
		assertEquals("Exluido com sucesso", res);
	}
	
}
