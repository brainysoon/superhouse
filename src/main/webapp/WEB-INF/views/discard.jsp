<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>报废</title>
    <!--<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css"/>-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/favicon.ico" media="screen"/>
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
            <form action="/query" method="post" role="form">
                <div class="input-group">
                    <input type="text" class="form-control" name="key" placeholder="search...">
                    <span class="input-group-addon glyphicon glyphicon-search" id="location">
                            <input type="submit" value="查询" class="search">
                        </span>
                </div>
            </form>
        </div>
        <div class="top_sign">
            <div class="sign_in">
                <a href="${islogin?'/index':'/login'}">
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
                <li class="list-group-item"><a href="/index">主页面</a></li>
                <li class="list-group-item"><a href="/save">存货</a></li>
                <li class="list-group-item"><a href="/pick">取货</a></li>
                <li class="list-group-item"><a href="/query">查询</a></li>
                <li class="list-group-item active">报废</li>
                <li class="list-group-item"><a href="/staff">用户管理</a></li>
            </ul>
        </div>
        <div class="center_search">
            <form role="form" action="/scrap" method="post" class="form-horizontal">
                <table class="table">
                    <caption>查询结果如下:</caption>
                    <thead>
                    <tr>
                        <th>货物编号</th>
                        <th>货物名称</th>
                        <th>货物类别</th>
                        <th>货物价格</th>
                        <th>货物数量</th>
                        <th>货物存放位置</th>
                        <th>货物生产日期</th>
                        <th>货物有效日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%! int index = 0;%>
                    <c:forEach items="${goodses}" var="goods">
                        <tr class='<%=index%2==0?"success":""%>'>
                            <td>
                                <input type="checkbox" name="_id" value="${goods._id}/${goods.position}"/>
                                &nbsp;&nbsp;<c:out value="${goods._id}"/></td>
                            <td><c:out value="${goods.goodsname}"/></td>
                            <td><c:out value="${goods.goodsclass}"/></td>
                            <td><c:out value="${goods.price}"/></td>
                            <td><c:out value="${goods.count}"/></td>
                            <td><c:out value="${goods.position}"/></td>
                            <td><c:out value="${goods.dateproduced}"/></td>
                            <td><c:out value="${goods.usefullife}"/></td>
                        </tr>

                        <% index++;%>
                    </c:forEach>
                    </tbody>
                </table>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-7">
                        <button type="submit" class="btn btn-success">提交</button>
                    </div>
                </div>
            </form>

            <div class="form-group">

                <label class="t"></label>

                <label class="error"><p style="color: red">
                    <c:out value="${code}"/>
                    <c:out value="${codestring}"/>
                </p></label>
            </div>

            <a href="#" class="carousel-control left" data-slide="prev"
               style="height: 1000px;width: 120px;">&lsaquo;</a>
            <a href="#" class="carousel-control right" data-slide="next"
               style="height: 1000px;width: 120px;">&rsaquo;</a>
        </div>


    </div>
    <div class="bottom">
        <p class="bottom_msg">All rights received 2017 designed by 葱葱小可爱 </p>
    </div>
</div>
</body>
</html>