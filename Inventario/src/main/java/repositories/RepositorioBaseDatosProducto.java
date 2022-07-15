package repositories;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;

import db.ConcreteDBMSHandler;
import db.DbFacade;
import model.Dato;

public class RepositorioBaseDatosProducto implements RepositorioProducto {
	
private DbFacade dbFacade;
	
	public RepositorioBaseDatosProducto() throws SQLException {
		ConcreteDBMSHandler dbmsHandler = new ConcreteDBMSHandler();
		dbmsHandler.startup();
		this.dbFacade = new DbFacade(dbmsHandler);
	}
	
	@Override
	public void addNuevoProducto(Dato dato) {
		int id = 0;
		try {
			String insertionQuery = "INSERT INTO producto(id, ingreso, nombre, marca, unidad, vencimiento, ubicacion) VALUES ("+dato.getId()+",'"+dato.getIngreso()+"', '"+dato.getNombre()+"', '"+dato.getMarca()+"', "+dato.getUnidad()+", '"+dato.getVencimiento()+"', '"+dato.getUbicacion()+"');";                     
			id = dbFacade.executeInsertionQuery(insertionQuery);
			dato.setId(id);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}
	}

	@Override
	public void modificarProducto(Dato dato) {
		try {
			String updateQuery = "UPDATE producto SET ingreso='"+ dato.getIngreso()+"', nombre='"+dato.getNombre()+"', marca='"+dato.getMarca()+"', unidad="+dato.getUnidad()+", vencimiento='"+dato.getVencimiento()+"', ubicacion='"+dato.getUbicacion()+"' WHERE id = "+ dato.getId() +";";                     
			int value = dbFacade.executeDeleteOrUpdateQuery(updateQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al actualizar: " + e.getMessage());
		}
	}

	@Override
	public void borrarPorIndex(int index) {
		throw new RuntimeException("Método borrarPorIndex no implementado para DataBase");
	}

	@Override
	public void borrarPorId(int id) {
		try {
			String deletionQuery = "delete from producto WHERE id = " + id;
			int value = dbFacade.executeDeleteOrUpdateQuery(deletionQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al borrar: " + e.getMessage());
		}
	}

	@Override
	public Dato[] getAll() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT id, ingreso, nombre, marca, unidad, vencimiento, ubicacion FROM producto");
			int rowCount = rows.size();
		    Dato[] datos = new Dato[rowCount];
			for (int i = 0; i < rows.size(); i++) {
				Dato dato = toDato(rows.get(i));
				datos[i] = dato;
			}
			return datos;
		} catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
			return new Dato[0];
		}
	}


	
	
	public Dato toDato(HashMap<String, Object> valueByColumnName) {
		
		
		int id = (Integer) valueByColumnName.get("id");
		
		String ingreso = (String) valueByColumnName.get("ingreso");
		
		String nombre = (String) valueByColumnName.get("nombre");
		
		String marca = (String) valueByColumnName.get("marca");
		
		int unidad = (Integer) valueByColumnName.get("unidad");
		
		
		String vencimiento = (String) valueByColumnName.get("vencimiento");
		
		String ubicacion = (String) valueByColumnName.get("ubicacion");
		
		
		Dato dato = new Dato(id, ingreso, nombre, marca, unidad, vencimiento, ubicacion);
		return dato;
	}
	
	

}
