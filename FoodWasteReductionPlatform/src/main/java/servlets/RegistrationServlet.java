package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.UserDAO;
import database.UserDTO;
import enums.UserType;
import java.util.logging.Logger;

public class RegistrationServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private UserDAO userDao;
    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getName());

    public RegistrationServlet() {
        super();
        userDao = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType").toUpperCase();
        String joinDate = request.getParameter("joinDate");

        LOGGER.info("UserType received: " + userType);

        UserDTO user = new UserDTO();
        user.setUserId(UUID.randomUUID().toString());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserEmail(email);
        user.setUserPassword(password);

        try {
            user.setUserType(UserType.valueOf(userType));
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Invalid userType: " + userType);
            request.setAttribute("error", "Invalid user type. Please select a valid user type.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Date sqlJoinDate = Date.valueOf(joinDate);
            user.setJoinDate(sqlJoinDate);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Invalid date format. Please use the date picker.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
            dispatcher.forward(request, response);
            return;
        }

        boolean isUserAdded = userDao.addUser(user);
        if (isUserAdded) {
            response.sendRedirect("AvailableItems.jsp");
        } else {
            LOGGER.severe("Failed to register user");
            request.setAttribute("error", "Failed to register user");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
            dispatcher.forward(request, response);
        }
    }
}
