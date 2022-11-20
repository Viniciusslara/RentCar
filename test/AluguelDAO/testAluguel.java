package AluguelDAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rentcarproject.controller.AluguelDAO;
import rentcarproject.models.Aluguel;

class testAluguel {

	static AluguelDAO aluguelMock = mock(AluguelDAO.class);
	static Aluguel aluguel = new Aluguel();
	
	@BeforeEach
	void inicializar() throws ParseException {
		
		String date = "10/10/2022";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		aluguel.setId(1);
		aluguel.setDataentrega(formato.parse(date));
		aluguel.setData((Date) formato.parse(date));
		aluguel.setNumDiaria(2);
		aluguel.setMetodoPag("Dinheiro");
		aluguel.setValor(90);
		aluguel.cliente.setCpf("00000000000");
		aluguel.veiculo.setPlaca("ABC0123");
		
	}
	
	@Test
	void testInclude() {
		
		when(aluguelMock.create(aluguel)).thenReturn("Locacao realizada com sucesso");
		
		var res = aluguelMock.create(aluguel);
		
		assertEquals("Locacao realizada com sucesso", res);
		
	}

	@Test
	void testValidaCPF() {
		
		when(aluguelMock.validaCPF(anyString())).thenReturn(true);
		
		var res = aluguelMock.validaCPF("123456789");
		
		assertTrue(res);
		
	}

	@Test
	void testDelete() {
		
		when(aluguelMock.delete(aluguel)).thenReturn("Exclusao concluida com sucesso");
		
		var res = aluguelMock.delete(aluguel);
		
		assertEquals("Exclusao concluida com sucesso", res);
		
	}

}
