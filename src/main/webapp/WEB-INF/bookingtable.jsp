<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String pageName = "Bookingtable";%>


<html>
<head>
    <title></title>
    <script type='text/javascript' src='<c:url value="../static/jquery-2.1.1.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<form class="form-inline">
    <div>
        <input type="text" name="page" value="${pageNumber+1}" hidden="hidden"/>
        <input type="text" name="rows" value="${rowsCount}" hidden="hidden"/>
    </div>

    <%--<button id="changeBtn" name="action" value="bookingTableEdit" type="submit" class="btn">Next</button>--%>
    <button id="changeBtn" type="submit" class="btn">Next</button>

</form>
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

                        <%--<%--%>
                        <%--List<BookingTable> tableList=new ArrayList<BookingTable>(BookingTableAction.tableList);--%>

                        <%--request.setAttribute("list",tableList);--%>
                        <%--%>--%>


                        <c:forEach items="${list}" var="bt">

                            <tr>
                                <td>${bt.dateFrom}</td>
                                <td>"${bt.dateTo}</td>
                                <td>${bt.dayCount}</td>
                                <td>${bt.roomNo}</td>
                            </tr>
                        </c:forEach>
                        <hr>
                        <tr>
                            <div>
                                <form class="form-inline">
                                    <div>
                                        <%--totalpagenumber--%>
                                        <input type="text" name="page" value="${pageNumber+1}" hidden="hidden"/>
                                        <input type="text" name="rows" value="${rowsCount}" hidden="hidden"/>
                                    </div>

                                    <%--<button id="changeBtn" name="action" value="bookingTableEdit" type="submit" class="btn">Next</button>--%>
                                    <button id="changeBtn" type="submit" class="btn">Next</button>

                                </form>
                                <form class="form-inline">
                                    <div>
                                        <input type="text" name="page" hidden="hidden"/>
                                        <input type="text" name="rows" hidden="hidden"/>
                                    </div>

                                    <button id="changeBtn2" name="action" value="bookingTableEdit" type="submit"
                                            class="btn">Back
                                    </button>

                                </form>
                            </div>
                        </tr>

                        </tbody>
                    </table>
                    <%--     --%>

                    <hr>
                    <form class="form-inline" method="get">
                        <div>
                            <input type="text" name="page" hidden="hidden"/>
                            <input type="text" name="rows" hidden="hidden"/>
                        </div>

                        <button id="changeBtn3" name="action" value="adminRederect" type="submit" class="btn">Перейти на
                            главную страницу
                        </button>

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
