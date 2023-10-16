<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cửa Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container">
<div  class="text-center mt-3 mb-3">
    <h2>Quản Lý Cửa Hàng</h2>
</div>
<div class="text-start mb-3 mt-4">
    <a href="home" class="btn btn-success">Home</a>
    <a href="chucvu" class="btn btn-success">Chức Vụ</a>
    <a href="khachhang" class="btn btn-success">Khách Hàng</a>
    <a href="nhanvien" class="btn btn-success">Nhân Viên</a>
    <a href="showAddCH" class="btn btn-success">Thêm</a>
</div>
<table class="table table-bordered table-sm container text-center">
    <thead class="table-dark">
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>Thao tác</td>
    </tr>
    </thead>
    <tbody class="align-middle">
    <c:forEach items="${listCH}" var="u">
        <tr>
            <td>${u.idCH}</td>
            <td>${u.maCH}</td>
            <td>${u.tenCH}</td>
            <td>${u.diaChiCH}</td>
            <td>${u.thanhPhoCH}</td>
            <td>${u.quocGiaCH}</td>
            <td>
                <a href="/removeCH?id=${u.idCH}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')" >Xóa</a>
                <a href="/detailCH?id=${u.idCH}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>