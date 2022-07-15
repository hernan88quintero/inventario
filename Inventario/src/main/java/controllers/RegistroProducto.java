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


@WebServlet("/registroProducto")
public class RegistroProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistroProducto() {
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ingreso = request.getParameter("ingreso");
		String nombre = request.getParameter("nombre");
		String marca = request.getParameter("marca");
		
		String unidadStr = request.getParameter("unidad");
		
		
		String vencimiento = request.getParameter("vencimiento");
		String ubicacion = request.getParameter("ubicacion");
		
		
		Writer writer = response.getWriter();
		try {
			response.setContentType("text/html;charset=UTF-8");
			
			int unidad = Integer.parseInt(unidadStr);
			
			Dato datos = new Dato(ingreso, nombre, marca, unidad, vencimiento, ubicacion);
			
			DatosFijosProducto.repositorioDatos.agregarDato(datos);
			
			BaseDatosProducto.repositorioProducto.addNuevoProducto(datos);
			
			writer.append(
							 "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<div class='container'><table class='table table-hover'><thead><tr>"
							
							+ "<br><h2>Datos del Producto</h2>"
							+ "<th>Fecha y Hora de Ingreso</th> "
							+ "<th>Nombre Producto</th>"
							+ "<th>Marca</th>"
							+ "<th>Unidades</th>"
							+ "<th>Vencimiento</th>"
							+ "<th>Ubicación</th>"
							+ "</tr></thead>"
							+ "<tbody><tr>"
							+ "<td>" + datos.getIngreso() + "</td>"
							+ "<td>" + datos.getNombre() + "</td>"
							+ "<td>" + datos.getMarca() + "</td>"
							+ "<td>" + datos.getUnidad() + "</td>"
							+ "<td>" + datos.getVencimiento() + "</td>"
							+ "<td>" + datos.getUbicacion() + "</td>"
							+ "</tr> </tbody> </table> </div>"
							+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
					);
			writer.append(
							"<div class='container'>"
						   +"<a class='btn btn-outline-success' href='registro.html' style='text-decoration:none'>Volver</a>"
						   +"</div>"
						  );

			
			
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
		  System.err.println("Error al ingresar datos " + e);
		  writer.append(
				  "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
				  
				  +"<div class='container'>"
				  +"<br><h2>Ha ocurrido un Error al ingresar los datos del producto.</h2>"
				  +"<br></div>"
				  +"<div class='container'>"
				  +"<a class='btn btn-outline-success' href='registro.html' style='text-decoration:none'>Volver</a>"
				  +"</div>"
				  + "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
				  );
		}
		
	}

}
