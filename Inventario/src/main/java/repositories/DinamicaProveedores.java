package repositories;

import java.util.Arrays;

import model.Proveedor;

public class DinamicaProveedores {
	
	private static int MAX_CONTADOR_DATOS = 1000;

	public static Object repositorioDatos;
	
	private Proveedor[] Proveedores;
	private int contadorProveedoresExistentes;	
	private int contadorProveedoresAgregados;
	
	
	public DinamicaProveedores() {
		this.Proveedores = new Proveedor[MAX_CONTADOR_DATOS];
		this.contadorProveedoresExistentes = 0;
		this.contadorProveedoresAgregados = 0;
	}
	
	//ASIGNAR ID
	
	public void asignarIdProveedor(Proveedor proveedoresId) {
		int asignarPorID = (proveedoresId.getIdProveedor() );
		this.Proveedores[asignarPorID] = proveedoresId;
	}
	
	
	//AGREGAR
	
	public void agregarProveedor(Proveedor proveedor) {
		this.Proveedores[this.contadorProveedoresExistentes] = proveedor;
		this.contadorProveedoresExistentes++;
		
		proveedor.setIdProveedor(this.contadorProveedoresAgregados);
		this.contadorProveedoresAgregados++;
	}
	
	
	//MODIFICAR
	
	public void modificarProveedorExistente(Proveedor proveedor) {
		int indice = buscarPorId(proveedor.getIdProveedor());
		this.Proveedores[indice] = proveedor;
	}

	//BORRAR CON INDICE

	public void borrarProveedorConIndice(int indice) {
		for (int i = indice; i < this.Proveedores.length-1; i++) {
			this.Proveedores[i] = this.Proveedores[i+1];
		}
		this.contadorProveedoresExistentes--;
	}
	
	// BORRAR CON ID
	
	public void borrarProveedorConId(int idProveedor) {
		int indice = buscarPorId(idProveedor);
		borrarProveedorConIndice(indice);
	}
	
	
	//BUSCAR POR ID
	
	private int buscarPorId(int id) {
		int indice = -1;
		for (int i = 0; i < this.Proveedores.length-1 && indice == -1; i++) {
			if (this.Proveedores[i].getIdProveedor() == id ) {
				indice = i;
			}
		}
		return indice;
	}
	

	
	
	public Proveedor[] getAll() {
		return Arrays.copyOf(this.Proveedores, this.contadorProveedoresExistentes);
	}


}
