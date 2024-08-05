<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="database.SurplusFoodDAO" %>
<%@ page import="database.SurplusFoodDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Items</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>

<div class="surplus-items-container">
    <h2>Surplus Items</h2>
    <table>
        <thead>
            <tr>
                <th>Surplus ID</th>
                <th>Food ID</th>
                <th>Retailer ID</th>
                <th>Purchase Type</th>
                <th>Listing Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();
                List<SurplusFoodDTO> surplusItems = surplusFoodDAO.getAllSurplusFood();
                for (SurplusFoodDTO item : surplusItems) {
            %>
            <tr>
                <td><%= item.getSurplusId() %></td>
                <td><%= item.getFoodId() %></td>
                <td><%= item.getRetailerId() %></td>
                <td><%= item.getPurchaseType() %></td>
                <td><%= item.getListingDate() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
