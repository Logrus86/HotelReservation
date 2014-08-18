<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Askar
  Date: 29.07.2014
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <style>

    </style>
    <script type='text/javascript' src='<c:url value="../static/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Welcome page</title>
</head>
<body>
<div id="statusbar">
    <div id="statusbarcontent">
        <form action="#search" method="post" id="searchform">
            <p>
                Welcome, ${user.username}!

            </p>
        </form>

    </div>
</div>
<div id="header">
    <div id="logo">
        <h1><a href="#home" title="Home Page">Сказочный отель на берегу моря <p id="yes">${yes}</p></a></h1>

    </div>
    <div id="logo1">

        <h2>Зурбаган</h2>
    </div>

</div>
 <%--<a href="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>

 <-- Modal -->

 <div class="modal"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

     <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         <h3 id="myModalLabel">Modal header</h3>
     </div>
     <div class="modal-body">
         <p>One fine body…</p>
     </div>
     <div class="modal-footer">
         <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>

     </div>
 </div>

 <input type="text" data-provide="typeahead" data-items="4" data-source='["Karaganda", "Moscow"]'>

<images alt="logo" src="<%=request.getContextPath()%>/WEB-INF/crest.jpg" width="100%" height="100%"/>

--%>
<%--<form class="form-inline" action="${pageContext.request.contextPath}/action"  method="post">--%>
    <form class="form-inline"   method="post">
<input name="action" type="hidden" value="changeRoom"/>
<ul id="change" class="nav nav-tabs" >

    <li class="active">Выберите дату заезда:
        <input type="date" name="calendar" value="2014-08-11"
               max="2014-10-09" min="2014-08-11">
      </li>
    <li class="active">Выберите дату выезда:
        <input type="date" name="calendar2" value="2014-08-15"
               max="2014-10-09" min="2012-08-11">
    </li>

    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            Выберите тип номера <span class="caret"></span>
        </a>

        <ul class="dropdown-menu" role="menu">
            <li> <label class="checkbox"><input type="checkbox" name="roomtype" value="AC"> AC</label></li>

            <li><label class="checkbox"><input type="checkbox" name="roomtype" value="Non AC">NonAc</label></li>

        </ul>
    </li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            Выберите кол-во мест <span class="caret"></span>
        </a>

        <ul class="dropdown-menu" role="menu">

            <li> <label class="checkbox"><input type="checkbox" name="bedNo" value="Single">Single</label></li>

            <li><label class="checkbox"><input type="checkbox" name="bedNo" value="Double">Double</label></li>

        </ul>
    </li>
</ul>

    <button id="changeBtn"  type="submit" class="btn">Check Room</button>

<div>
    <input type="text" name="countStr" placeholder="10" value="10" hidden="hidden">
    <input type="text" name="steps" placeholder="10"value="10" hidden="hidden">
</div>



        <%--  <button type="submit" class="btn">Book Room</button>--%>
    </form>
</div>
<hr>

<div id="myCarousel" class="carousel slide">
    <!-- Carousel items -->

    <div class="carousel-inner">
        <div class="active item" title="Change" align="center" ><div id="image1" align="center"></div></div>
        
        <div class="item" title="Luxe" align="center"><div id="image5" align="center"></div></div>
    </div>
    <!-- Carousel nav -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>


<p>${changeForm}</p>
<div class="accordion" id="accordion2" align="center">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                Типы номеров:
            </a>
        </div>
        <div id="collapseOne" class="accordion-body collapse">
            <div class="accordion-inner">
               <p> Отель «Приморский» расположен вблизи крупнейшей транспортной развязки Сочи — Краснодарского кольца, поэтому Вам не составит сложности добраться в любой уголок не только Сочи, но и всего Черноморского побережья. В непосредственной близости от отеля находится набережная реки с одноименным названием города. В пешей доступности крупные торгово-развлекательные центры, где, помимо всего прочего, работают рестораны, в которых можно попробовать блюда кухни различных стран. Отель «Приморский» предлагает размещение в комфортабельных номерах различных категорий, каждый из которых оснащен всем необходимым, чтобы сделать Ваше пребывание в городе-курорте еще приятнее. Для владельцев автомобилей на территории гостиницы имеется охраняемая парковка. Недалеко от отеля расположен семейный гипермаркет «Магнит» и центральная химчистка.</p>
                <h5>Номерной фонд</h5>
               <h6>Двухместный номер (Стандарт )</h6>
               <p> В номере: двуспальная кровать (или две односпальные кровати), прикроватные тумбочки, шкаф, диван (или кресло), трюмо, зеркало, стул, телевизор, телефон, холодильник, кондиционер (в некоторых номерах). В ванной: душ (или ванна), туалет, раковина.</p>
                <h6>Номер Студио (Семейный)</h6>
                <p> В номере зона спальни и зона гостиной. В зоне спальни: двуспальная кровать, прикроватные тумбочки, шкаф, трюмо, зеркало, стул. В зоне гостиной: диван, кресло, журнальный столик, телевизор, телефон, холодильник, кондиционер. В ванной: ванна, туалет, раковина, набор полотенец, средства личной гигиены.</p>
                <h6>Номер Студио</h6>
                <p> В номере зона спальни и зона гостиной. В зоне спальни: двуспальная кровать, прикроватные тумбочки, шкаф, трюмо, зеркало, стул. В зоне гостиной: диван, кресло, журнальный столик, телевизор, телефон, холодильник, кондиционер. В ванной: ванна, туалет, раковина, фен, набор полотенец, средства личной гигиены, тапочки.</p>
                <h6>Номер Люкс</h6>
               <p>В номере спальня и гостиная. В спальне: двуспальная кровать, прикроватные тумбочки, шкаф, телефон. В гостиной: диван, пуфик, журнальный столик, стол-трюмо, стул, телевизор, холодильник, кондиционер. В ванной: ванна, туалет, раковина, фен, набор полотенец, средства личной гигиены, тапочки.</p>

                <h5>Завтрак входит в стоимость номера.</h5>
                    <h5> Расчетный час 12.00.</h5>
                        <h5> Проживание детей до 12 лет  — бесплатно.</h5>
                            <h5> Стоимость дополнительного места - 500 рублей.</h5>
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                Услуги в гостинице
            </a>
        </div>
        <div id="collapseTwo" class="accordion-body collapse">
            <div class="accordion-inner">
                <i class="icon-pencil">Доступ в интернет </i>
                Трансфер
                Кондиционер
                Фен
                Автостоянка / Парковка
                Room-service
                Глажка белья
                Кафе-бар
                Прокат велосипедов
                Экскурсии
                Wi-Fi
            </div>
        </div>
    </div>
</div>
<div id="contentbottomshadow"></div>

<div id="footer">
    <div id="footerimage"></div>
    <p id="footertext" align="center">
        Copyright © 2014 EPAM Studio<br /> All Rights Reserved
    </p>
</div>

</body>
</html>
