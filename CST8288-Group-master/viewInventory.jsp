<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="database.FoodItemDAO" %>
<%@ page import="database.FoodItemDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>

<div class="inventory-container">
    <h2>Inventory</h2>
    <table>
        <thead>
            <tr>
                <th>Food ID</th>
                <th>Food Name</th>
                <th>Quantity</th>
                <th>Cost</th>
                <th>Expiry Date</th>
                <th>Retailer ID</th>
            </tr>
        </thead>
        <tbody>
            <%
                FoodItemDAO foodItemDAO = new FoodItemDAO();
                List<FoodItemDTO> foodItems = foodItemDAO.getAllFoodItems();
                for (FoodItemDTO item : foodItems) {
            %>
            <tr>
                <td><%= item.getFoodId() %></td>
                <td><%= item.getFoodName() %></td>
                <td><%= item.getFoodQuantity() %></td>
                <td><%= item.getFoodCost() %></td>
                <td><%= item.getFoodExpiry() %></td>
                <td><%= item.getRetailerId() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
