//Class: CST8288//
//Section: 033//
//Professor: Islam Gomaa//
//Assignment: Final Project//
//Date: 23/7/2024//
//Authors: Jake Elliott, Navjot Kaur, Heeseok Yang, Scott Valair//

package servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.UserDAO;
import database.UserDTO;
import enums.UserType;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	
public RegistrationServlet() {
	super();
	userDao = new UserDAO();
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String userType = request.getParameter("userType");
	String joinDate = request.getParameter("joinDate");

UserDTO user = new UserDTO();
user.setFirstName(firstName);
user.setLastName(lastName);
user.setUserEmail(email);
user.setUserPassword(password);
user.setUserType(UserType.valueOf(userType.toUpperCase()));


try {
	Date sqlJoinDate = Date.valueOf(joinDate);
	user.setJoinDate(sqlJoinDate);
	}
catch (IllegalArgumentException e) {
	request.setAttribute("error", "Invalid date format. Please use the date picker.");
	RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
	return;
	}

boolean isUserAdded = userDao.addUser(user);
if (isUserAdded) {
	response.sendRedirect("login.jsp");
	}
else {
	request.setAttribute("error", "Failed to register user");
	RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
	}
}
}
