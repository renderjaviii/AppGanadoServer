package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FactoryDAO;
import model.vo.UserApp;
import util.GsonPOJOFactory;

public class UserAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserAppServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getHeader("action");

		int phoneUser = 0;
		try {
			phoneUser = Integer.parseInt(request.getHeader("phone"));
		} catch (NumberFormatException ex) {
		}

		System.out.println("action: " + action + " / user: " + phoneUser);

		switch (action) {
		case "insert":
			UserApp user = GsonPOJOFactory.getPOJO(request.getReader(), UserApp.class);
			response.getWriter().write(FactoryDAO.getUserAppDAO().saveOrUpdate(user) ? "true" : "false");
			response.getWriter().flush();

			break;

		default:
			break;
		}
	}

}
