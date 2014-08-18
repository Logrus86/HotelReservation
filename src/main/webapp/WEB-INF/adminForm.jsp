
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String pageName ="Main";%>


<html>
<head>
    <title>Main page</title>
    <script type='text/javascript' src='<c:url value="../static/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<p>admin form</p>
 <%--<%@include file="adminnav.jspf"%>--%>
<form class="form-inline" method="post">

    <div>
        <input type="text" name="counts"  placeholder="${counts}" hidden="hidden" />
        <input type="text" name="steps" value="1" placeholder="1" hidden="hidden" />
    </div>

    <button  name="action" value="bookingTableEdit" type="submit" class="btn">Редактирование Журнала бронирования</button>
    <hr>
    <button  name="action" value="customerEdit" type="submit" class="btn">Редактирование данных клиентов</button>
    <hr>
    <button  name="action" value="roomEdit" type="submit" class="btn">Редактирование параметров комнат</button>
    <hr>
</form>


</body>
</html>
