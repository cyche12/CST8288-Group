<!-- Web Pages/claim.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.FoodItem" %>
<html>
<head>
    <title>Claim Surplus Food Items</title>
</head>
<body>
<h2>Available Surplus Food Items</h2>
<form action="claimItem" method="post">
    <table border="1">
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Expiry Date</th>
            <th>Action</th>
        </tr>
        <%
            List<FoodItem> items = (List<FoodItem>) request.getAttribute("items");
            if (items != null) {
                for (FoodItem item : items) {
        %>
        <tr>
            <td><%= item.getItemName() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getExpirationDate() %></td>
            <td>
                <input type="hidden" name="charityId" value="CHARITY_ID"> <!-- Replace CHARITY_ID with the actual ID -->
                <button type="submit" name="itemId" value="<%= item.getId() %>">Claim</button>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No items available</td>
        </tr>
        <%
            }
        %>
    </table>
</form>
</body>
</html>
