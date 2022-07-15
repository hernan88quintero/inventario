package controllers;

import java.io.IOException;

import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Dato;
import repositories.BaseDatosProducto;
import repositories.DatosFijosProducto;






@WebServlet("/modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");		
		String ingreso = request.getParameter("ingreso");
		String nombre = request.getParameter("nombre");
		String marca = request.getParameter("marca");
		String unidadStr = request.getParameter("unidad");
		int unidad = Integer.parseInt(unidadStr);
		
		String vencimiento = request.getParameter("vencimiento");
		String ubicacion = request.getParameter("ubicacion");

		
		Writer writer = response.getWriter();
		try {
			response.setContentType("text/html;charset=UTF-8");
			int id = Integer.parseInt(idParam);
			Dato dato = new Dato(id, ingreso, nombre, marca, unidad, vencimiento, ubicacion);
			dato.setId(id);
			DatosFijosProducto.repositorioDatos.modificarExistente(dato);
			
			BaseDatosProducto.repositorioProducto.modificarProducto(dato);
			
			response.setContentType("text/html;charset=UTF-8");
			writer.append(
							"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
							+ "<div class='container'><table class='table table-hover'><thead><tr>"
							+"<h1>Se ha modificado Exitosamente lo siguiente</h1>"
							+"<h2>Datos del Producto</h2>"
							+ "<th>Identificador</th>"
							+ "<th>Fecha/Hora</th> "
							+ "<th>Producto</th>"
							+ "<th>Marca</th>"
							+ "<th>Cantidad</th>"
							+ "<th>Vencimiento</th>"
							+ "<th>Ubicación</th>"
							+ "</tr></thead>"
							+ "<tbody><tr>"
							+ "<td>" + dato.getId() + "</td>"
							+ "<td>" + dato.getIngreso() + "</td>"
							+ "<td>" + dato.getNombre() + "</td>"
							+ "<td>" + dato.getMarca() + "</td>"
							+ "<td>" + dato.getUnidad() + "</td>"
							+ "<td>" + dato.getVencimiento() + "</td>"
							+ "<td>" + dato.getUbicacion() + "</td>"
							+ "</tr> </tbody> </table> </div>"
							+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
					
					
					);
			writer.append(
							"<div class='container'>"
							+"<a class='btn btn-outline-success' href='modificar.html' style='text-decoration:none'>Volver</a>"
							+"</div>"
						  );
		} catch (Exception e) {
			writer.append(
							"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
							+"<div class='container'>"
							+"<br> <h2>ERROR: POR FAVOR INGRESE DATOS PARA MODIFICACIONES VÁLIDAS</h2> <br><br> <a class='btn btn-outline-danger' href='modificar.html' style='text-decoration:none'>Volver</a>"
							+"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
							+"</div>");
		}
		
		
		
	}

}
