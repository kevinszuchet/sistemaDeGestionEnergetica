package repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import cliente.Cliente;
import repositorio.RepoEnDB;
import tipoDispositivo.ConsumoEnFecha;

public class RepoConsumoEnFecha extends RepoEnDB<ConsumoEnFecha> {
	
	private static RepoConsumoEnFecha instancia;
	
	public RepoConsumoEnFecha(String tabla) {
		super(tabla);
	}
	
	public static RepoConsumoEnFecha getInstance() {
		if(instancia == null) {
			instancia = new RepoConsumoEnFecha("HistorialConsumos");
		}
		return instancia;
	}
	
	public List<ConsumoEnFecha> filtrarMedicionesXCliente(Cliente cliente, LocalDateTime desde, LocalDateTime hasta) {		
		Query query = entityManager()
						.createQuery(
							"SELECT hc.fecha AS fecha, hc.consumo AS consumo "
							+ "FROM Cliente c "
							+ "INNER JOIN c.dispositivos AS d "
							+ "INNER JOIN d.tipoDispositivo td "
							+ "INNER JOIN td.consumosHastaElMomento AS hc "
							+ "WHERE c = :cliente "
							+ (desde != null ? "AND hc.fecha >= :desde " : "")
							+ (hasta != null ? "AND hc.fecha <= :hasta " : "")
						);
		
		query.setParameter("cliente", cliente);
		
		if (desde != null) {			
			query.setParameter("desde", desde);
		}
		
		if (hasta != null) {			
			query.setParameter("hasta", hasta);
		}
		
		return convertirAMediciones(query.getResultList());
	}
	
	public List<Object> obtenerConsumoDeClientesEnFecha(LocalDateTime desde, LocalDateTime hasta) {		
		Query query = entityManager()
						.createQuery(
							"SELECT cat.nombre, c.nombre, c.fechaAlta, SUM(hc.consumo) "
							+ "FROM Cliente c "
							+ "INNER JOIN c.dispositivos AS d "
							+ "INNER JOIN d.tipoDispositivo td "
							+ "INNER JOIN td.consumosHastaElMomento AS hc "
							+ "INNER JOIN c.categoria AS cat "
							+ "WHERE hc.fecha IS NOT NULL "			
							+ (desde != null ? "AND hc.fecha >= :desde " : "")
							+ (hasta != null ? "AND hc.fecha <= :hasta " : "")
							+ "GROUP BY c.id, c.nombre, cat.nombre, c.fechaAlta"
						);	
		
		if (desde != null) {			
			query.setParameter("desde", desde);
		}
		
		if (hasta != null) {			
			query.setParameter("hasta", hasta);
		}
		
		return query.getResultList();
	}
	
	
	private List<ConsumoEnFecha> convertirAMediciones(List<Object[]> results) {
		List<ConsumoEnFecha> mediciones = new ArrayList<ConsumoEnFecha>();
		
		mediciones = results.stream().map(result -> new ConsumoEnFecha((LocalDateTime) result[0], (Double) result[1])).collect(Collectors.toList());
		
		return mediciones;
	}
}
