<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>

    <c:if test="${sessionScope.user==null}">
    <div id="sub-menu">
        <a href="/login.jsp">Đăng nhập</a>
        <a href="/login.jsp">Đăng ký</a>
    </div>
    </c:if>

    <c:if test="${sessionScope.user!=null}">
        <div id="sub-menu">
            <a class="login" href="../views/update_user.jsp">${sessionScope.user}</a> |
            <a class="logout" href="/motel/logout">Đăng xuất</a>
        </div>
    </c:if>

</header>

