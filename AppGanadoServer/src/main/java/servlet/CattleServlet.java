package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FactoryDAO;
import model.vo.Cattle;
import model.vo.Estate;
import model.vo.UserApp;
import util.GsonPOJOFactory;

public class CattleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CattleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getHeader("action");

		Long phoneUser = null;
		try {
			phoneUser = Long.parseLong(request.getHeader("phone"));
		} catch (NumberFormatException ex) {
		}
		
		System.out.println("action: " + action + " / user: " + phoneUser);

		Cattle cattle = null;
		Estate estate = null;

		switch (action) {
		case "getAll":// Get by User
			response.getWriter().write(GsonPOJOFactory.getJson(FactoryDAO.getCattleDAO().getCattlesByUser(phoneUser)));
			break;

		case "getOne":// Get one
			cattle = GsonPOJOFactory.getPOJO(request.getReader(), Cattle.class);
			response.getWriter().write(GsonPOJOFactory.getJson(FactoryDAO.getCattleDAO().getCattle(cattle)));
			break;
		default:
			break;
		}

		response.getWriter().flush();
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

		Cattle cattle = null;

		switch (action) {
		case "insert":
			cattle = GsonPOJOFactory.getPOJO(request.getReader(), Cattle.class);
			response.getWriter().write(FactoryDAO.getCattleDAO().saveOrUpdate(cattle) ? "true" : "false");
			break;

		default:
			break;
		}

		response.getWriter().flush();
	}

}
