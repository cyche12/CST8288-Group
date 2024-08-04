//Class: CST8288//
//Section: 033//
//Professor: Islam Gomaa//
//Assignment: Final Project//
//Date: 23/7/2024//
//Authors: Jake Elliott, Navjot Kaur, Heeseok Yang, Scott Valair//

package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/LoginServlet") // Comment or remove this line
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDao;

    public LoginServlet() {
        super();
        userDao = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isAuthenticated = userDao.authenticate(email, password);
        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            String userType = userDao.getUserType(email);
            switch (userType) {
                case "Retailer":
                    response.sendRedirect("RetailerServlet");
                    break;
                case "Consumer":
                    response.sendRedirect("ConsumerServlet");
                    break;
                case "Charitable_Organization":
                    response.sendRedirect("CharitableServlet");
                    break;
                default:
                    request.setAttribute("error", "Invalid user type");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } else {
            request.setAttribute("error", "Invalid email or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
