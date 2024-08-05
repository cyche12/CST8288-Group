<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>

<div class="dashboard-container">
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <nav>
        <ul>
            <% if ("CONSUMER".equals(userType)) { %>
                <li><a href="viewAvailableItems.jsp">View Available Items</a></li>
            <% } else if ("RETAILER".equals(userType)) { %>
                <li><a href="viewInventory.jsp">View Inventory</a></li>
                <li><a href="addFoodItem.jsp">Add Food Item</a></li>
                <li><a href="viewSurplusItems.jsp">View Surplus Items</a></li>
            <% } else if ("CHARITABLE_ORGANIZATION".equals(userType)) { %>
                <li><a href="viewAvailableDonations.jsp">View Available Donations</a></li>
            <% } %>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>
</div>

</body>
</html>
