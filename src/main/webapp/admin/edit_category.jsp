
<%@ page import="com.bookstore.entity.Category" %>
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
    <%Category category = (Category) request.getAttribute("category");%>
    <h1>Edit Category Now!<span>Edit Category and tell us what you think of the site!</span></h1>
    <form action="update_category" method="post" onsubmit="return validateFormInput()">
        <div class="section"><span>1</span> Name</div>
        <div class="inner-wrap">

            <input type="hidden" name="id" value=<%=category.getId()%>>

            <label>Your Name <input type="text" id="name" name="name" value=<%=category.getName()%>></label>
        </div>

        <div class="button-section">
            <input type="submit" name="Edit"/>
            <span class="privacy-policy">
     <input type="checkbox" name="checkbox">You agree to our Terms and Policy.
     </span>
        </div>
    </form>
</div>

</body>

<script src="js/category/edit_category.js"></script>

</html>
