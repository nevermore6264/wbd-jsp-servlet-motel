<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2018
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký/ Đăng nhập</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="/resources/css/login.css">
</head>

<body>

<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Đăng ký</a></li>
        <li class="tab"><a href="#login">Đăng nhập</a></li>
    </ul>

    <div class="tab-content">
        <div id="signup">
            <h1>Đăng ký tài khoản</h1>

            <form action="/motel/signup" method="post" onsubmit="return checkRegister()">
                <div class="field-wrap">
                    <label>
                        Tên của bạn<span class="req">*</span>
                    </label>
                    <input name="fullname" id="fullname" type="text" required/>
                </div>

                <div class="field-wrap">
                    <label>
                        Số điện thoại<span class="req">*</span>
                    </label>
                    <input type="text" name="phone" id="phone" required/>
                    <a id="phone_error"></a>
                </div>

                <div class="field-wrap">
                    <label>
                        Nhập mật khẩu<span class="req">*</span>
                    </label>
                    <input type="password" id="password" name="password" required/>
                </div>

                <div class="field-wrap">
                    <label>
                        Nhập lại mật khẩu<span class="req">*</span>
                    </label>
                    <input type="password" id="re_password" name="re_password" required/>
                    <a id="re_password_error"></a>
                </div>

                <button type="submit" class="button button-block"/>
                Đăng ký</button>
                <h4 style="color: white">${message}</h4>

            </form>

        </div>

        <div id="login">
            <h1>Chào mừng bạn</h1>

            <form action="/motel/login" method="post" onsubmit="return checkLogin()">

                <div class="field-wrap">
                    <label>
                        Số điện thoại<span class="req">*</span>
                    </label>
                    <input type="text" name="my_phone" id="my_phone"/>
                    <a id="my_phone_error"></a>
                </div>

                <div class="field-wrap">
                    <label>
                        Nhập mật khẩu<span class="req">*</span>
                    </label>
                    <input type="password" name="my_password" id="my_password"/>
                    <a id="my_password_error"></a>
                </div>
                <input type="checkbox" id="remember" name="remember" value="save">
                <a class="remember"> Nhớ mật khẩu</a>
                <p class="forgot"><a href="#">Quên mật khẩu?</a></p>
                <button type="submit" class="button button-block"/>
                Đăng nhập</button>
            </form>

        </div>

    </div><!-- tab-content -->

</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="/resources/js/menu_nav.js" language="JavaScript"></script>
<script src="/resources/js/validate.js" language="JavaScript"></script>
</body>
</html>
