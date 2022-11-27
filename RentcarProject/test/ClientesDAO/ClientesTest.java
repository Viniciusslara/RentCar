package ClientesDAO;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;


import rentcarproject.controller.ClienteDAO;
import rentcarproject.models.Cliente;

public class ClientesTest {

	static Cliente cliente = new Cliente();
	static ClienteDAO clienteMock = mock(ClienteDAO.class);
	
	public void inicializar() {
		 
		cliente.setCnh("00000000000");
		cliente.setCpf("00000000000");
		cliente.setDataNasc("14/04/1999");
		cliente.setId(1);
		cliente.setNome("Vinicius");
		cliente.setTelefone("40028922");

	}
	
	@Test
	public void testInclude() {
		
                inicializar();
            
		when(clienteMock.create(cliente)).thenReturn("Cliente cadastrado com sucesso");
		
		String res = clienteMock.create(cliente);
		
		assertEquals("Cliente cadastrado com sucesso", res);
	}

	@Test
	public void testUpdate() {
		
                inicializar();
            
		when(clienteMock.update(cliente)).thenReturn("Alterado com sucesso");
		
		String res = clienteMock.update(cliente);
		
		assertEquals("Alterado com sucesso", res);
		
	}
	
	@Test
	public void testDelete() {
		
                inicializar();
                
		when(clienteMock.delete(cliente)).thenReturn("Excluido com sucesso");
		
		String res = clienteMock.delete(cliente);
		
		assertEquals("Excluido com sucesso", res);
	}
	
}
