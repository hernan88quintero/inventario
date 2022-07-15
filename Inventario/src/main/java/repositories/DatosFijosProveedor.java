package repositories;

import model.Proveedor;

public class DatosFijosProveedor {
	
	
	public static DinamicaProveedores repositorioProveedores = new DinamicaProveedores ();
	static {
		
		repositorioProveedores.agregarProveedor(new Proveedor("Dafilca C.A", "dafilca@gmail.com", "1127564550 "));
		repositorioProveedores.agregarProveedor(new Proveedor("Cenil C.A", "cenil_df@yahoo.com", "1150478667 "));
		repositorioProveedores.agregarProveedor(new Proveedor("DistriFull C.A", "distrifull@hotmail.com", "1140509784 "));
		
		
}

}
