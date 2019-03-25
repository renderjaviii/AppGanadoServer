package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FactoryDAO;
import model.vo.UserApp;
import util.GsonPOJOFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserApp user = GsonPOJOFactory.getPOJO(request.getReader(), UserApp.class);

		System.out.println("login request: " + user);

		user = FactoryDAO.getUserAppDAO().login(user);

		response.getWriter().write(GsonPOJOFactory.getJson(user));
		response.getWriter().flush();
		System.out.println("logeado: " + user == null ? "user no found" : user);

	}
	
	
	// GET = obtener
	// POST = crear / login
	// PUT = actualizar o reemplazar
	// DELETE = eliminar / logout
}
