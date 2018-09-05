package tipoDispositivo;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculadoraHorasMesActual {
	
	private static CalculadoraHorasMesActual instancia;
	
	public static CalculadoraHorasMesActual getInstance() {
		if(instancia == null) {
			instancia = new CalculadoraHorasMesActual();
		}
		return instancia;
	}
	
	public long horasDeMesActual() {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime primerDiaDelMes = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), 1, 0, 0);

	    return Duration.between(primerDiaDelMes, hoy).toHours();
	}
}
