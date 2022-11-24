<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged In</title>
</head>
<body>
    <h2>Hi <%= request.getAttribute("user")%> , you successfully logged in!</h2>
    <a href="login.html">Login Page</a>
</body>
</html>
