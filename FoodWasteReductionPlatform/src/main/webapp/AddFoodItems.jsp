<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Food Item</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>

<div class="add-food-item-container">
    <h2>Add Food Item</h2>
    <form action="AddFoodItemServlet" method="post">
        <input type="text" name="foodId" placeholder="Food ID" required>
        <input type="text" name="foodName" placeholder="Food Name" required>
        <input type="number" name="foodQuantity" placeholder="Quantity" required>
        <input type="number" step="0.01" name="foodCost" placeholder="Cost" required>
        <input type="date" name="foodExpiry" placeholder="Expiry Date" required>
        <input type="text" name="retailerId" placeholder="Retailer ID" required>
        <input type="submit" value="Add Food Item">
    </form>
</div>

</body>
</html>