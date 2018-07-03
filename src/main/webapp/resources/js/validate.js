function checkRegister() {
    var password = document.getElementById("password");
    var re_password = document.getElementById("re_password");
    if (password.value == re_password.value) {
        document.getElementById("re_password_error").innerHTML = "";
        re_password.style.border = "";
    } else {
        document.getElementById("re_password_error").innerHTML = "Không trùng khớp mật khẩu";
        re_password.style.border = "1px solid red";
        re_password.focus();
        return false;
    }

    var phone = document.getElementById("phone");
    if (isNaN(phone.value) == true) {
        document.getElementById("phone_error").innerHTML = "Trường bạn nhập vào phải là số";
        phone.style.border = "1px solid red";
        phone.focus();
        return false;
    } else {
        document.getElementById("phone_error").innerHTML = "";
        phone.style.border = "";
    }
}

function checkLogin() {
    var my_phone = document.getElementById('my_phone');
    if (my_phone.value == "") {
        document.getElementById("my_phone_error").innerHTML = "Trường không được để trống";
        my_phone.style.border = "1px solid red";
        my_phone.focus();
        return false;
    } else if (isNaN(my_phone.value) == true) {
        document.getElementById("my_phone_error").innerHTML = "Trường bạn nhập vào phải là số";
        my_phone.style.border = "1px solid red";
        my_phone.focus();
        return false;
    } else if (my_phone.value.length > 11 || my_phone.value.length < 10) {
        document.getElementById("my_phone_error").innerHTML = "Trường bạn nhập vào phải là số 10-11 ký tự ";
        my_phone.style.border = "1px solid red";
        my_phone.focus();
        return false;
    } else {
        document.getElementById("my_phone_error").innerHTML = "";
        my_phone.style.border = "";
    }

    var my_password = document.getElementById('my_password');
    if (my_password.value == "") {
        document.getElementById("my_password_error").innerHTML = "Trường không được để trống";
        my_password.style.border = "1px solid red";
        my_password.focus();
        return false;
    } else if (my_password.value.length < 3) {
        document.getElementById("my_password_error").innerHTML = "Chiều dài chuỗi >= 3";
        my_password.style.border = "1px solid red";
        my_password.focus();
        return false;
    } else {
        document.getElementById("my_password_error").innerHTML = "";
        my_password.style.border = "";
    }
}

function checkPostMotel() {
    var category = document.getElementById('category');
    if (category.value == "-- Lựa chọn --") {
        document.getElementById("category_error").innerHTML = "Mời bạn chọn loại nhà";
        category.style.border = "1px solid red";
        category.focus();
        return false;
    } else {
        document.getElementById("category_error").innerHTML = "";
        category.style.border = "";
    }

    var area = document.getElementById('area');
    if (area.value == "") {
        document.getElementById("area_error").innerHTML = "Trường không được để trống";
        area.style.border = "1px solid red";
        area.focus();
        return false;
    } else if (isNaN(area.value) == true) {
        document.getElementById("area_error").innerHTML = "Trường bạn nhập vào phải là số";
        area.style.border = "1px solid red";
        area.focus();
        return false;
    } else {
        document.getElementById("area_error").innerHTML = "";
        area.style.border = "";
    }

    var price = document.getElementById('price');
    if (price.value == "") {
        document.getElementById("price_error").innerHTML = "Trường không được để trống";
        price.style.border = "1px solid red";
        price.focus();
        return false;
    } else if (isNaN(price.value) == true) {
        document.getElementById("price_error").innerHTML = "Trường bạn nhập vào phải là số";
        price.style.border = "1px solid red";
        price.focus();
        return false;
    } else {
        document.getElementById("price_error").innerHTML = "";
        price.style.border = "";
    }

    var county = document.getElementById('county');
    if (county.value == "-- Lựa chọn quận --") {
        document.getElementById("county_error").innerHTML = "Mời bạn chọn quận";
        county.style.border = "1px solid red";
        county.focus();
        return false;
    } else {
        document.getElementById("county_error").innerHTML = "";
        county.style.border = "";
    }

    var ward = document.getElementById('ward');
    if (ward.value == "-- Chọn phường --") {
        document.getElementById("ward_error").innerHTML = "Mời bạn chọn phường";
        ward.style.border = "1px solid red";
        ward.focus();
        return false;
    } else {
        document.getElementById("ward_error").innerHTML = "";
        ward.style.border = "";
    }

    var street = document.getElementById('street');
    if (street.value == "") {
        document.getElementById("street_error").innerHTML = "Trường không được để trống";
        street.style.border = "1px solid red";
        street.focus();
        return false;
    } else {
        document.getElementById("street_error").innerHTML = "";
        street.style.border = "";
    }

    var number = document.getElementById('number');
    if (number.value == "") {
        document.getElementById("number_error").innerHTML = "Trường không được để trống";
        number.style.border = "1px solid red";
        number.focus();
        return false;
    } else if (isNaN(number.value) == true) {
        document.getElementById("number_error").innerHTML = "Trường bạn nhập vào phải là số";
        number.style.border = "1px solid red";
        number.focus();
        return false;
    } else {
        document.getElementById("number_error").innerHTML = "";
        number.style.border = "";
    }


    var price_electric = document.getElementById('price_electric');
    var price_internet = document.getElementById('price_internet');
    var price_water = document.getElementById('price_water');
    if (isNaN(price_electric.value) == true) {
        document.getElementById("price_electric_error").innerHTML = "Trường bạn nhập vào phải là số";
        price_electric.style.border = "1px solid red";
        price_electric.focus();
        return false;
    } else {
        document.getElementById("price_electric_error").innerHTML = "";
        price_electric.style.border = "";
    }

    if (isNaN(price_internet.value) == true) {
        document.getElementById("price_internet_error").innerHTML = "Trường bạn nhập vào phải là số";
        price_internet.style.border = "1px solid red";
        price_internet.focus();
        return false;
    } else {
        document.getElementById("price_internet_error").innerHTML = "";
        price_internet.style.border = "";
    }

    if (isNaN(price_water.value) == true) {
        document.getElementById("price_water_error").innerHTML = "Trường bạn nhập vào phải là số";
        price_water.style.border = "1px solid red";
        price_water.focus();
        return false;
    } else {
        document.getElementById("price_water_error").innerHTML = "";
        price_water.style.border = "";
    }

}
