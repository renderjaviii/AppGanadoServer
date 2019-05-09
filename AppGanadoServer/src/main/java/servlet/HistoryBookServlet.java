package servlet;

import java.io.IOException;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.UserApp;
import util.DAOFactory;
import util.EntityManagerUtil;
import util.GsonFactory;

@WebServlet("/history_book")
public class HistoryBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HistoryBook");

        String action = request.getHeader("action");

        System.out.println("action: " + action);

        switch (action) {
            case "insert":
                CattleHistoryBook historyBook = GsonFactory.getPOJO(request.getReader(), CattleHistoryBook.class);
                response.getWriter().write(DAOFactory.getCattleHistoryBookDAO().save(historyBook) ? "true" : "false");
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
        Integer idHistory = null;

        try {
            phoneUser = Long.parseLong(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }

        try {
            idHistory = Integer.valueOf(request.getHeader("id"));
        } catch (NumberFormatException ex) {
        }

        System.out.println("action: " + action + " / user: " + phoneUser);

        switch (action) {
            case "getAll":// Get All by User
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getCattleHistoryBookDAO().getCattleHistoryBookByCattle(phoneUser)));
                break;

            case "delete":
                Boolean validation = DAOFactory.getCattleHistoryBookDAO().delete(idHistory);
                response.getWriter().write(validation ? "true" : "false");

                break;

            default:
                break;
        }

        response.getWriter().flush();
    }
}
