package transformador;

import java.util.List;

import org.uqbar.geodds.Point;

import cliente.Cliente;
import consumoMasivo.ConsumidorMasivo;
import consumoMasivo.ConsumoMasivoEnBaseA;
import repositorio.RepoTransformadores;
public class Transformador extends ConsumoMasivoEnBaseA<Cliente> implements ConsumidorMasivo{
	
	private Point ubicacion;
	
	public Transformador() {}

	public Transformador(Point ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double consumoActual(Cliente cliente) {
		return cliente.consumoActual();
	}

	public Point ubicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}
		
	public double distanciaA(Cliente cliente) {	
		return ubicacion.distance(cliente.ubicacion());	
 	}

	public List<Cliente> obtenerFuentesDeConsumo() {
		return RepoTransformadores.getInstance().obtenerClientesDe(this);
	}
}
