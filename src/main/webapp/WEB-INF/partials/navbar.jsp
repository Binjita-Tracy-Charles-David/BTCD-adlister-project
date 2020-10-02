<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ads">Adlister</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login?from=${pageContext.request.requestURI}">Login</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
                    <%--            <li><a href="/login">Login</a></li>--%>
            </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ads">Adlister</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login?from=${pageContext.request.requestURI}">Login</a></li>
                </ul>
                    <%--            <li><a href="/login">Login</a></li>--%>
            </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </c:otherwise>
</c:choose>