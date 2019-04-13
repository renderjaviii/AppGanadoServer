package servlet;

import java.io.IOException;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.UserApp;
import util.DAOFactory;
import util.EntityManagerUtil;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            DAOFactory.getEstateDAO().delete(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }

}
