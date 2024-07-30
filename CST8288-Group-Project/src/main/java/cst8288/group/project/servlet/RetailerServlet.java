/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.cst8288.group.project.servlet;

import main.java.cst8288.group.project.model.FoodItem;
import main.java.cst8288.group.project.service.RetailerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * This servlet handles HTTP requests related to retailer operations,
 * including managing inventory and identifying surplus food items.
 *
 * @version 1.0
 * @since 1.9
 * Course: CST8288
 * Assignment: Final Project
 * Date: 07/30/2024
 * Professor: Islam Gomaa
 */
@WebServlet("/retailer")
public class RetailerServlet extends HttpServlet {
    private RetailerService retailerService;

    @Override
    public void init() throws ServletException {
        this.retailerService = new RetailerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "surplus":
                    identifySurplusItems(request, response);
                    break;
                default:
                    listItems(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addItem.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodId = request.getParameter("foodId");
        try {
            FoodItem item = retailerService.getAllItemsByRetailer(foodId).get(0); // This line needs to be adjusted based on how the items are fetched
            request.setAttribute("item", item);
            request.getRequestDispatcher("/updateItem.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void identifySurplusItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String retailerId = request.getParameter("retailerId");
        retailerService.identifyAndFlagSurplusItems(retailerId);
        listItems(request, response);
    }

    private void listItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String retailerId = request.getParameter("retailerId");
        List<FoodItem> items = retailerService.getAllItemsByRetailer(retailerId);
        request.setAttribute("items", items);
        request.getRequestDispatcher("/inventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add":
                    addItem(request, response);
                    break;
                case "update":
                    updateItem(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String foodId = request.getParameter("foodId");
        String foodName = request.getParameter("foodName");
        int foodQuantity = Integer.parseInt(request.getParameter("foodQuantity"));
        double foodCost = Double.parseDouble(request.getParameter("foodCost"));
        java.util.Date foodExpiry = java.sql.Date.valueOf(request.getParameter("foodExpiry"));
        String retailerId = request.getParameter("retailerId");
        FoodItem newItem = new FoodItem(foodId, foodName, foodQuantity, foodCost, foodExpiry, retailerId);
        retailerService.addItem(newItem);
        response.sendRedirect("retailer?action=list&retailerId=" + retailerId);
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String foodId = request.getParameter("foodId");
        String foodName = request.getParameter("foodName");
        int foodQuantity = Integer.parseInt(request.getParameter("foodQuantity"));
        double foodCost = Double.parseDouble(request.getParameter("foodCost"));
        java.util.Date foodExpiry = java.sql.Date.valueOf(request.getParameter("foodExpiry"));
        boolean isSurplus = Boolean.parseBoolean(request.getParameter("isSurplus"));
        String listingType = request.getParameter("listingType");
        String retailerId = request.getParameter("retailerId");

        FoodItem updatedItem = new FoodItem(foodId, foodName, foodQuantity, foodCost, foodExpiry, retailerId);
        updatedItem.setIsSurplus(isSurplus);
        updatedItem.setListingType(listingType);
        retailerService.updateItem(updatedItem);
        response.sendRedirect("retailer?action=list&retailerId=" + retailerId);
    }
}
