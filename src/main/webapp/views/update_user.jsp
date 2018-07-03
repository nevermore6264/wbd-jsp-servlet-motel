<%@ page import="com.codegym.motel.service.UserService" %>
<%@ page import="com.codegym.motel.service.impl.ServiceConfig" %>
<%@ page import="com.codegym.motel.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/19/2018
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật thông tin</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <script src="../resources/js/validate.js"></script>
</head>
<body>
<%
    UserService userService = ServiceConfig.getUserService();
    HttpSession httpSession = request.getSession();
    int id = (int) httpSession.getAttribute("userId");
    User user = userService.getUserById(id);
    request.setAttribute("userEdit", user);
%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <a href="/index.jsp" class="float-right btn btn-outline-primary mt-1">Quay lại</a>
                    <h4 class="card-title mt-2">Cập nhật thông tin khách hàng</h4>
                </header>
                <article class="card-body">
                    <form method="post" action="/motel/update">
                        <div class="form-row">

                            <div class="col form-group">
                                <label>Họ tên <a id="fullname_error"></a> </label>
                                <input type="hidden" name="id" value="${userEdit.id}">
                                <input value="${userEdit.name}" id="fullname" type="text" name="fullname"
                                       class="form-control">
                            </div> <!-- form-group end.// -->

                            <div class="col form-group">
                                <label>Mật khẩu <a id="password_error"></a></label>
                                <input value="${userEdit.password}" type="password" id="password" name="password"
                                       class="form-control"
                                       placeholder=" ">
                            </div> <!-- form-group end.// -->

                        </div> <!-- form-row end.// -->

                        <div class="form-group">
                            <label>Số điện thoại <a id="phone_error"></a></label>
                            <input value="${userEdit.phone}" type="text" id="phone" name="phone" class="form-control">
                        </div> <!-- form-group end.// -->

                        <div class="form-group">
                            <label>Email <a id="email_error"></a></label>
                            <input value="${userEdit.email}" type="text" name="email" id="email" class="form-control">
                        </div> <!-- form-group end.// -->

                        <div class="form-group">
                            <label>Chứng minh thư</label>
                            <input value="${userEdit.identification}" type="text" name="identification"
                                   class="form-control">
                        </div> <!-- form-group end.// -->

                        <div class="form-group">
                            <label>Ngày sinh</label>
                            <input value="${userEdit.birthday}" type="text" name="birthday"
                                   class="form-control">
                        </div>

                        <label>Giới tính</label>
                        <div class="form-group">
                            <label class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" ${userEdit.gender==true ? 'checked':null}
                                       name="gender" value="true">
                                <span class="form-check-label"> Nam </span>
                            </label>
                            <label class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" ${userEdit.gender==false ? 'checked':null}
                                       name="gender" value="false">
                                <span class="form-check-label"> Nữ</span>
                            </label>
                        </div> <!-- form-group end.// -->
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Quê quán</label>
                                <input value="${userEdit.hometown}" type="text" name="hometown" class="form-control">
                            </div> <!-- form-group end.// -->
                            <div class="form-group col-md-6">
                                <label>Loại tài khoản</label>
                                <select name="type_of_account" id="inputState" class="form-control">
                                    <option selected="" hidden>-- Lựa chọn --</option>
                                    <option selected="${userEdit.typeOfAccount==1 ? 'selected': null}"
                                            value="${userEdit.typeOfAccount}">Người cho thuê nhà
                                    </option>
                                    <option selected="${userEdit.typeOfAccount==2 ? 'selected': null}"
                                            value="${userEdit.typeOfAccount}">Người đi thuê nhà
                                    </option>
                                </select>
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row.// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Cập nhật</button>
                        </div> <!-- form-group// -->
                        <h4 style="color: red">${message}</h4>
                    </form>
                </article> <!-- card-body end .// -->
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->
</div>
</body>
</html>
