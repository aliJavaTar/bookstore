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
    <h3><a href="user_form.jsp">Create New User</a></h3>
    <%--    <input type="hidden" name="userList" value="<%=request.getAttribute("userList")%>">--%>
</header>
<div align="center">
<%--        <input type="hidden" name="message" value="<%=request.getAttribute("message")%>">--%>
    <% String message = (String) request.getAttribute("message");%>
    <%
        if (message != null) {
    %>
    <h4><%=message%></h4>
    <%
        }
    %>

</div>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>FullName</th>
            <th>Actions</th>
        </tr>


        <%
            ArrayList
                    <User> users = (ArrayList<User>) request.getAttribute("userList");
            int index = 0;
            for (User user : users) {
               index++;
        %>
        <tr>
            <td><%=index%>
            </td>
            <td><%=user.getId()%>
            </td>
            <td><%=user.getEmail()%>
            </td>
            <td><%=user.getFullName()%>
            </td>
            <td>
                <a href="edit_user?id=<%=user.getId()%>">  Edit </a> &nbsp;
                <a href="javascript:confirmDelete(<%=user.getId()%>)">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
<script>
    function confirmDelete(id)
    {
        if (confirm("Are you sure you want to delete the user with ID " + id + " ?"))
        {
            window.location='delete_user?id='+id;
        }
    }
</script>
</html>
