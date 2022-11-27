package AluguelDAO;

import java.sql.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import static org.mockito.Mockito.*;


import rentcarproject.controller.AluguelDAO;
import rentcarproject.models.Aluguel;

public class AluguelTest {

	static AluguelDAO aluguelMock = mock(AluguelDAO.class);
	static Aluguel aluguel = new Aluguel();
	
	
	public void inicializar() {
		
                Date data = new Date(2012,12,12);
            
		aluguel.setId(1);
		aluguel.setNumDiaria(2);
                aluguel.setData(data);
                aluguel.setDataentrega(data);
		aluguel.setMetodoPag("Dinheiro");
		aluguel.setValor(90);
		aluguel.cliente.setCpf("00000000000");
		aluguel.veiculo.setPlaca("ABC0123");
		
	}
	
	@Test
	public void testInclude() {
		
                inicializar();
            
		when(aluguelMock.create(aluguel)).thenReturn("Locacao realizada com sucesso");
		
		String res = aluguelMock.create(aluguel);
		
		assertEquals("Locacao realizada com sucesso", res);
		
	}

	@Test
	public void testValidaCPF() {
		
		when(aluguelMock.validaCPF(anyString())).thenReturn(true);
		
                String res = "";
		
                if(aluguelMock.validaCPF("123456789")){
                    res = "CPF Valido";
                }
		
		assertEquals("CPF Valido",res);
		
	}

	@Test
	public void testDelete(){
            
                inicializar();
		
		when(aluguelMock.delete(aluguel)).thenReturn("Exclusao concluida com sucesso");
		
		String res = aluguelMock.delete(aluguel);
		
		assertEquals("Exclusao concluida com sucesso", res);
		
	}

}
