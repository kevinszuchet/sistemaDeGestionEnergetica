import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserClientes implements TipoJSON {
	public void cargarSegunTipo(File archivo, ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException {
		List<Cliente> clientes = mapper.readValue(archivo, new TypeReference<List<Cliente>>(){});		
		RepoClientes.getInstance().agregarClientes(clientes);
	}
}