<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 08/05/2018
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link href="/resources/css/header.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/css/slidershow_index.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/menu_nav.css" rel="stylesheet" type="text/css"/>
    <script src="/resources/js/menu_nav.js" type="text/javascript"></script>
    <script src="/resources/js/jquery-1.11.3.min.js"></script>
    <link href="/resources/css/show_list_motel.css" rel="stylesheet">
    <link href="/resources/css/footer.css" rel="stylesheet">
    <style>
        article {
            width: 95% !important;
            margin-left: 50px;
            margin-top: 50px;
        }
    </style>

</head>
<body>

<jsp:include page="/views/header.jsp"></jsp:include>
<jsp:include page="/views/menu_nav.jsp"></jsp:include>
<jsp:include page="/views/slideshow.jsp"></jsp:include>
<jsp:include page="/views/show_list_motel.jsp"></jsp:include>
<jsp:include page="/views/footer.jsp"></jsp:include>

</body>
</html>
