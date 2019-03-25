package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FactoryDAO;
import model.vo.Estate;
import model.vo.UserApp;
import util.GsonPOJOFactory;

public class EstateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EstateServlet() {
		super();
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

		Estate estate = null;
		UserApp user = null;

		switch (action) {
		case "insert":
			estate = GsonPOJOFactory.getPOJO(request.getReader(), Estate.class);
			response.getWriter().write(FactoryDAO.getEstateDAO().saveOrUpdate(estate) ? "true" : "false");
			break;

		case "getAll":// Get All by User
			user = GsonPOJOFactory.getPOJO(request.getReader(), UserApp.class);
			response.getWriter().write(GsonPOJOFactory.getJson(FactoryDAO.getEstateDAO().getEstatesByUser(user)));
			break;

		case "getOne":// Get One by Estate_Name a Phone_User
			estate = GsonPOJOFactory.getPOJO(request.getReader(), Estate.class);
			response.getWriter().write(GsonPOJOFactory.getJson(FactoryDAO.getEstateDAO().getEstate(estate)));
			break;
			
		default:
			break;
		}
		
		response.getWriter().flush();
	}

}