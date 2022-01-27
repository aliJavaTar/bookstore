<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bookstore Administration</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<header align="center">
    <h2>Administration dashboard</h2>
</header>
<div align="center">
    <hr width="60%">
    <h2>Quick Actions:</h2>
    <b>
        <a href="create_book">New Book</a> &nbsp;
        <a href="create_user">New User</a> &nbsp;
        <a href="create_category">New category</a> &nbsp;
        <a href="create_customer">New customer</a> &nbsp;
    </b>
</div>
<div align="center">
    <hr width="60%">
    <h2>Recent Sales</h2>
</div>
<div align="center">
    <hr width="60%">
    <h2>Recent Reviews</h2>
</div>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
