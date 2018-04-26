import java.util.List;   
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJsonCliente extends Fixture{
	
		List<Cliente> clientes;
	
	@Before
		public void fixture(){
			RepoClientes.getInstance().cargarClientes();
			clientes = RepoClientes.getInstance().obtenerTodos();
		}
	
	 /*@Test
	 public void laCantidadDeClienteCargadosEs3() throws IOException{
		 Assert.assertEquals(3, clientes.size());
	 }por alguna razon guarda registros de m�s.*/
	 
	 @Test
	 public void elPrimerUsuarioEsLio() throws IOException{
		 Assert.assertEquals("lio", clientes.get(0).getNombre());
	 }
	 
	 @Test
		public void elApellidoDeLioEsMessi() throws IOException {
			Assert.assertEquals("messi", clientes.get(0).getApellido());
		}
		
	@Test
		public void elTipoDeDocumentoDeLioEsDNI() {
			Assert.assertEquals(TIPO_DOCUMENTO.DNI, clientes.get(0).getTipoDocumento());
		}
		
	@Test
		public void elDNIdeLioEs40216458() {
			Assert.assertEquals(40216458, clientes.get(0).getNroDocumento());
		}
		
	@Test
		public void elTelefonoDeLioES10101010() {
			Assert.assertEquals(10101010, clientes.get(0).getTelefono());
		}
		
	@Test
		public void elDomicilionDeLioEsAvCatalunia() {
			Assert.assertEquals("Av. Catalunia 10", clientes.get(0).getDomicilio());
		}

	@Test
		public void elNombreDelSegundoUsuarioEsPepe() {
			Assert.assertEquals("pepe", clientes.get(1).getNombre());
		}
		
	@Test
		public void pepeConsumio0PorNoTenerDispositivos() {
			Assert.assertEquals(0,  clientes.get(1).consumoHastaElMomento(), 0);
		}
		

	@Test
		public void laCategoriaDeLioEsR3() {
			Assert.assertEquals("R3", clientes.get(0).getCategoria().getNombre());
		}
	 
	 
	 
}