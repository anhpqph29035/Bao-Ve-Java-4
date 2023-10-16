<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" type="image/x-icon" href="../img/loogo.png">
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">
    <%--linkcss--%>
    <title>Bill</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <a href="#">Sign in</a>
        </div>
    </div>
    <div class="offcanvas__nav__option">
        <a href="#"><img src="../img/icon/heart.png" alt=""></a>
        <a href="#"><img src="../img/icon/cart.png" alt=""> <span>0</span></a>
    </div>
    <div id="mobile-menu-wrap"></div>
</div>

<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>Welcome to Kaze Fashion !!</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <c:set var="x" value="${Khach}"/>
                        <c:if test="${empty x}">
                            <p><a href="/login" class="text-white">Login</a></p>
                        </c:if>
                        <c:if test="${not empty x}">
                            <p class="justify-content-end text-white">Chào mừng : ${Khach} - <a href="/logout" class="justify-content-end">${logout}</a>
                            </p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="home"><img src="../img/kaze.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="sanphamct">Product</a></li>
                                <li><a href="nhanvien">User</a></li>
                                <li><a href="showHoaDon">Bill</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="showCart"><img src="../img/icon/cart.png" alt=""> <span>0</span></a>
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->
<section class="breadcrumb-option mb-4">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Hóa Đơn Của Bạn</h4>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Section Begin -->
<section>
    <div class="container mb-3 mt-3">
        <form action="/locHoaDon" method="get">
            <label>Ngày Bắt Đầu</label>
            <input type="date" name="ngayBD"  class="me-3">
            <label>Ngày Kết Thúc</label>
            <input type="date" name="ngayKT"  class="me-3">
            <button type="submit" class="btn-success">Lọc</button>
        </form>
    </div>
    <table class="table table-bordered table-sm container text-center">
        <thead class="table-dark">
        <tr>
            <td>Mã</td>
            <td>Ngày Thanh Toán</td>
            <td>Tên Khách Hàng</td>
            <td>Tên Người Nhận</td>
            <td>Địa chỉ</td>
            <td>SĐT</td>
            <td>Thao tác</td>
        </tr>
        </thead>
        <tbody class="align-middle">
        <c:forEach items="${listHD}" var="u">
            <tr>
                <td>${u.ma}</td>
                <td>${u.ngayThanhToan}</td>
                <td>${u.khachHang.tenKH}</td>
                <td>${u.tenNguoiNhan}</td>
                <td>${u.diaChi}</td>
                <td>${u.sdt}</td>
                <td>
                    <a href="/showCTHoaDon?id=${u.id}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty tt}">
        <script>
            alert("${tt}");
        </script>
    </c:if>
</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form action="/timKiem" class="search-model-form">
            <input type="text" id="maTim" name="maTim" placeholder="Search here.....">
            <c:if test="${not empty koTim}">
                <script>
                    alert("${koTim}");
                </script>
            </c:if>
        </form>
    </div>
</div>
<!-- Search End -->

<!-- Js Plugins -->
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.nice-select.min.js"></script>
<script src="../js/jquery.nicescroll.min.js"></script>
<script src="../js/jquery.magnific-popup.min.js"></script>
<script src="../js/jquery.countdown.min.js"></script>
<script src="../js/jquery.slicknav.js"></script>
<script src="../js/mixitup.min.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/main.js"></script>
</body>
</html>