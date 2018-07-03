<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside>
    <div class="trapezoid">
        <a class="search-text">Tìm kiếm theo khoảng giá</a>
    </div>
    <div class="ui-content">
        <form method="get" action="/motel/search">
            <div class="rangeslider">
                Từ <input name="price-min" type="text" id="min" placeholder="Nhập..." value="0">
                đến <input name="price-max" type="text" id="max" placeholder="Nhập..." value="0"> VNĐ
            </div>

            <hr>

            <select class="select" name="aba">
                <option value="Đang cho thuê">Nhà sẵn sàng cho thuê</option>
                <option value="Không Đang cho thuê">Nhà không sẵn sàng cho thuê</option>
            </select>
            <input type="submit" class="submitbtn" value="Tìm kiếm">
        </form>
    </div>


</aside>