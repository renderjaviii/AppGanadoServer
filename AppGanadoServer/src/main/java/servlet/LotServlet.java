package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FactoryDAO;
import util.GsonPOJOFactory;

public class LotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LotServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LotServlet....");

		response.getWriter().write(GsonPOJOFactory.getJson(FactoryDAO.getLotDAO().getAll()));
		response.getWriter().flush();

	}

}
