<%--@elvariable id="counts" type="java.lang.Integer"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="countPlus" type="java.lang.Integer"--%>
<%@ page import="com.epam.ad.entity.BookingTable" %>
<%@ page import="com.epam.ad.action.BookingTableAction" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Askar
  Date: 09.08.2014
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String pageName ="Bookingtable";%>


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
                        <caption>BookingTable</caption>
                        <thead>
                        <tr>
                            <th>Date from</th>
                            <th>Date To</th>
                            <th>Day count</th>
                            <th>Room ID</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            List<BookingTable> tableList=new ArrayList<BookingTable>(BookingTableAction.tableList);

                          request.setAttribute("list",tableList);
                        %>


                       <c:forEach items="${list}" var="bt">

                            <tr><td>${bt.dateFrom}</td>
                                <td>"${bt.dateTo}</td>
                                <td>${bt.dayCount}</td>
                                <td>${bt.roomNo}</td></tr>
                        </c:forEach>
                        <hr>
                        <tr>
                            <div>
                                <form class="form-inline"  method="post">
                                    <div>
                                        <input type="text" name="counts" value="${counts+0}" placeholder="${counts+0}" hidden="hidden" />
                                        <input type="text" name="steps" value="1" placeholder="1" hidden="hidden" />
                                    </div>

                                    <button id="changeBtn" name="action" value="bookingTableEdit" type="submit" class="btn">Next</button>

                                </form>
                                <form class="form-inline"  method="post">
                                    <div>
                                        <input type="text" name="counts" value="${counts+0}"placeholder="${counts+0}" hidden="hidden"/>
                                        <input type="text" name="steps" value="-1" placeholder="-1" hidden="hidden"/>
                                    </div>

                                    <button id="changeBtn2" name="action" value="bookingTableEdit" type="submit" class="btn">Back</button>

                                </form>
                            </div>
                        </tr>

                        </tbody>
                    </table>
    <%--     --%>

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
                            <li class="active"><a href="#tab1" data-toggle="tab">Добавить запись</a></li>
                            <li><a href="#tab2" data-toggle="tab">Изменить запись</a></li>
                            <li><a href="#tab3" data-toggle="tab">Удалить запись</a></li>

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
