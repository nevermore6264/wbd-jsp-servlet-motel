<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.codegym.motel.service.CategoryService" %>
<%@ page import="com.codegym.motel.service.impl.CategoryServiceImpl" %>
<%@ page import="com.codegym.motel.service.impl.ServiceConfig" %>
<%@ page import="com.codegym.motel.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/14/2018
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Đăng phòng cho thuê!</h1>
<%
    CategoryService categoryService = ServiceConfig.getCategoryService();
    request.setAttribute("categoies", categoryService.getAll());
%>
<form id="contactform" name="contact" method="post" action="/motel/post_motel" onsubmit="return checkPostMotel()"
>
    <p class="note"><span class="req">* Các trường bắt buộc phải nhập </span></p>
    <fieldset class="main-content">
        <legend>Phần yêu cầu nhập thông tin:</legend>
        <div class="row">
            <label>Loại nhà trọ<span class="req">*</span></label>
            <select class="txt" name="category" id="category">
                <option>-- Lựa chọn --</option>
                <c:forEach items="${categoies}" var="category">
                    <option value="${category.getId()}">${category.getName()}</option>
                </c:forEach>
            </select>
            <a id="category_error"></a>
        </div>

        <div class="row">
            <label>Diện tích<span class="req">*</span></label>
            <input type="text" id="area" class="txt" placeholder="Mời bạn nhập diện tích của phòng"
                   name="area">
            <span>m<sup>2</sup></span>
            <a id="area_error"></a>
        </div>

        <div class="row">
            <label>Giá phòng<span class="req">*</span></label>
            <input type="text" id="price" class="txt" placeholder="Mời bạn nhập giá của phòng" name="price">
            <span>VNĐ</span>
            <a id="price_error"></a>
        </div>

        <div class="row">
            <label>Quận<span class="req">*</span></label>
            <select class="txt" name="county" id="county" onchange="checkCounty()">
                <option>-- Lựa chọn quận --</option>
                <option value="Quận Nam Từ Liêm">Quận Nam Từ Liêm</option>
                <option value="Quận Thanh Xuân">Quận Thanh Xuân</option>
                <option value="Quận Cầu Giấy">Quận Cầu Giấy</option>
            </select>
            <a id="county_error"></a>
        </div>

        <div class="row">
            <label>Phường<span class="req">*</span></label>
            <select class="txt" name="ward" id="ward">
                <option>-- Chọn phường --</option>
            </select>
            <a id="ward_error"></a>
        </div>

        <div class="row">
            <label>Đường<span class="req">*</span></label>
            <input type="text" id="street" name="street" placeholder="Mời bạn nhập tên đường" class="txt">
            <a id="street_error"></a>
        </div>

        <div class="row">
            <label>Số nhà<span class="req">*</span></label>
            <input type="text" id="number" name="number" placeholder="Mời bạn nhập số nhà" class="txt">
            <a id="number_error"></a>
        </div>
    </fieldset>
    <fieldset class="additional-content">
        <legend>Nội dung bổ sung:</legend>
        <div class="row">
            <label>Tiền điện</label>
            <input type="text" id="price_electric" class="txt" placeholder="Mời bạn nhập giá điện"
                   name="price_electric">
            <span>VNĐ</span>
            <a id="price_electric_error"></a>
        </div>

        <div class="row">
            <label>Tiền Internet</label>
            <input type="text" id="price_internet" class="txt" placeholder="Mời bạn nhập tiền internet/tháng"
                   name="price_internet">
            <span>VNĐ</span>
            <a id="price_internet_error"></a>
        </div>

        <div class="row">
            <label>Tiền nước</label>
            <input type="text" id="price_water" class="txt" name="price_water"
                   placeholder="Mời bạn nhập giá nước/tháng">
            <span>VNĐ</span>
            <a id="price_water_error"></a>
        </div>

        <div class="row">
            <label>Ảnh 1</label>
            <input type="file" id="picture" class="txt" placeholder="Mời bạn chọn ảnh" name="picture">
            <a id="picture_error"></a>
        </div>

        <div class="row">
            <label>Ảnh 2</label>
            <input type="file" id="picture1" class="txt" placeholder="Mời bạn chọn ảnh" name="picture">
            <a id="picture_error1"></a>
        </div>

        <div class="row">
            <label>Ảnh 3</label>
            <input type="file" id="picture2" class="txt" placeholder="Mời bạn chọn ảnh" name="picture">
            <a id="picture_error2"></a>
        </div>

        <div class="row">
            <label>Miêu tả</label>
            <textarea name="description" placeholder="Nhập tiêu đề hiển thị cho bài đăng của bạn" id="description"
                      class="txtarea"></textarea>
        </div>
    </fieldset>
    <div class="center">
        <input type="submit" id="submitbtn" name="submitbtn" value="Đăng thông tin">
    </div>
</form>

<script>
    function checkCounty() {
        var county = document.getElementById("county");
        var ward = document.getElementById("ward");
        if (county.value == "Quận Nam Từ Liêm") {
            ward.innerHTML = "<option value='Phường Trung Văn'>Phường Trung Văn</option>" +
                "<option value='Phường Đại Mỗ'>Phường Đại Mỗ</option>" +
                "<option value='Phường Tây Mỗ'>Phường Tây Mỗ</option>" +
                "<option value='Phường Mễ Trì'>Phường Mễ Trì</optionva>" +
                "<option value='Phường Phú Đô'>Phường Phú Đô</option>" +
                "<option value='Phường Mỹ Đình 1'>Phường Mỹ Đình 1</option>" +
                "<option value='Phường Mỹ Đình 2'>Phường Mỹ Đình 2</option>" +
                "<option value='Phường Cầu Diễn'>Phường Cầu Diễn</option>" +
                "<option value='Phường Xuân Phương 1'>Phường Xuân Phương 1</option>" +
                "<option value='Phường Xuân Phương 2'>Phường Xuân Phương 2</option>";
        } else if (county.value == "Quận Thanh Xuân") {
            ward.innerHTML = "<option value='Phường Khương Đình'>Phường Khương Đình</option>" +
                "<option value='Phường Hạ Đình'>Phường Hạ Đình</option>" +
                "<option value='Phường Khương Mai'>Phường Khương Mai</option>" +
                "<option value='Phường Khương Trung'>Phường Khương Trung</option>" +
                "<option value='Phường Kim Giang'>Phường Kim Giang</option>" +
                "<option value='Phường Nhân Chính'>Phường Nhân Chính</option>" +
                "<option value='Phường Phương Liệt'>Phường Phương Liệt</option>" +
                "<option value='Phường Thanh Xuân Bắc'>Phường Thanh Xuân Bắc</option>" +
                "<option value='Phường Thanh Xuân Nam'>Phường Thanh Xuân Nam</option>" +
                "<option value='Phường Thanh Xuân Trung'>Phường Thanh Xuân Trung</option>" +
                "<option value='Phường Thượng Đình'>Phường Thượng Đình</option>";
        } else if (county.value == "Quận Cầu Giấy") {
            ward.innerHTML = "<option value='Phường Dịch Vọng'>Phường Dịch Vọng</option>" +
                "<option value='Phường  Dịch Vọng Hậu'>Phường Dịch Vọng Hậu</option>" +
                "<option value='Phường Mai Dịch'>Phường Mai Dịch</option>" +
                "<option value='Phường Nghĩa Đô'>Phường Nghĩa Đô</option>" +
                "<option value='Phường Nghĩa Tân'>Phường Nghĩa Tân</option>" +
                "<option value='Phường Quan Hoa'>Phường Quan Hoa</option>" +
                "<option value='Phường Trung Hòa'>Phường Trung Hòa</option>" +
                "<option value='Phường Yên Hòa'>Phường Yên Hòa</option>";
        } else {
            ward.innerHTML = "<option>-- Chọn Phường --</option>";
        }
    }
</script>
