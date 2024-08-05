<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>

<div class="register-container">
    <h2>Register</h2>
    <form action="RegistrationServlet" method="post">
        <input type="text" name="firstName" placeholder="First Name" required>
        <input type="text" name="lastName" placeholder="Last Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <select name="userType" required>
            <option value="" disabled selected>Select User Type</option>
            <option value="CONSUMER">Consumer</option>
            <option value="RETAILER">Retailer</option>
            <option value="CHARITABLE_ORGANIZATION">Charitable Organization</option>
        </select>
        <input type="date" name="joinDate" placeholder="Join Date" required>
        <input type="submit" value="Register">
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</div>

</body>
</html>
