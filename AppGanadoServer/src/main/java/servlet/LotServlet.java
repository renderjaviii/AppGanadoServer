package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;
import util.GsonFactory;

@WebServlet("/lot")
public class LotServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LotServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Starting LotServlet...");
        response.getWriter().write(GsonFactory.getJson(DAOFactory.getLotDAO().getAll()));
        response.getWriter().flush();
    }
}
