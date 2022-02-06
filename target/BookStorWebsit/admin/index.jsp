<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bookstore Administration</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="https://kit.fontawesome.com/c58c537f6b.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<header align="center">
    <h2 class="page_head_line">Administration dashboard</h2>
</header>
<div align="center">
    <hr width="60%">
    <h2 class="page_head_line">Quick Actions:</h2>
    <b>
        <a href="create_book">New Book</a> &nbsp;
        <a href="create_user">New User</a> &nbsp;
        <a href="create_category">New category</a> &nbsp;
        <a href="create_customer">New customer</a> &nbsp;
    </b>
</div>
<div align="center">
    <hr width="60%">
    <h2 class="page_head_line" >Recent Sales</h2>
</div>
<div align="center">
    <hr width="60%">
    <h2 class="page_head_line" >Recent Reviews</h2>
</div>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
