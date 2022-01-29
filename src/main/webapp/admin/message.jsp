
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<% String message = (String) request.getAttribute("message");%>
<%
    if (message != null) {
%>
<h4 align="center"><%=message%></h4>
<%
    }
%>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
