// src/servlet/ClaimItemServlet.java
package servlet;

import service.CharityService;
import model.FoodItem;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/claimItem")
public class ClaimItemServlet extends HttpServlet {
    private CharityService charityService;

    @Override
    public void init() throws ServletException {
        this.charityService = new CharityService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<FoodItem> items = charityService.getAvailableSurplusItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/claim.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int charityId = Integer.parseInt(request.getParameter("charityId"));
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        try {
            charityService.claimItem(charityId, itemId);
            response.sendRedirect("claimItem");  // Claim 완료 후 재로딩
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
