<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet">
     <link rel="stylesheet" href="login.css">
</head>
<body>

<section class='login' id='login'>
    <div class='head'>
        <h1 class='company'>Book Store Admin</h1>
    </div>
    <p class='msg'>Admin Login</p>
    <div>
        <%String message =(String) request.getAttribute("message");%>
        <%if (message!=null){%>
         <h3><%=message%></h3>
         <%}%>
    </div>
    <div class='form'>
        <form action="login" method="post">
            <input type="text" placeholder='email' name="email" class='text' id='email' ><br>
            <input type="password" placeholder='••••••••••••••' name="password" class='password'><br>
            <button class='btn-login' id='do-login' type="submit">Login</button>
<%--            <a href="#" class='btn-login' id='do-login'>Login</a>--%>
            <a href="#" class='forgot'>Forgot?</a>
        </form>
    </div>
</section>

<!-- partial -->
<script  src="login.js"></script>

</body>
</html>
