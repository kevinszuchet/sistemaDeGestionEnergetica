package dispositivo.gadgets.actuador;

import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fixture.Fixture;
import tipoDispositivo.ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandar;

public class TestActuadores extends Fixture {
    
    @Test
    public void elActuadorQueApagaHaceQueSeEnvieLaSe�alDeApagado() {
		actuadorQueApaga.actuarSobre(pc);
		verify(mockFabricante, times(1)).apagar(101010);
    }
    
    @Test
    public void elActuadorQueEnciendeHaceQueSeEnvieLaSe�alDeApagado() {
		actuadorQueEnciende.actuarSobre(pc);    	
		verify(mockFabricante, times(1)).encender(101010);
    }   
}


