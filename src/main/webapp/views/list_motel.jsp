<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<article>

    <c:forEach items="${listMotel}" var="motel">
        <div class="motel-border">
            <div class="picture">
                <img src="/resources/imgs/${motel.getUrl()}">
            </div>
            <div class="one-motel">
                <a href="/motel/detail?id=${motel.getId()}" class="description">${motel.getDesCate()}</a>
                <div class="information-motel">
                    <a class="location">${motel.getLocationId()}</a> <br>
                    <a class="area">Diện tích: ${motel.getArea()}m <sup>2</sup> </a> <br>
                    <a class="desc">Miêu tả: ${motel.getDescription()}</a>
                </div>
            </div>
            <div class="money-button">
                <a class="price"><fmt:formatNumber value="${motel.getPrice()}" type="currency"
                                                   currencySymbol="VNĐ"/></a>
                <br><br>
                <button class="click">Thuê nhà</button>
                <br><br>
                <a class="status">Trạng thái: ${motel.getStatus()}</a>
            </div>
        </div>
    </c:forEach>

</article>
