<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="counts" type="java.lang.Integer"--%>
<%@ page import="com.epam.ad.action.RoomTableAction" %>
<%@ page import="com.epam.ad.entity.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String pageName ="Roomdetail";%>


<html>
<head>
    <title></title>
    <script type='text/javascript' src='<c:url value="../static/jquery-2.1.1.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

<div id="roomAdminGeneral">
    <table cellpadding="0" cellspacing="0" border="1" width="100%">
        <tr>
            <td>
                <div id="roomEditLeft">
                    <%--<%@include file="adminnav.jspf"%>--%>
                </div>
            </td>
            <td>
                <div id="roomEditRight">



                            <table class="table table-bordered table-hover table-condensed">
                                <caption>List of rooms available</caption>
                                <thead>
                                <tr>
                                    <th>Room No</th>
                                    <th>Room Type</th>
                                    <th>Bed Type</th>
                                    <th>Tarif</th>
                                </tr>
                                </thead>
                                <tbody>

                                <%
                                    List<Room> roomArraylist=new ArrayList<Room>(RoomTableAction.rooms);
                                    request.setAttribute("list",roomArraylist);
                                %>

                                <c:forEach items="${list}" var="roomI">

                                    <tr><td>${roomI.roomNo}</td>
                                        <td>"${roomI.roomType}</td>
                                        <td>${roomI.roomBed}</td>
                                        <td>${roomI.roomRate}</td></tr>
                                </c:forEach>
                                <hr>
                                <tr>
                                    <div>
                                        <form class="form-inline" method="post">
                                            <div>
                                                <input type="text" name="counts" value="${counts+0}" placeholder="${counts+0}" hidden="hidden" />
                                                <input type="text" name="steps" value="1" placeholder="1" hidden="hidden"/>
                                            </div>
                                            <button id="changeBtn" name="action" value="roomEdit" type="submit" class="btn">Next</button>

                                        </form>
                                        <form class="form-inline"  method="post">
                                            <div>
                                                <input type="text" name="counts" value="${counts+0}"placeholder="${counts+0}" hidden="hidden" />
                                                <input type="text" name="steps" value="-1" placeholder="-1" hidden="hidden"/>
                                            </div>
                                            <button id="changeBtn2" name="action" value="roomEdit" type="submit" class="btn">Back</button>

                                        </form>

                                    </div>
                                </tr>
                                </tbody>
                            </table>
                            <hr>
                    <form class="form-inline"  method="post" >
                        <div>
                            <input type="text" name="counts" value="${counts}"placeholder="${counts}" hidden="hidden"/>
                            <input type="text" name="steps" value="-1" placeholder="-1" hidden="hidden"/>
                        </div>

                        <button id="changeBtn3" name="action" value="adminRederect" type="submit" class="btn">Перейти на главную страницу</button>

                    </form>





                            <div class="tabbable" tabs-below> <!-- Only required for left/right tabs -->
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab1" data-toggle="tab">Добавить комнату</a></li>
                                    <li><a href="#tab2" data-toggle="tab">Изменить характеристики комнаты</a></li>
                                    <li><a href="#tab3" data-toggle="tab">Удалить комнату</a></li>

                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab1">
                                        <p>


                                        </p>
                                    </div>
                                    <div class="tab-pane" id="tab2">
                                        <p>Привет, я 2-я секция.</p>
                                    </div>
                                    <div class="tab-pane" id="tab3">
                                        <p>Привет, я 3-я секция.</p>
                                    </div>
                                    <div class="tab-pane" id="tab4">
                                        <p>Привет, я 4-я секция.</p>
                                    </div>
                                </div>
                            </div>









                </div>
            </td>
        </tr>
    </table>


</div>


</body>
</html>
