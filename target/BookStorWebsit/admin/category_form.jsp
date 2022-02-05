<%@ page import="com.bookstore.entity.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New User</title>
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>

<header align="center">
    <h2>Create New Category</h2>
</header>
<div align="center">
    <form action="create_category" method="post" onsubmit="return validateFormInput()">
        <table>

            <tr>
                <td align="right">Name:</td>
                <td align="left"><input type="text" id="Name" name="Name" size="20"></td>
                <br>
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
        // window.location.href = "http://localhost:8080/BookStorWebsit_war_exploded/admin/user_list";
        window.location="list_category"
        // window.opener.location.reload();
        window.close();
    }

    function validateFormInput() {
        let fieldName = document.getElementById("Name");


        if (fieldName.value.length == 0) {
            alert("Category Name is required!")
            fieldName.focus();
            return false;
        }

        return true;
    }
</script>
</html>
