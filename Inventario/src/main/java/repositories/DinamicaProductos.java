package repositories;

import java.util.Arrays;


import model.Dato;

public class DinamicaProductos {
	
	private static int MAX_CONTADOR_DATOS = 1000;

	public static Object repositorioDatos;
	
	private Dato[] datos;
	private int contadorDatosExistentes;	
	private int contadorDatosAgregados;
	
	
	public DinamicaProductos() {
		this.datos = new Dato[MAX_CONTADOR_DATOS];
		this.contadorDatosExistentes = 0;
		this.contadorDatosAgregados = 0;
	}
	
	//ASIGNAR ID
	
	public void asignarID(Dato dato) {
		int asignarPorID = (dato.getId());
		this.datos[asignarPorID] = dato;
	}
	
	
	//AGREGAR
	
	public void agregarDato(Dato dato) {
		this.datos[this.contadorDatosExistentes] = dato;
		this.contadorDatosExistentes++;
		
		dato.setId(this.contadorDatosAgregados);
		this.contadorDatosAgregados++;
	}
	
	
	//MODIFICAR
	
	public void modificarExistente(Dato dato) {
		int indice = buscarPorId(dato.getId());
		this.datos[indice] = dato;
	}
	
	//BORRAR CON INDICE

	public void borrarConIndice(int indice) {
		for (int i = indice; i < this.datos.length-1; i++) {
			this.datos[i] = this.datos[i+1];
		}
		this.contadorDatosExistentes--;
	}
	
	// BORRAR CON ID
	
	public void borrarConId(int id) {
		int indice = buscarPorId(id);
		borrarConIndice(indice);
	}
	
	//BUSCAR POR ID
	
	private int buscarPorId(int id) {
		int indice = -1;
		for (int i = 0; i < this.datos.length-1 && indice == -1; i++) {
			if (this.datos[i].getId() == id ) {
				indice = i;
			}
		}
		return indice;
	}
	

	
	
	public Dato[] getAll() {
		return Arrays.copyOf(this.datos, this.contadorDatosExistentes);
	}

	

}
