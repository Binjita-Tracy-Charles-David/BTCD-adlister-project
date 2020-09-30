<%--
  Created by IntelliJ IDEA.
  User: tracyvelasquez
  Date: 9/29/20
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Implement functionality to display error messages to users if they do something wrong, for example, if they try to register but their passwords don't match, or if they try to create an ad without a title. Consider storing error messages temporarily in the session and having a messages.jsp partial to handle this.--%>

<p style="color:red"><em>${errorMessage}</em></p>
