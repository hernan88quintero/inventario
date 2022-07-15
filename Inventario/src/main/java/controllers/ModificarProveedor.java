package controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proveedor;
import repositories.DatosFijosProveedor;


@WebServlet("/modificarProveedor")
public class ModificarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProveedor = request.getParameter("id");
		String proveedor = request.getParameter("proveedor");
		String correo = request.getParameter("correo");
		String tlf = request.getParameter("telefono");
		
		
		Writer writer = response.getWriter();
		try {
			response.setContentType("text/html;charset=UTF-8");
			int id = Integer.parseInt(idProveedor);
			Proveedor proveedores = new Proveedor(proveedor, correo, tlf);
			proveedores.setIdProveedor(id);
			DatosFijosProveedor.repositorioProveedores.modificarProveedorExistente(proveedores);
			
			response.setContentType("text/html;charset=UTF-8");
			writer.append(
							"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
							+ "<div class='container'><table class='table table-hover'><thead><tr>"
							+ "<br><h2>Datos del Proveedor</h2>"
							+ "<th>Proveedor</th>"
							+ "<th>Correo Electrónico</th>"
							+ "<th>Teléfono</th>"
							+ "</tr></thead>"
							+ "<tbody><tr>"
							+ "<td>" + proveedores.getProveedor() + "</td>"
							+ "<td>" + proveedores.getCorreo() + "</td>"
							+ "<td>" + proveedores.getTlf() + "</td>"
							+ "</tr> </tbody> </table> </div>"
							+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
						
					
					);
			writer.append(
							"<div class='container'>"
							+"<a class='btn btn-outline-success' href='modificarProveedor.html' style='text-decoration:none'>Volver</a>"
							+"</div>"
						  );
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
			writer.append(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
					+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
					+"<div class='container'>"
					+"<br> <h2>ERROR: POR FAVOR INGRESE DATOS PARA MODIFICACIONES VÁLIDAS</h2> <br><br> <a class='btn btn-outline-danger' href='modificarProveedor.html' style='text-decoration:none'>Volver</a>"
					+"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
					+"</div>"
					);
		}
		
		
		
		
		
		
		
	}

}
