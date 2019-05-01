package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DAOFactory;
import util.GsonFactory;

@WebServlet("/indicators")
public class IndicatorsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public IndicatorsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("IndicatorsServlet....");

        String action = request.getHeader("action");

        Integer idEstate = null;
        Long phoneUser = null;

        try {
            idEstate = Integer.parseInt(request.getHeader("id_estate"));
        } catch (NumberFormatException ex) {
        }
        try {
            phoneUser = Long.parseLong(request.getHeader("phone"));
        } catch (NumberFormatException ex) {
        }

        switch (action) {
            case "getEstateBreedSize":
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getBreedDAO().getBreedsSize(idEstate)));
                break;

            case "getEstatesSize":
                response.getWriter().write(GsonFactory.getJson(DAOFactory.getEstateDAO().getEstateSize(phoneUser)));
                break;
        }

        response.getWriter().flush();
    }

}
