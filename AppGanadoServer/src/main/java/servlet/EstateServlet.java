package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;
import model.vo.Estate;
import util.FacadePersistence;
import util.GsonFactory;

@WebServlet("/estate")
public class EstateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EstateServlet() {
        super();
    }

    @Override
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

        switch (action) {
            case "insert":
                estate = GsonFactory.getPOJO(request.getReader(), Estate.class);
                response.getWriter().write(DAOFactory.getEstateDAO().save(estate) ? "true" : "false");
                break;

            default:
                break;
        }

        response.getWriter().flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getHeader("action");

        Long phoneUser = null;
        Integer idEstate = null;

        try {
            phoneUser = Long.parseLong(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }

        try {
            idEstate = Integer.valueOf(request.getHeader("id"));
        } catch (NumberFormatException ex) {
        }

        System.out.println("action: " + action + " / user: " + phoneUser);

        Estate estate = null;

        switch (action) {
            case "getAll":// Get All by User
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getEstateDAO().getEstatesByUser(phoneUser)));
                break;

            case "getOne":// Get One by Estate_Name a Phone_User
                estate = GsonFactory.getPOJO(request.getReader(), Estate.class);
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getEstateDAO().getEstateByName(estate)));
                break;
            case "delete":
                System.out.print("idEstate = " + idEstate);
                Boolean validation = DAOFactory.getEstateDAO().delete(idEstate);
                response.getWriter().write(validation ? "true" : "false");

                break;

            default:
                break;
        }

        response.getWriter().flush();
    }
}
