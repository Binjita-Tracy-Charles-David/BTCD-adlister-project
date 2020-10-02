<%--
  Created by IntelliJ IDEA.
  User: tracyvelasquez
  Date: 10/1/20
  Time: 6:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Categories" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here are all the categories!</h1>

    <c:forEach var="category" items="${categories}">
        <div class="col-md-6">
            <p>${category.name}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
