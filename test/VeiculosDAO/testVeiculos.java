package VeiculosDAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rentcarproject.controller.VeiculosDAO;
import rentcarproject.models.Veiculos;

class testVeiculos {
	
	static Veiculos veiculo = new Veiculos();
	static VeiculosDAO veiculoMock = mock(VeiculosDAO.class);
	
	
	@BeforeEach
	void inicializar() {
		veiculo.setDiaria(90);
		veiculo.setDisponibilidade("DISPONIVEL");
		veiculo.setId(1);
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Mobi");
		veiculo.setPlaca("UTF0123");
	}
	
	@Test
	void testInclude() {
		
		when(veiculoMock.create(veiculo)).thenReturn("Veiculo cadastrado com sucesso");
		
		var res = veiculoMock.create(veiculo);
		
		assertEquals("Veiculo cadastrado com sucesso", res);
	
	}

	@Test
	void testUpdate() {
		
		when(veiculoMock.update(veiculo)).thenReturn("Alterado com sucesso");
		
		var res = veiculoMock.update(veiculo);
		
		assertEquals("Alterado com sucesso", res);
	}
	
	@Test
	void testDelete() {
		
		when (veiculoMock.delete(veiculo)).thenReturn("Excluido com sucesso");
		
		var res = veiculoMock.delete(veiculo);
		
		assertEquals("Excluido com sucesso", res);
	}
	
	
	
	

}
