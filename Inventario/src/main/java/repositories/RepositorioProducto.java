package repositories;

import model.Dato;

public interface RepositorioProducto {

	void addNuevoProducto(Dato dato);

	void modificarProducto(Dato dato);

	void borrarPorIndex(int index);

	void borrarPorId(int id);

	Dato[] getAll();

}
