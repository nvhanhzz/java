<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form method="post" action="LoginServlet">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Login</button>
    </form>
    <a href="forgetPassword.jsp">Forgot Password?</a>
    <c:if test="${not empty param.error}">
        <p style="color:red;">${param.error}</p>
    </c:if>
    <c:if test="${not empty param.message}">
        <p style="color:green;">${param.message}</p>
    </c:if>
</body>
</html>
