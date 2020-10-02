
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ads">Adlister</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <!-- If user is logged in they only see a logout button -->
                    <li><a href="/profile">View Profile</a></li>
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </div>
            </div>
        </nav>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ads">Adlister</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <!-- If user is not logged in they only see a login button -->
                    <li><a href="/login?from=${pageContext.request.requestURI}">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </ul>
            </div>
            </div>
        </nav>
    </c:otherwise>
</c:choose>

