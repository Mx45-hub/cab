<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form method="post" action="/registration">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="roles">Roles:</label>
        <select id="roles" name="roles" required>
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
        </select><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>