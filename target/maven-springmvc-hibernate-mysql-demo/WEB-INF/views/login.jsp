<%--
  User: keitsi
  Date: 16-10-22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/authenticate" method="post">
    <div>
        <label for="user_name">User Name: </label>
        <input id="user_name" name="userName" type="text">
    </div>
    <div>
        <label for="password">Password: </label>
        <input id="password" name="password" type="password">
    </div>
    <div>
        <input type="submit" value="submit">
    </div>
    <p style="color: red;"><%=request.getParameter("errorMessage") == null ? "" : request.getParameter("errorMessage")%>
    </p>
</form>
</body>
</html>