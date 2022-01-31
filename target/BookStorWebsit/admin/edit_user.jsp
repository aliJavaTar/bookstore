<%@ page import="com.bookstore.entity.User" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Form Style 10</title>
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="./css/edit.css">
</head>

<body>

<div class="form-style-10">
    <%User user = (User) request.getAttribute("user");%>
    <h1>Edit User Now!<span>Edit User and tell us what you think of the site!</span></h1>
    <form action="update_user" method="post" onsubmit="return validateFormInput()">
        <div class="section"><span>1</span>First Name</div>
        <div class="inner-wrap">
            <label>Your Full Name <input type="text" id="fullName" name="fullName" value=<%=user.getFullName()%>></label>
        </div>

        <div class="section"><span>2</span>Email </div>
        <div class="inner-wrap">
            <label>Email Address <input type="email" id="email"  name="email" value=<%=user.getEmail()%>></label>
        </div>

        <div class="section"><span>3</span>Passwords</div>
        <div class="inner-wrap">
            <label>Password <input type="password" id="password" name="password" value=<%=user.getPassword()%>></label>
        </div>
        <div class="button-section">
            <input type="submit" name="Edit" />
            <span class="privacy-policy">
     <input type="checkbox" name="checkbox">You agree to our Terms and Policy.
     </span>
        </div>
    </form>
</div>

</body>

<script src="./js/edit.js"></script>

</html>
