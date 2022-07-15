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

@WebServlet("/listaProductos")
public class ListaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaProductos() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Dato[] datos = BaseDatosProducto.repositorioProducto.getAll();	
		
		Writer writer  = response.getWriter();
		
		String maxCantidadParam = request.getParameter("max-cantidad");
		int maxCantidad = datos.length;
		try {
			response.setContentType("text/html;charset=UTF-8");
			maxCantidad = Integer.parseInt(maxCantidadParam);
			
			if (maxCantidad > datos.length) {
				System.out.println("Ingresó una cantidad mayor a la que se encuentra disponible !!!");
				response.setContentType("text/html;charset=UTF-8");
				writer.append(
								"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
								+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"						
						);
				writer.append("<script> alert('Busca una cantidad mayor a la que se encuentra disponible !!!') </script>");				
				writer.append("<h1 class='container' style='text-align:center'><i><b> Lista disponible </b></i></h1>");
				writer.append("<div class='container'>"
						+"<a class='btn btn-outline-success' href='productos.html'>Volver</a>"
						+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
						+"</div>");
			}
			
		} catch (Exception e) {
			System.out.println("Obtuvo la cantidad total de la lista de Productos. " + e);
			
		}
		
		for (int indice = 0; indice < maxCantidad; indice++) {
			response.setContentType("text/html;charset=UTF-8");
			Dato dato = datos[indice];
			writer.append(
					         "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
							+ "<body class='container'><div class='container'><table class='table table-hover'><thead><tr>"
							+ "<br><h2>Datos del Producto</h2>"
							+ "<th>Identificador</th> "
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
							+ "<br><br>"
							+ "<td>" + dato.getUnidad() + "</td>"
							+ "<td>" + dato.getVencimiento() + "</td>"
							+ "<td>" + dato.getUbicacion() + "</td>"
							+ "</tr> </tbody> </table> </div></body>"
							+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
							);
		}
		writer.append(
				  "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
				  + "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
				  +"<div class='container'>"
				  +"<br><a class='btn btn-outline-success' href='productos.html' style='text-decoration:none'>Volver</a>"
				  +"</div><br><br>"
				  + "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
				  );
				
		response.setStatus(HttpServletResponse.SC_OK);		
		
	}

}
