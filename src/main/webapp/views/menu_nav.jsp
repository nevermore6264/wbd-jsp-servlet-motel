<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <img class="logo-airbnb" src="/resources/imgs/logo.png">
    <ul class="menu">
        <li><a href="/index.jsp">Trang chủ</a></li>
        <li><a href="/index.jsp">Cho thuê phòng</a>
            <ul class="submenu">
                <li><a href="../post_motel.jsp">Đăng phòng</a></li>
                <li><a href="/index.jsp">Lịch sử đăng phòng</a></li>
                <li><a href="/index.jsp">Xem nhận xét</a></li>
            </ul>
        </li>
        <li class="active"><a href="/index.jsp">Thuê phòng</a>
            <ul class="submenu">
                <li><a href="/motel/all_motel">Tìm kiếm phòng</a></li>
                <li><a href="/index.jsp">Lịch sử thuê phòng</a></li>
                <li><a href="/index.jsp">Đánh giá phòng</a></li>
            </ul>
        </li>
        <li><a href="/index.jsp">Hồ sơ cá nhân</a>
            <ul class="submenu">
                <li><a href="../views/update_user.jsp">Thông tin cá nhân</a></li>
                <li><a href="/index.jsp">Đổi mật khẩu</a></li>
            </ul>
        </li>
    </ul>
</nav>

