<%@ page import="com.bookstore.entity.Category" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Book</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>

<header align="center">
    <h1 class="page_head_line">Create New Book</h1>
</header>


<div align="center">
    <form action="create_book" method="post" enctype="multipart/form-data" onsubmit="return validateFormInput()">
        <table class="form">
            <tr>
                <td align="right">Category:</td>
                <td align="left">
                    <select id="category" name="category">
                        <%
                            ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categoryList");
                            for (Category category : categories) { %>
                        <option value=<%=category.getId()%>><%=category.getName()%>
                        </option>
                        <% } %>
                    </select>
                </td>
            </tr>

            <tr>

                <td align="right">Title:</td>
                <td align="left"><input type="text" id="title" name="title" size="20"></td>
            </tr>
            <br>
            <tr>

                <td align="right">Author:</td>
                <td align="left"><input type="text" id="author" name="author" size="20"></td>
                <br>
            </tr>
            <tr>
                <td align="right">price:</td>
                <td align="left"><input type="number" id="price" name="price" size="20"></td>
            </tr>

            <tr>
                <td align="right">isbn:</td>
                <td align="left"><input type="text" id="isbn" name="isbn" size="20"></td>
            </tr>

            <tr>
                <td align="right">publish_date:</td>
                <td align="left"><input type="date" id="publish_date" name="publish_date" size="20"></td>
            </tr>

            <tr>
                <td align="right">Book Image :</td>
                <td align="left"><input type="file" id="image" name="image" size="20"></td>
<%--                <img id="thumbnail" alt="Image Preview">--%>
                <img alt="Image" src="${string4}" width="160" height="160"/>
            </tr>

            <tr>
                <td align="right">description:</td>
                <td align="left"><textarea id="description" name="description" size="20"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="refresh();">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

    function showImage(fileInput) {
        let file = fileInput.files[0];
        let reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById("thumbnail").attr('src', e.target.result);
        };
        reader.readAsDataURL(file);

    }

    function validateFormInput() {
        let fieldTitle = document.getElementById("title");
        let fieldAuthor = document.getElementById("author");
        let fieldPrice = document.getElementById("price");
        if (fieldTitle.value.length == 0) {
            alert("email is required!")
            fieldTitle.focus();
            return false;
        }

        if (fieldAuthor.value.length == 0) {
            alert("fullName is required!")
            fieldAuthor.focus();
            return false;
        }
        if (fieldPrice.value.length == 0) {
            alert("password is required!")
            fieldPrice.focus();
            return false;
        }
        return true;
    }

    function refresh() {
        //Refresh page implementation here
        window.location.href = "http://localhost:8080/BookStorWebsit_war_exploded/admin/book_list";
        // window.opener.location.reload();
        window.close();
    }
</script>
</html>
