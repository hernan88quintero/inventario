package controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.DatosFijosProveedor;


@WebServlet("/borrarProveedor")
public class EliminarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					String idParam = request.getParameter("idProveedor");
					
					Writer writer = response.getWriter();
					
					try {
						response.setContentType("text/html;charset=UTF-8");
						int idProveedor = Integer.parseInt(idParam);
						
						DatosFijosProveedor.repositorioProveedores.borrarProveedorConId(idProveedor);
						
						writer.append(
										"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">"
										+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
										+"<br><div class='container'>"+"<h2>Proveedor con ID : </h2><h2>" + idProveedor + "</h2> <br><h3>Eliminado con éxito !!! </h3>"+"</div>"
										+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p crossorigin=\"anonymous\"></script>"
										);
						
						
						writer.append("<br/><br/>");
						writer.append(
										"<div class='container'>"
										+"<a class='btn btn-outline-success' href='eliminarProveedor.html'>Volver</a>"
										+"</div>"
									);
						
						
						response.setStatus(HttpServletResponse.SC_OK);
					
					} catch (Exception e) {
						response.setContentType("text/html;charset=UTF-8");
						writer.append(
								"<br><br><div class='container'><h2> El ID ingresado no se encuentra disponible! </h2><br><br>" + "ERROR : " + e + "</div>"
								);
						writer.append(
								"<br><br>"
										+"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">"
										+ "<link href='css/servidor.css' rel='stylesheet' type='text/css'/>"
										+"<div class='container'>"
										+"<a class='btn btn-outline-success' href='eliminarProveedor.html'>Volver</a>"
										+"</div>"
										+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p crossorigin=\"anonymous\"></script>"							
									);
				}
					
		
		
		
		
	}

}
