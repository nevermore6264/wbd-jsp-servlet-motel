<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2018
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
    <div class="trapezoid">
        <a class="search-text">Sản phẩm tương tự</a>
    </div>
    <div class="ui-content">
        <div class="box-info">
            <img src="/resources/imgs/anh1.jpg">
            <a href="#">Nhà trọ bình dân giá từ 500k</a>
        </div>

        <div class="box-info">
            <img src="/resources/imgs/anh2.jpg">
            <a href="#">Chung cư mini cao cấp 3000k</a>
        </div>

        <div class="box-info">
            <img src="/resources/imgs/anh3.jpg">
            <a href="#">Nhà trọ sinh viên từ 1200k</a>
        </div>

    </div>

</aside>
<article>
    <div class="tooltip"><h1 class="motel-title">Nhà nghỉ bình dân ở ngõ 100 Gốc Đề</h1>
        <div class="tooltiptext">
            <a class="username">Tên chủ nhà: ${user.getName()}</a><br><br>
            <a class="phone">Số điện thoại: ${user.getPhone()}</a><br><br>
            <a class="location">Địa chỉ: Số nhà ${location.getApartmentNumber()} / Đường ${location.getStreet()} /
                Phường ${location.getDistrict()} / ${location.getCounty()}</a> <br><br>
            <a class="area">Diện tích: ${motelDetails.getArea()} m<sup>2</sup> </a> <br><br>
            <a class="price_electric">Tiền điện: ${motelDetails.getElectricPrice()} VNĐ </a><br><br>
            <a class="price_water">Tiền nước: ${motelDetails.getWaterPrice()} VNĐ</a><br><br>
            <a class="price_internet">Tiền mạng: ${motelDetails.getInternetPrice()} VNĐ </a> <br><br>
            <a class="desc_motel">Chi tiết nhà: ${descreption.getDescription()}</a>
            <div class="row">
                <% int count = 1; %>
                <c:forEach items="${pictures}" var="url">
                    <div class="column">
                        <img class="demo cursor" src="/resources/imgs/${url.getUrl()}"
                             style="width:100px;height: 100px"
                             onclick="currentSlide(<%= count++ %>)">
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
    <br> <br>
    <div class="container-slide">
        <c:forEach items="${pictures}" var="url">
            <div class="mySlides">
                <img src="/resources/imgs/${url.getUrl()}" style="width:350px;height: 600px">
            </div>
        </c:forEach>
    </div>

    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("demo");
            var captionText = document.getElementById("caption");
            if (n > slides.length) {
                slideIndex = 1
            }
            if (n < 1) {
                slideIndex = slides.length
            }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            captionText.innerHTML = dots[slideIndex - 1].alt;
        }
    </script>

</article>
