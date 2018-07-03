<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="slider">
    <img src="/resources/imgs/motel1.jpg" title="Top nhà hot tháng 5"/>
    <img src="/resources/imgs/motel2.jpg" title="Nhà trọ khu vực Mỹ Đình - Hà Nội"/>
    <img src="/resources/imgs/motel3.jpg" title="Nhà trọ giá rẻ"/>
    <img src="/resources/imgs/motel4.jpg" title="Nhà trọ cao cấp"/>
    <button type="button" onclick="getPrevImage()" class="btn" id="btnPrev">&lt;</button>
    <button type="button" onclick="getNextImage()" class="btn" id="btnNext">&gt;</button>
    <h1 id="titleSlider"></h1>
</div>

<script type="text/javascript" src="/resources/js/slidershow_index.js"></script>
<script>
    initSlider();
</script>


