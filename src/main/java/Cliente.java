import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	String nombre;
	String apellido;
	TIPO_DOCUMENTO tipoDocumento;
	long nroDocumento;
	long telefono;
	String domicilio;
	LocalDate fechaAlta;
	Categoria categoria;
	List<Dispositivo> dispositivos = new ArrayList<>();
	public Cliente() { //Es para el Json
		
	}
	public Cliente(String nombre, String apellido, TIPO_DOCUMENTO tipoDocumento, long nroDocumento, long telefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos){
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
		this.fechaAlta = LocalDate.now();
	}
	
	public boolean algunDispositivoEncendido() {
		return dispositivos.stream().anyMatch(Dispositivo::estaEncendido);
	}
	
	public long cantidadDispositivosEncendidos() {
		return dispositivos.stream().filter(Dispositivo::estaEncendido).count();
	}
	
	public long cantidadDispositivosApagados() {
		return cantidadDispositivos() - cantidadDispositivosEncendidos();
	}
	
	public long cantidadDispositivos() {
		return dispositivos.stream().count();
	}
	
	public void recategorizar() {
		categoria = obtenerNuevaCategoria(consumoHastaElMomento());
	}
	
	private Categoria obtenerNuevaCategoria(double consumo) {
		return RepoCategorias.getInstance().obtenerCategoriaSegunConsumo(consumo);
	}
	
	public double consumoHastaElMomento() {
		return dispositivos.stream().mapToDouble(Dispositivo::consumo).sum();
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);		
	}

	public Categoria categoria() {
		return this.categoria;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public TIPO_DOCUMENTO getTipoDocumento() {
		return this.tipoDocumento;
	}
	
	public long getNroDocumento() {
		return this.nroDocumento;
	}
	public long getTelefono(){
		return this.telefono;
	}
	public String getDomicilio() {
		return this.domicilio;
	}
	public LocalDate getFechaAlta() {
		return this.fechaAlta;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	public List<Dispositivo> getDispositivos(){
		return this.dispositivos;
	}
	
	public int getCantidadDispositivos(){
		return dispositivos.size();
	}
}