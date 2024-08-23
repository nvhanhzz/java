<html>
<head>
    <title>Forget Password</title>
</head>
<body>
    <h2>Forget Password</h2>
    <form method="post" action="ForgetPasswordServlet">
        <input type="text" name="identifier" placeholder="Email or Phone" required><br>
        <button type="submit">Reset Password</button>
    </form>
    <a href="login.jsp">Back to Login</a>
    <c:if test="${not empty param.error}">
        <p style="color:red;">${param.error}</p>
    </c:if>
</body>
</html>
