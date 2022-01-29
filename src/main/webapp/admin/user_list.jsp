<%@ page import="com.bookstore.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mange Users - Administration dashboard</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<header align="center">
    <h2>User Management</h2>
    <h3><a href="">Create New User</a></h3>

    <input type="hidden" name="userList" value="<%=request.getAttribute("userList")%>">


</header>
<div align="center">
    <table border="1">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>FullName</th>
            <th>Actions</th>
        </tr>

        <%
            ArrayList<User> users =
                (ArrayList<User>)request.getAttribute("userList");
            for(User user:users){%>
        <tr>
            <td></td>
            <td><%=user.getId()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getFullName()%></td>
        </tr>
        <%}%>
    </table>
</div>

<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
