package repositories;

import java.sql.SQLException;

public class BaseDatosProducto {
	
	public static RepositorioProducto repositorioProducto; 

	static {
		 try {
			 
			System.out.println("Iniciando base de datos");
			repositorioProducto = new RepositorioBaseDatosProducto();
		} catch (SQLException e) {
			System.out.println("Error iniciando la Base de Datos");
			System.out.println(e);
		}
	}
}
