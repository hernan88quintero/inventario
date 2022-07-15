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


@WebServlet("/listaProveedores")
public class ListaProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public ListaProveedores() {
	        super();
	    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Proveedor[] proveedores = DatosFijosProveedor.repositorioProveedores.getAll();
		
		Writer writer  = response.getWriter();
		
		String maxCantidadParam = request.getParameter("max-cantidad");
		int maxCantidad = proveedores.length;
		try {
			response.setContentType("text/html;charset=UTF-8");
			maxCantidad = Integer.parseInt(maxCantidadParam);
			
			if (maxCantidad > proveedores.length) {
				System.out.println("Ingresó una cantidad mayor a la que se encuentra disponible !!!");
				response.setContentType("text/html;charset=UTF-8");
				writer.append(
								"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
								+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"						
						);				
				writer.append("<script> alert('Busca una cantidad mayor a la que se encuentra disponible !!!') </script>");				
				writer.append("<h1 class='container' style='text-align:center'><i><b> Lista disponible </b></i></h1>");
				writer.append("<div class='container'>"
						+"<a class='btn btn-outline-success' href='proveedores.html'>Volver</a>"
						+"</div>"
						+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
						);
			}			
			
			
		} catch (Exception e) {
			System.out.println("Obtuvo la cantidad total de la lista de Proveedores. " + e);
		}
		
		for (int indice = 0; indice < maxCantidad; indice++) {
			response.setContentType("text/html;charset=UTF-8");
			Proveedor proveedor = proveedores[indice];
			writer.append(
							"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
							+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
							+ "<body class='container'><div class='container'> <table class='table table-hover'> <thead> <tr>"
							+ "<br><h2>Datos del Proveedor</h2>"
							+ "<th>Identificador</th>"
							+ "<th>Proveedor</th>"
							+ "<th>Correo Electrónico</th>"
							+ "<th>Teléfono</th>"
							+ "</tr></thead>"
							+ "<tbody><tr>"
							+ "<td>" + proveedor.getIdProveedor() + "</td>"
							+ "<td>" + proveedor.getProveedor() + "</td>"
							+ "<td>" + proveedor.getCorreo() + "</td>"
							+ "<td>" + proveedor.getTlf() + "</td>"
							+ "</tr> </tbody> </table> </div></body>"
							+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>"
					);
			writer.append("<br/>");
		}


		writer.append(	"<div class='container'>"
						+"<a class='btn btn-outline-success' href='proveedores.html'>Volver</a><br><br>"
						+"</div>");
		
		response.setStatus(HttpServletResponse.SC_OK);


	}	
		
		
	};
