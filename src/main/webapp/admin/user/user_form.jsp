<%@ page import="com.bookstore.entity.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New User</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./js/jquery.validate.min.js"></script>
    <script src="https://kit.fontawesome.com/c58c537f6b.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>


    <header align="center">
    <h1 class="page_head_line">Create New User</h1>
</header>
<div align="center">
    <form action="create_user" method="post" onsubmit="return validateFormInput()">
        <table class="form">
            <tr>
                <%--            <%=User user =%>><%=request.getAttribute("user")%>--%>
                <td align="right">Email:</td>
                <td align="left"><input type="text" id="email" name="email" size="20"></td>
            </tr>
            <br>
            <tr>
                <td align="right">FullName:</td>
                <td align="left"><input type="text" id="fullName" name="fullName" size="20"></td>
                <br>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td align="left"><input type="password" id="password" name="password" size="20"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Save</button>&nbsp;&nbsp;&nbsp;
                        <button type="button" onclick="refresh();">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
    $(document).read(function (){
      $("#userForm").validate({
          rules:{
              email:"required",
              fullName:"required",
              password:"required",
          },
          message:{
              email:"please Enter your EmailAddress ",
              fullName:"please Enter FullName",
              password:"please Enter password",
          }
      })
    });

    function validateFormInput() {
        let fieldEmail = document.getElementById("email");
        let fieldFullName = document.getElementById("fullName");
        let fieldPassword = document.getElementById("password");
        if (fieldEmail.value.length == 0) {
            alert("email is required!")
            fieldEmail.focus();
            return false;
        }
        if (fieldFullName.value.length == 0) {
            alert("fullName is required!")
            fieldFullName.focus();
            return false;
        }
        if (fieldPassword.value.length == 0) {
            alert("password is required!")
            fieldPassword.focus();
            return false;
        }
        return true;
    }

    function refresh() {
        //Refresh page implementation here
        window.location.href = "http://localhost:8080/BookStorWebsit_war_exploded/admin/user_list";
        // window.opener.location.reload();
        window.close();
    }
</script>
</html>
