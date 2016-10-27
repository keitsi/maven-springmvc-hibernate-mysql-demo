<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>User Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            padding: 10px 5px;
            border: solid 1px #ccc;
            text-align: center;
        }

        .tg th {
            border: solid 1px #ccc;
            background-color: #f0f0f0;
            padding: 10px 5px;
        }
    </style>
</head>

<body>
<h3>Hello ${LoginUser.userName} <a href=<c:url value="/user/logout"></c:url>>Logout</a></h3>

<br>

<h3>
    Modify User
</h3>

<c:url var="addAction" value="/user/modify"></c:url>

<form action="${addAction}" method="post">
    <table>
        <c:if test="${!empty user.userName}">
            <tr>
                <td>
                    <label for="id">ID: </label>
                </td>
                <td>
                    <input id="id" name="id" value="${user.id}">
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <label for="user_name">User Name: </label>
            </td>
            <td>
                <input id="user_name" name="userName" value="${user.userName}">
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password: </label>
            </td>
            <td>
                <input id="password" name="password" value="${user.password}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty user.userName}">
                    <input type="submit" value="Edit Person"/>
                </c:if>
                <c:if test="${empty user.userName}">
                    <input type="submit" value="Add Person"/>
                </c:if>
            </td>
        </tr>
    </table>
</form>

<br>

<h3>User List</h3>
<c:if test="${!empty allUsers}">
    <table class="tg">
        <tr>
            <th >User ID</th>
            <th width="120">User Name</th>
            <th width="120">Password</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td><a href="<c:url value='/user/edit/${user.id}' />">Edit</a></td>
                <td><a href="<c:url value='/user/remove/${user.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>