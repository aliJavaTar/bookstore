<header align="center">
    <img src="../image/admin/BookstoreAdminLogo.png" alt="no image">
    <div>
        <%String message = (String) session.getAttribute("email");%>
        <%if (message != null) {%>
        Welcome :  <%=message%> | <a href="logout"> Logout</a>
        <%}%>
        <% if (message == null) { %>
        Welcome <a href="logout"> Logout</a>
        <%}%>
    </div>

    <!--------------------->
    <div style="margin: 32px auto; display: flex; justify-content: center;">
        <div style="margin: 0 16px;">
            <a href="user_list"
               style="color: black; text-align: center; vertical-align: baseline; text-decoration: none;">
                <i class="fas fa-user-tie fa-3x" style="display: block;"></i>
                <div style="font-size: large; margin-top: 4px">Users</div>
            </a>
        </div>
        <div style="margin: 0 16px;">
            <a href="list_category"
               style="color: black;text-align: center;vertical-align: baseline; text-decoration: none;">
                <i class="fas fa-folder-open fa-3x" style="display: block;"></i>
                <div style="font-size: large; margin-top: 4px">Categories</div>
            </a>
        </div>
        <div style="margin: 0 16px;">
            <a href="list_books" style="color: black;text-align: center;vertical-align: baseline; text-decoration: none;">
                <i class="fas fa-book fa-3x" style="display: block;"></i>
                <div style="font-size: large; margin-top: 4px">Books</div>
            </a>
        </div>
        <div style="margin: 0 16px;">
            <a href="#" style="color: black;text-align: center;vertical-align: baseline; text-decoration: none;">
                <i class="fas fa-user-friends fa-3x" style="display: block;"></i>
                <div style="font-size: large; margin-top: 4px">Customers</div>
            </a>
        </div>
        <div style="margin: 0 16px;">
            <a href="#" style="color: black;text-align: center;vertical-align: baseline; text-decoration: none;">
                <i class="fas fa-shopping-cart fa-3x" style="display: block;"></i>
                <div style="font-size: large; margin-top: 4px">Orders</div>
            </a>
        </div>
    </div>
</header>









