package VeiculosDAO;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import static org.mockito.Mockito.*;


import rentcarproject.controller.VeiculosDAO;
import rentcarproject.models.Veiculos;

public class testVeiculos {
	
	static Veiculos veiculo = new Veiculos();
	static VeiculosDAO veiculoMock = mock(VeiculosDAO.class);
	
	public void inicializar() {
		
		veiculo.setDiaria(90);
		veiculo.setDisponibilidade("DISPONIVEL");
		veiculo.setId(1);
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Mobi");
		veiculo.setPlaca("UTF0123");
	}
	
	@Test
	public void testInclude() {
            
                inicializar();
		
		when(veiculoMock.create(veiculo)).thenReturn("Veiculo cadastrado com sucesso");
		
		String res = veiculoMock.create(veiculo);
		
		assertEquals("Veiculo cadastrado com sucesso", res);
	
	}

	@Test
	public void testUpdate() {
		
                inicializar();
            
		when(veiculoMock.update(veiculo)).thenReturn("Alterado com sucesso");
		
		String res = veiculoMock.update(veiculo);
		
		assertEquals("Alterado com sucesso", res);
	}
	
	@Test
	public void testDelete() {
		
                inicializar();
            
		when (veiculoMock.delete(veiculo)).thenReturn("Excluido com sucesso");
		
		String res = veiculoMock.delete(veiculo);
		
		assertEquals("Excluido com sucesso", res);
	}

}
