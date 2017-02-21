<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <!--<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css"/>-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/favicon.ico" media="screen"/>
    <script type="text/javascript" src="/resources/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/resources/js/validate.js"></script>
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
                <li class="list-group-item"><a href="/scrap">报废</a></li>
                <li class="list-group-item active">用户管理</li>
            </ul>
        </div>
        <div class="center_saveForm">
            <div class="saveForm">
                <form role="form" action="/staff" method="post" class="form-horizontal" style="height: 400px;"
                      id="manageForm">
                    <br><br>
                    <div class="form-group">
                        <lable for="userNum" class="col-sm-3 control-label" >员工号</lable>
                        <div class="col-sm-9">
                            <input type="text" name="_id" id="userNum" class="form-control" placeholder="8位数字">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="userName" class="col-sm-3 control-label" >员工姓名</lable>
                        <div class="col-sm-9">
                            <input type="text" name="staffname" id="userName" class="form-control" placeholder="英汉字符">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="userPsd" class="col-sm-3 control-label" >密码</lable>
                        <div class="col-sm-9">
                            <input type="text" name="password" id="userPsd" class="form-control" placeholder="6-8 位数字">
                        </div>
                    </div>

                    <div class="form-group">
                        <lable for="userBirth" class="col-sm-3 control-label" >员工生日</lable>
                        <div class="col-sm-9">
                            <input type="text" name="birthday" id="userBirth" class="form-control"  placeholder="xxxx-xx-xx">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">是否为管理</label>
                        <div class="col-sm-9">
                            <div class="radio" style="width: 50px;float: left;">
                                <label><input type="radio" name="issuper" value="1"
                                              style="width: 50px;margin-left: -35px;">是</label>
                            </div>
                            <div class="radio" style="width: 50px;float: left;">
                                <label><input type="radio" name="issuper" value="0"
                                              style="width: 50px;margin-left: -35px;" checked="checked">否</label>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success">添加</button>
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

                <form role="form" action="/stop" method="post" class="form-horizontal">
                    <table class="table" style="width: 865px;border-top: 1px solid gray;">
                        <caption>员工信息如下:</caption>
                        <thead>
                        <tr>
                            <th>员工号</th>
                            <th>员工姓名</th>
                            <th>员工生日</th>
                            <th>入职时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%! int index = 0;%>
                        <c:forEach items="${staffs}" var="staff">
                            <tr class='<%=index%2==0?"success":""%>'>
                                <td><input type="checkbox" name="_id" value="${staff._id}"/>
                                    <c:out value="${staff._id}"/></td>
                                <td><c:out value="${staff.staffname}"/></td>
                                <td><c:out value="${staff.birthday}"/></td>
                                <td><c:out value="${staff.datein}"/></td>
                            </tr>

                            <% index++;%>
                        </c:forEach>

                        </tbody>
                    </table>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success">停职</button>
                        </div>
                    </div>
                </form>

                <div class="form-group">

                    <label class="t"></label>

                    <label class="error"><p style="color: red">
                        <c:out value="${stop}"/>
                        <c:out value="${stopstring}"/>
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