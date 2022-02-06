<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bookstore.entity.Category" %>
<header align="center">
    <img src="image/bookStore.png" alt="ali">
    <div>
        <input type="text" name="keyword" size="50"/>
        <input type="button" value="Search"/>
        |<a href="login">Sign In </a> |
        <a href="register"> Register</a> |
        <a href="view_cart"> Cart</a> |
    </div>
    <div>&nbsp;</div>
    <div>
        <%
            //            ApplicationContext.getCategoryService().findAll().size();
            ArrayList
                    <Category> categories = (ArrayList<Category>) request.getAttribute("listCategory");
            for (Category category : categories) {
        %>
        <a href="view_category?id="<%=category.getId()%>>
         <font size="+1"><b><%=category.getName()%></b> </font> </a>
        &nbsp; | &nbsp;
        <%}%>

    </div>
</header>