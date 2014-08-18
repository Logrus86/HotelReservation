<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.ad.entity.Customer" %>
<%@ page import="com.epam.ad.action.CustomerTableAction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String pageName ="Customerdetail";%>
<%! int countPlus=40;%>
<%
    List<Customer> customerList=new ArrayList<Customer>(CustomerTableAction.customers);
    request.setAttribute("list",customerList);

    if (countPlus<50)countPlus=countPlus+10; else countPlus=1;
%>

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
                        <caption>Customer Details</caption>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>City</th>
                            <th>Region</th>
                            <th>Country</th>
                            <th>Passport</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Prepayment</th>
                            <th>Book Id</th>
                        </tr>
                        </thead>
                        <tbody>


                        <c:forEach items="${list}" var="cust">

                            <tr><td>${cust.id}</td>
                                <td>"${cust.firstName}</td>
                                <td>${cust.lastName}</td>
                                <td>${cust.city}</td>
                                <td>${cust.region}</td>
                                <td>"${cust.country}</td>
                                <td>${cust.passport}</td>
                                <td>${cust.phone}</td>
                                <td>${cust.email}</td>
                                <td>"${cust.prepayment}</td>
                                <td>"${cust.bookId}</td>
                            </tr>
                        </c:forEach>
                        <hr>
                        <tr>

                                <div>
                                    <form id="next" class="form-inline"  method="post">
                                        <div>
                                            <input type="text" name="counts" value="${counts+0}" placeholder="${counts+0}" hidden="hidden" />
                                            <input type="text" name="steps" value="1" placeholder="1" hidden="hidden" />
                                        </div>
                                        <button id="changeBtn" name="action" value="customerEdit" type="submit" class="btn">Next</button>

                                    </form>
                                    <form id="back" class="form-inline" method="post">
                                        <div>
                                            <input type="text" name="steps" value="-1" placeholder="-1" hidden="hidden" />
                                            <input type="text" name="counts" value="${counts+0}" placeholder="${counts+0}" hidden="hidden"/>
                                        </div>
                                        <button id="changeBtn2" name="action" value="customerEdit" type="submit" class="btn">Back</button>

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
                            <li class="active"><a href="#tab1" data-toggle="tab">Добавить клиента</a></li>
                            <li><a href="#tab2" data-toggle="tab">Изменить данные клиента</a></li>
                            <li><a href="#tab3" data-toggle="tab">Удалить клиента</a></li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab1">
                                <p>
                                <h3>Пожалуйста введите данные: </h3>
                                <form action="${pageContext.request.contextPath}/action" method="post" class="form-horizontal" role="form">

                                    <div class="form-group">
                                        <label for="inputFirstName" class="col-sm-2 control-label">First name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputFirstName" name="inputFirstName"
                                                   placeholder="First name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputLastName" class="col-sm-2 control-label">Last name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputLastName" name="inputLastName"
                                                   placeholder="Last name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputCity" class="col-sm-2 control-label">City</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputCity" name="inputCity"
                                                   placeholder="City">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputRegion" class="col-sm-2 control-label">Region</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputRegion" name="inputRegion"
                                                   placeholder="Region">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputCountry" class="col-sm-2 control-label">Country</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputCountry" name="inputCountry"
                                                   placeholder="Country">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassport" class="col-sm-2 control-label">Passport No</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputPassport" name="inputPassport"
                                                   placeholder="Passport No">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPhone" class="col-sm-2 control-label">Phone No</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputPhone" name="inputPhone"
                                                   placeholder="Phone No">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail" name="inputEmail"
                                                   placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-2 control-label">Prepayment</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="inputPrepayment" name="inputPrepayment"
                                                   placeholder="inputPrepayment">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-2 control-label">Book Id</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="inputBookId" name="inputBookId"
                                                   placeholder="inputBookId">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Remember Password
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">

                                            <button type="submit" class="btn" name="action" value="createCustomer" > Confirm </button>
                                        </div>
                                    </div>
                                </form>


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
