package model;

public class Dato {
	
	private int id;
	private String ingreso;
	private String nombre;
	private String marca;
	private int unidad;
	private String vencimiento;
	private String ubicacion;
	
	public Dato (int id, String ingreso, String nombre, String marca, int unidad, String vencimiento, String ubicacion) {
		this.id = id;
		this.ingreso = ingreso;
		this.nombre = nombre;
		this.marca = marca;
		this.unidad = unidad;
		this.vencimiento = vencimiento;
		this.ubicacion = ubicacion;

	}
	
	public Dato (String ingreso, String nombre, String marca, int unidad, String vencimiento, String ubicacion) {
		this.ingreso = ingreso;
		this.nombre = nombre;
		this.marca = marca;
		this.unidad = unidad;
		this.vencimiento = vencimiento;
		this.ubicacion = ubicacion;

	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	

	public String getIngreso() {
		return ingreso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getUnidad() {
		return unidad;
	}
	
	public String getVencimiento() {
		return vencimiento;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	

}
