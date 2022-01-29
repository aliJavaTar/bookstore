<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New User</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>

<header align="center">
    <h2>Create New User</h2>
</header>
<div align="center">
    <form action="create_user" method="post" onsubmit="return validateFormInput()">
        <table>
            <tr>
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
                    <input type="submit" value="Save">
                    <input type="button" value="Cancel" onclick="refresh();">
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

    function refresh() {
        //Refresh page implementation here
        window.location.href = "http://localhost:8080/BookStorWebsit_war_exploded/admin/user_list";
        // window.opener.location.reload();
        window.close();
    }

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
</script>
</html>
