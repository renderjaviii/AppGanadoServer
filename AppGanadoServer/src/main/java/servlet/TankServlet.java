package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Tank;
import util.DAOFactory;
import util.GsonFactory;

@WebServlet("/tank")
public class TankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getHeader("action");

        Long phoneUser = null;
        Integer idTank = null;

        try {
            phoneUser = Long.parseLong(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }

        try {
            idTank = Integer.parseInt(request.getHeader("id"));
        } catch (NumberFormatException ex) {
        }

        System.out.println("action: " + action + " / phoneUser: " + phoneUser);

        switch (action) {
            case "getAll":
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getTankDAO().getTanksByUser(phoneUser)));

                break;

            case "delete":
                Boolean validator = DAOFactory.getTankDAO().delete(idTank);
                response.getWriter().write(validator ? "true" : "false");
                break;
        }
        response.getWriter().flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getHeader("action");

        Integer phoneUser = 0;
        try {
            phoneUser = Integer.parseInt(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }

        System.out.println("action: " + action + " / user: " + phoneUser);

        Tank tank;
        switch (action) {
            case "insert":
                tank = GsonFactory.getPOJO(request.getReader(), Tank.class);
                response.getWriter().write(DAOFactory.getTankDAO().save(tank) ? "true" : "false");
                break;

            default:
                break;
        }

        response.getWriter().flush();
    }

}
