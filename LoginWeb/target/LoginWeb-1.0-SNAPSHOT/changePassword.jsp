<html>
<head>
    <title>Change Password</title>
</head>
<body>
    <h2>Change Password</h2>
    <form method="post" action="ChangePasswordServlet">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="oldPassword" placeholder="Current Password" required><br>
        <input type="password" name="newPassword" placeholder="New Password" required><br>
        <button type="submit">Change Password</button>
    </form>
    <a href="login.jsp">Back to Login</a>
    <c:if test="${not empty param.error}">
        <p style="color:red;">${param.error}</p>
    </c:if>
</body>
</html>
