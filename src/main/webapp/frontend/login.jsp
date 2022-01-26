<%--
  Created by IntelliJ IDEA.
  User: Lion
  Date: 1/26/2022
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="header/haeder.jsp"/>

<header align="center">

    <h2>Please Login : </h2>
    <form>
        Email : <input type="text" size="10">
        Password:<input type="password" size="10"><br>
        <input type="submit" value="login">
    </form>

</header>
<jsp:include page="footer/footer.jsp"/>
</body>
</html>
