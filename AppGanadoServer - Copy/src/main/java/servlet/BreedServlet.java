package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DAOFactory;
import util.GsonFactory;

@WebServlet("/breed")
public class BreedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BreedServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("BreedServlet....");

        response.getWriter().write(GsonFactory.getJson(DAOFactory.getBreedDAO().getAll()));
        response.getWriter().flush();

    }

}
