<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Page</title>
<link rel="stylesheet" href="/./styles2.css">
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
            <option value="RETAIL">Retail</option>
            <option value="CONSUMER">Consumer</option>
            <option value="CHARITY">Charity</option>
        </select>
        
        <input type="date" name="joinDate" placeholder="Join Date" required>
        <textarea name="foodPreferences" placeholder="Food Preferences"></textarea>
        <div>
            <label>Subscribe to alerts:</label>
            <input type="radio" name="subscribe" value="Yes" id="subscribe-yes">
            <label for="subscribe-yes">Yes</label>
            <input type="radio" name="subscribe" value="No" id="subscribe-no">
            <label for="subscribe-no">No</label>
        </div>
        <div id="notification-method" style="display:none;">
            <input type="checkbox" name="smsNotification" value="SMS" id="sms-notification">
            <label for="sms-notification">SMS Notification</label>
            <br>
            <input type="checkbox" name="emailNotification" value="Email" id="email-notification">
            <label for="email-notification">Email Notification</label>
        </div>
        <input type="submit" value="Register">
    </form>
    
</div>

<script>
    document.querySelectorAll('input[name="subscribe"]').forEach(radio => {
        radio.addEventListener('change', function() {
            if (this.value === 'Yes') {
                document.getElementById('notification-method').style.display = 'block';
            } else {
                document.getElementById('notification-method').style.display = 'none';
            }
        });
    });
</script>

</body>
</html>
