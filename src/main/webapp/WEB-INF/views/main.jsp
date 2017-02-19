<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页面</title>
    <!--<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css"/>-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico" media="screen"/>
    <script type="text/javascript" src="/resources/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/resources/js/messages_zh.js"></script>
</head>
<body>
<c:set var="islogin" value="${sessionScope.staff!=null}"/>
<c:if test="${islogin}">
    <c:set var="staffname" value="${sessionScope.staff.staffname}"/>
</c:if>
<div class="container">
    <div class="top">
        <div class="top_logo">

        </div>
        <div class="top_search">
            <form action="" method="post" role="form">
                <div class="input-group">
                    <input type="text" class="form-control" name="search" placeholder="search...">
                    <span class="input-group-addon glyphicon glyphicon-search" id="location">
                            <input type="submit" value="查询" class="search">
                        </span>
                </div>
            </form>
        </div>
        <div class="top_sign">
            <div class="sign_in">
                <a href="${islogin?'/':'/login'}">
                    <c:out value="${islogin?staffname:'登录'}"/> </a>
            </div>
            <div class="sign_out">
                <a href="${islogin?'/logout':'/'}">
                    <c:out value="${islogin?'注销':'欢迎'}"/>
                </a>
            </div>
        </div>
    </div>
    <div class="center">
        <div class="center_list">
            <ul class="list-group">
                <li class="list-group-item active">主页面</li>
                <li class="list-group-item">存货<span class="badge">新</span></li>
                <li class="list-group-item">取货</li>
                <li class="list-group-item">查询<span class="badge">+1</span></li>
                <li class="list-group-item">报废</li>
                <li class="list-group-item">用户管理</li>
            </ul>
        </div>
        <div class="center_cont">
            <div id="myCarousel" class="carousel side">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/resources/images/m1.png">
                    </div>
                    <div class="item">
                        <img src="/resources/images/m2.jpg">
                    </div>
                    <div class="item">
                        <img src="/resources/images/m3.png">
                    </div>
                </div>
                <a href="#myCarousel" class="carousel-control left" data-slide="prev">&lsaquo;</a>
                <a href="#myCarousel" class="carousel-control right" data-slide="next">&rsaquo;</a>
            </div>

            <a href="#myCarousel" class="carousel-control left" data-slide="prev"
               style="height: 1000px;width: 120px;">&lsaquo;</a>
            <a href="#myCarousel" class="carousel-control right" data-slide="next"
               style="height: 1000px;width: 120px;">&rsaquo;</a>
        </div>
        <div class="center_foods">
            <div class="foods"><img src="/resources/images/food2.jpg">
                <p>1</p></div>
            <div class="foods"><img src="/resources/images/food6.jpg">
                <p>2</p></div>
            <div class="foods"><img src="/resources/images/food1.jpg">
                <p>3</p></div>
            <div class="foods"><img src="/resources/images/food3.jpg">
                <p>4</p></div>
            <div class="foods"><img src="/resources/images/food4.jpg">
                <p>5</p></div>
            <div class="foods"><img src="/resources/images/food5.jpg">
                <p>6</p></div>
            <div class="foods"><img src="/resources/images/food7.jpg">
                <p>7</p></div>
            <div class="foods"><img src="/resources/images/food8.jpg">
                <p>8</p></div>
        </div>
    </div>
    <div class="bottom">
        <p class="bottom_msg">All rights received 2017 designed by 葱葱小可爱 </p>
    </div>
</div>
</body>
</html>