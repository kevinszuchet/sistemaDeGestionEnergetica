package json;
import java.io.File; 
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	private static JSONParser instancia;
	private TipoJSON tipo;
	
	public static JSONParser getInstance() {
		if (instancia == null) {
			instancia = new JSONParser();
		}
		return instancia;
	}
	
	public void setTipoDato(TipoJSON tipo) {
		this.tipo = tipo;
	}
	
	public void parsear() {	
		File archivoJson = new File("./data/" + tipo.nombreArchivo() + ".json");
		ObjectMapper mapper = new ObjectMapper();

		try {
			tipo.cargarSegunTipo(archivoJson, mapper);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

interface TipoJSON {
	public void cargarSegunTipo(File archivo, ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException;
	public String nombreArchivo();
}