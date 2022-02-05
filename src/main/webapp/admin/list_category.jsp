<%@ page import="com.bookstore.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bookstore.entity.Category" %>
<%@ page import="com.bookstore.hibernateUtil.appcontext.ApplicationContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mange Category - Administration dashboard</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<header align="center">
    <h2>Category Management</h2>
    <h3><a href="category_form.jsp">Create New Category</a></h3>
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
            <th>Name</th>
            <th>Action</th>

        </tr>


        <%
//            ApplicationContext.getCategoryService().findAll().size();
            ArrayList
                    <Category> categories = (ArrayList<Category>) request.getAttribute("listCategory");
            int index = 0;
            for (Category category : categories) {
                index++;
        %>
        <tr>
            <td><%=index%>
            </td>
            <td><%=category.getId()%>
            </td>
            <td><%=category.getName()%>

            <td>
                <a href="edit_category?id=<%=category.getId()%>">  Edit </a> &nbsp;
                <a href="javascript:confirmDelete(<%=category.getId()%>)">Delete</a>
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
