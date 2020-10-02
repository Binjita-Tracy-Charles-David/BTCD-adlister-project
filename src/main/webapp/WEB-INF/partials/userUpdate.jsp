<%--
  Created by IntelliJ IDEA.
  User: tracyvelasquez
  Date: 10/1/20
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="btn-group" role="group" >
    <a href="/users/update?id=${param.id}"  type="button" class="btn btn-secondary"><i class="fas fa-pen"></i></a>
    <a href="/users/delete?id=${param.id}" type="button" class="btn btn-secondary"><i class="far fa-trash-alt"></i></a>
</div>

