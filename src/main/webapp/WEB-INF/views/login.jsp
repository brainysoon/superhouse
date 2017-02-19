<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <meta charset="utf-8">
    <title>
        欢迎登录
    </title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!---CSS-->
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">  <!--响应式布局框架-->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico" media="screen"/>

    <script src="/resources/js/jquery-1.8.2.min.js"></script>       <!--jquery-->
    <script type="text/javascript" src="/resources/js/jquery.form.js"></script>
    <script type="text/javascript" src="/resources/js/tooltips.js"></script>

<body>

<c:forEach items="${pageContext.request.cookies}" var="cooks">
    <c:if test="${fn:contains(cooks.name,'_id')}">
        <c:set var="_id" value="${cooks.value}"/>
    </c:if>
    <c:if test="${fn:contains(cooks.name,'password')}">
        <c:set var="password" value="${cooks.value}"/>
    </c:if>
</c:forEach>

<div class="page-container">
    <div class="main_box">
        <div class="login_box">
            <div class="login_logo">
                <label for="loginname" class="t">
                    <h2 id="loginname">
                        <font color="#269ABC">
                            欢迎登录超市仓库管理系统
                        </font>
                    </h2>
                </label>
            </div>

            <div class="login_form">
                <form action="login" id="login_form" method="post">
                    <!--邮箱-->
                    <div class="form-group">
                        <label for="_id" class="t">员工号：</label>
                        <input id="_id" value="${_id}" name="_id" type="text" class="form-control x319 in"
                               autocomplete="off">
                    </div>
                    <!--密码-->
                    <div class="form-group">
                        <label for="password" class="t">密　码：</label>
                        <input id="password" value="${password}" name="password" type="password"
                               class="password form-control x319 in">
                    </div>

                    <!--记住登录账号-->
                    <div class="form-group">
                        <label class="t"></label>
                        <label for="issave" class="m">
                            <input id="issave" type="checkbox" name="issave" checked="checked">&nbsp;记住登陆账号!</label>
                    </div>
                    <div class="form-group space">

                        <label class="t"></label>

                        <button type="submit" id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp
                        </button>
                        <input type="reset" value="&nbsp;&nbsp;&nbsp;&nbsp;重&nbsp;置&nbsp;"
                               class="btn btn-default btn-lg">
                    </div>

                    <div class="form-group">

                        <label class="t"></label>

                        <label class="error"><p style="color: red">
                            <c:out value="${code}"/>
                            <c:out value="${codestring}"/>
                        </p></label>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</head>

</html>