jsp:useBean id="randomRoom" scope="request" type="com.epam.ad.entity.Room"/>
<%--<jsp:useBean id="prepayment" scope="request" type="java.lang.Integer"/>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <script type='text/javascript' src='<c:url value="../static/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">


    <title>Customer page</title>
</head>
<body>
<div id="statusbar">
    <div id="statusbarcontent">
        <form action="#search" method="post" id="searchform">
            <p>


            </p>
        </form>

    </div>
</div>
<div id="header">
    <div id="logo">
        <h1><a href="#home" title="Home Page">Сказочный отель на берегу моря</a></h1>

    </div>
    <div id="logo1">

        <h2>Зурбаган</h2>
    </div>


</div>




</body>
</html>
