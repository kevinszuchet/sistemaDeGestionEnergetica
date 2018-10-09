package tipoDispositivo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;


@Embeddable
public class ConsumoEnFecha {
	
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime fecha;
	
	@Column(nullable = false)
	private Double consumo;
	
	public ConsumoEnFecha(LocalDateTime fecha,Double consumo) {
		this.fecha = fecha;
		this.consumo = consumo;
	}
	
	public ConsumoEnFecha() {};
	
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
}