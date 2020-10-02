<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<%--    getting all the ads from the database--%>
<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!
        <jsp:include page="/WEB-INF/partials/userUpdate.jsp">
            <jsp:param name="id" value="${user.id}"/>
        </jsp:include>
    </h1>
</div>

<div class="container">
    <h1>Here Are all the ads!</h1>
    <%--Users profile ads --%>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}
                <jsp:include page="/WEB-INF/partials/deledt.jsp">
                    <jsp:param name="id" value="${ad.id}"/>
                </jsp:include>
            </h2>
            <p>${ad.description}</p>
            <a href=""> AD ID : ${ad.id}</a>
        </div>
    </c:forEach>
</div>

</body>
</html>
