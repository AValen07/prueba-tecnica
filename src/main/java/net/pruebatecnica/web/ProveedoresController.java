package net.pruebatecnica.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.pruebatecnica.dao.ProveedorDAO;
import net.pruebatecnica.model.Proveedor;

/**
 * Servlet implementation class ProveedoresController
 */
@WebServlet("/Proveedor")
public class ProveedoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedoresController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("inicio")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);

		}else if(opcion.equals("listar")) {
			ProveedorDAO proveedorDAO = new ProveedorDAO();
			List <Proveedor> proveedores = new ArrayList<Proveedor>();
			int idCliente = Integer.parseInt(request.getParameter("codCliente"));
			
			if(idCliente==0) {
				// Si el codigo solicitado es el 0 mostramos todos los registros
				proveedores=proveedorDAO.selectAllProveedores();
			}else {
				// Si el codigo es distinto a 0 mostramos los registros que cumplan con la condicion
				proveedores=proveedorDAO.selectProveedoresByIdCliente(idCliente);
			}
			
			request.setAttribute("listadoProveedores", proveedores);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Listado.jsp");
			requestDispatcher.forward(request, response);			
		}
		
	}



}
