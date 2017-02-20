<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>存货</title>
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
                <li class="list-group-item active">存货</li>
                <li class="list-group-item"><a href="/pick">取货</a></li>
                <li class="list-group-item"><a href="/query">查询</a></li>
                <li class="list-group-item"><a href="/scrap">报废</a></li>
                <li class="list-group-item"><a href="/staff">用户管理</a></li>
            </ul>
        </div>
        <div class="center_saveForm">
            <div class="saveForm">
                <form role="form" action="/save" method="post" class="form-horizontal">
                    <br><br>
                    <div class="form-group">
                        <lable for="goodsNum" class="col-sm-4 control-label">货物编号</lable>
                        <div class="col-sm-8">
                            <input type="text" name="_id" id="goodsNum" class="form-control"
                                   placeholder="20位内有效数字">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsPlace" class="col-sm-4 control-label">货物存放位置</lable>
                        <div class="col-sm-8">
                            <input type="text" name="position" id="goodsPlace" class="form-control"
                                   placeholder="位置编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsName" class="col-sm-4 control-label">货物名称</lable>
                        <div class="col-sm-8">
                            <input type="text" name="goodsname" id="goodsName" class="form-control"
                                   placeholder="有效名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsTime" class="col-sm-4 control-label">货物有效期</lable>
                        <div class="col-sm-8">
                            <input type="text" name="usefullife" id="goodsTime" class="form-control"
                                   placeholder="有效天数">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsPrice" class="col-sm-4 control-label">货物价格</lable>
                        <div class="col-sm-8">
                            <input type="text" name="price" id="goodsPrice" class="form-control"
                                   placeholder="xx.xx">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsNumber" class="col-sm-4 control-label">货物数量</lable>
                        <div class="col-sm-8">
                            <input type="text" name="count" id="goodsNumber" class="form-control"
                                   placeholder="有效数量">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsType" class="col-sm-4 control-label">货物类别</lable>
                        <div class="col-sm-8">
                            <input type="text" name="goodsclass" id="goodsType" class="form-control"
                                   placeholder="有效类别">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="goodsDate" class="col-sm-4 control-label">货物生产日期</lable>
                        <div class="col-sm-8">
                            <input type="text" name="dateproduced" id="goodsDate" class="form-control"
                                   placeholder="XXXX-XX-XX">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-success"
                                    ${islogin?'':'disabled="disabled"'} ">
                                ${islogin?'提交':'请登录'}
                            </button>
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