package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.UserApp;
import util.GsonPOJOFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login...");

		UserApp user = GsonPOJOFactory.getPOJO(request.getReader(), UserApp.class);
		/*SQLUserDAO sqlUser = new SQLUserDAO(conn.getStatement());
		responseJson = new Gson().toJson(sqlUser.login(user.getTelefono(), user.getContraseña()));
		response.getWriter().write(responseJson);
		response.getWriter().flush();
		System.out.println("logeado: " + responseJson);*/
	}

	// GET = obtener
	// POST = crear / login
	// PUT = actualizar o reemplazar
	// DELETE = eliminar / logout
}
