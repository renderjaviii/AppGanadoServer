package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;
import model.vo.UserApp;
import util.GsonFactory;

@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Starting LoginServlet... ");
        
        UserApp user = GsonFactory.getPOJO(request.getReader(), UserApp.class);
        user = DAOFactory.getUserAppDAO().login(user);

        response.getWriter().write(GsonFactory.getJson(user));
        response.getWriter().flush();
        System.out.println(user == null ? "user not found" : user);

    }

    // GET = obtener
    // POST = crear / login
    // PUT = actualizar o reemplazar
    // DELETE = eliminar / logout
}
