<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bookstore.entity.Books" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mange Users - Administration dashboard</title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://kit.fontawesome.com/c58c537f6b.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<header align="center">
    <h1 class="page_head_line">Book Management</h1>
    <h3><a href="new_book">Create New Book</a></h3>
    <%--    <input type="hidden" name="userList" value="<%=request.getAttribute("userList")%>">--%>
</header>
<div align="center">
    <%--        <input type="hidden" name="message" value="<%=request.getAttribute("message")%>">--%>
    <% String message = (String) request.getAttribute("message");%>
    <%
        if (message != null) {
    %>
    <h4 class="message"><%=message%>
    </h4>
    <%
        }
    %>

</div>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Image</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>Last Update</th>
            <th>Action</th>

        </tr>


        <%
            ArrayList <Books> books = (ArrayList<Books>) request.getAttribute("books");
            int index = 0;
            for (Books book : books) {
                index++;
        %>
        <tr>
            <td><%=index%>
            </td>

            <td><%=book.getId()%></td>

            <td><img src="../image/<%=book.getId()%>.jpg" alt="no image" style="width: 120px; height: 120px;object-fit: cover;object-position: center;"></td>

            <td><%=book.getTitle()%></td>

            <td><%=book.getAuthor()%></td>

            <td><%=book.getCategory()%></td>

            <td><%=book.getPrice()%></td>

            <td><%=book.getUpdate_at()%></td>

            </td>
            <td>
                <a href="edit_book?id=<%=book.getId()%>"> Edit </a> &nbsp;
                <a href="javascript:confirmDelete(<%=book.getId()%>)">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Are you sure you want to delete the book with ID " + id + " ?")) {
            window.location = 'delete_book?id=' + id;
        }
    }
</script>
</html>
