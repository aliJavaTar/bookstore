<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookStore Admin</title>
</head>
<body>
<jsp:include page="header/header.jsp"/>
<br>
<div align="center">
    <h2>Administrative Dashboard</h2>
</div>
<br>
<div align="center" >
    <b>
        <a href="users">Users</a> |
        <a href="categories">Categories</a> |
        <a href="books">Books</a> |
        <a href="customers">Customers</a> |
        <a href="reviews">Reviews</a> |
        <a href="orders">Orders</a>
    </b>
</div>
<br>
<jsp:include page="footer/footer.jsp"/>
</body>
</html>
