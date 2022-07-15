package model;

public class Proveedor {
	
	private int idProveedor;
	private String proveedor;
	private String correo;
	private String tlf;
	
	
	public Proveedor (String proveedor, String correo, String tlf ) {
		this.proveedor = proveedor;
		this.correo = correo;
		this.tlf = tlf;
		
	}
	
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}
	
	public String getProveedor() {
		return proveedor;
	}

	public String getTlf() {
		return tlf;
	}

	public String getCorreo() {
		return correo;
	}


}
