package dispositivo;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import fixture.Fixture;
import tipoDispositivo.DispositivoInteligente;
import tipoDispositivo.ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandarException;
import tipoDispositivo.NoSePuedeReConvertirAInteligenteException;

public class TestDispositivo extends Fixture {
	
	@Test
	public void candelabroEsInteligenteDespuesDeConvertirseAInteligente() {
		candelabro.convertirAInteligente(mockCandelabroConcreto);
		Assert.assertTrue(candelabro.esInteligente());
	}
	
	@Test
	public void elConsumoDelCandelabroEn1HoraEs9() {
		Assert.assertEquals(9.0, candelabro.estimacionDeConsumoEn(1), 0);
	}
	
	@Test
	public void candelabroNoEsInteligente() {
		Assert.assertFalse(candelabro.esInteligente());
	}

	@Test(expected = ElMensajeEnviadoNoPuedeSerRespondidoPorUnEstandarException.class)
	public void candelabroNoPuedeEstarEnAModoAhorro() {
		candelabro.estaEnAhorroEnergia();
	}
	
	@Test
	public void alApagarSmartTVDispositivoConcretoRecibeMensajeApagar() {
		televisorSmart.apagar();	
		verify(mockTelevisorSmartConcreto, times(1)).apagar();
	}	
	
	@Test
	public void smartTvEsInteligente() {
		Assert.assertTrue(televisorSmart.esInteligente());
	}	
	
	@Test(expected = NoSePuedeReConvertirAInteligenteException.class)
	public void smartTvNoSePuedeConvertirAInteligente() {
		televisorSmart.convertirAInteligente(mockTelevisorSmartConcreto);
	}	

	@Test
	public void consumoDeSmartTVEn1HoraSegunConcretoQueRetorna20DeConsumoEnLaUltimaHoraEs20EnEseLapso() {
		DispositivoConcreto mockDispositivoConcretoRetorna20 = mock(DispositivoConcreto.class);
		when(mockDispositivoConcretoRetorna20.consumoDuranteLasUltimas(1)).thenReturn(20.0);
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(mockDispositivoConcretoRetorna20), 90, new AdaptadorDispositivoSimplex(90, 360));
		Assert.assertEquals(20.0, televisorSmart.consumoEnLasUltimas(1, null), 0);
	}
	
	@Test
	public void plazoMayorAlDelCronDevuelveBienElConsumoGuardado() {
		DispositivoInteligente smartTvAdapter = new DispositivoInteligente(null);
		televisorSmart = new Dispositivo("Televisor Smart", smartTvAdapter, 90, new AdaptadorDispositivoSimplex(90, 360));
		televisorSmart.guardarConsumoDeFecha(LocalDateTime.now().minusHours(6), 30);
		Assert.assertEquals(30, smartTvAdapter.consumoAlmacenadoEn(12), 0);
	}
	
	@Test
	public void elConsumoDesdeLasUltimas12HorasAbarcaAlDelConcretoYElGuardado() {
		DispositivoConcreto mockDispositivoConcretoRetorna20 = mock(DispositivoConcreto.class);
		when(mockDispositivoConcretoRetorna20.consumoDuranteLasUltimas(6)).thenReturn(20.0);
		televisorSmart = new Dispositivo("Televisor Smart", new DispositivoInteligente(mockDispositivoConcretoRetorna20), 90, new AdaptadorDispositivoSimplex(90, 360));
		televisorSmart.guardarConsumoDeFecha(LocalDateTime.now().minusHours(6), 30);
		Assert.assertEquals(50.0, televisorSmart.consumoEnLasUltimas(12, null), 0);
	}
}
