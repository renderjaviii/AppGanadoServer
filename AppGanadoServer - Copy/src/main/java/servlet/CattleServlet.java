package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;
import model.vo.Cattle;
import model.vo.Estate;
import org.springframework.web.servlet.HandlerMapping;
import util.GsonFactory;

@WebServlet("/cattle")
public class CattleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CattleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getHeader("action");

        Long phoneUser = null;
        Integer idCattle = null;
        
        try {
            phoneUser = Long.parseLong(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }
        
        try {
            idCattle = Integer.valueOf(request.getHeader("id"));
        } catch (NumberFormatException ex) {
        }

        System.out.println("action: " + action + " / phone_user: " + phoneUser);

        switch (action) {
            case "getAll":// GetAll by user_phone
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getCattleDAO().getCattlesByUser(phoneUser)));
                break;

            case "getOne":// Get one
                Cattle cattle = GsonFactory.getPOJO(request.getReader(), Cattle.class);
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getCattleDAO().getCattle(cattle)));
                break;

            case "delete":
                System.out.print("idCattle = " + idCattle);
                Boolean validation = DAOFactory.getCattleDAO().delete(idCattle);
                response.getWriter().write(validation ? "true" : "false");

                break;
            default:
                break;
        }

        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getHeader("action");

        System.out.println("action: " + action);

        switch (action) {
            case "insert":
                Cattle cattle = GsonFactory.getPOJO(request.getReader(), Cattle.class);
                response.getWriter().write(DAOFactory.getCattleDAO().save(cattle) ? "true" : "false");
                break;

            default:
                break;
        }

        response.getWriter().flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
