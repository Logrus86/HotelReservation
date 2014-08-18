<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>

    <script type='text/javascript' src='<c:url value="../static/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../static/bootstrap.min.js"/>'></script>

    <link href="../static/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Welcome page</title>
</head>
<body>
<div id="statusbar">
    <div id="statusbarcontent">
        <form  method="post" id="searchform">
            <p>
                Welcome, guest!

                <input type="submit" name="submit" value="Sign in" />
                <%--<select id="roles" name="roles" class="form-control">--%>
                    <%--<option name="roles" value="ADMIN">ADMIN</option>--%>
                    <%--<option name="roles" value="CLIENT">CLIENT</option>--%>

                <%--</select>--%>
                <input type="password" name="password"  placeholder="Password"/>
                <input type="text" name="username"  placeholder="Login"/>




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


</div>
<hr>

    <form  method="post">


        <div class="form-group">
            <label for="inputUsername" class="col-sm-2 control-label">Введите логин:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputUsername" name="inputUsername"
                       placeholder="Login">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Введите пароль:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword" name="inputPassword"
                       placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label for="inputConfirmPassword" class="col-sm-2 control-label">Подтвердите пароль:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputConfirmPassword" name="inputConfirmPassword"
                       placeholder="Password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">

                <button type="submit" class="btn"  > Confirm </button>
            </div>
        </div>
    </form>
<p>${registrationGood}</p>
<hr>

<%--<div class="carousel slide">--%>
    <%--<!-- Carousel items -->--%>

    <%--<div class="carousel-inner">--%>
        <%--<div class="active item" title="Change" align="center" ><div id="image1" align="center"></div></div>--%>

        <%--<div class="item" title="Luxe" align="center"><div id="image5" align="center"></div></div>--%>
    <%--</div>--%>
    <%--<!-- Carousel nav -->--%>
    <%--<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>--%>
    <%--<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>--%>
<%--</div>--%>



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


