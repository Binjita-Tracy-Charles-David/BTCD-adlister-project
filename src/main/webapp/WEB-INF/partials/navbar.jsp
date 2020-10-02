<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>

        <ul class="nav navbar-nav navbar-right ">
<%--        Here's where I'd put my search, if i had one.--%>
<%--            <li>--%>
<%--                <form class="form-inline my-2 my-lg-0">--%>
<%--                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--                </form>--%>
<%--            </li>--%>
            <li><a href="/login?from=${pageContext.request.requestURI}">Login</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
        <%--            <li><a href="/login">Login</a></li>--%>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
