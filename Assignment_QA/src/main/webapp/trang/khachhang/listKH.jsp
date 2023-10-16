<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container-fluid">
<div class="text-center mt-3 mb-3">
    <h2>Quản Lý Khách Hàng</h2>
</div>
<div class="text-start mb-3 mt-4">
    <a href="home" class="btn btn-success">Home</a>
    <a href="chucvu" class="btn btn-success">Chức Vụ</a>
    <a href="cuahang" class="btn btn-success">Cửa Hàng</a>
    <a href="nhanvien" class="btn btn-success">Nhân Viên</a>
    <a href="showAddKH" class="btn btn-success">Thêm</a>
</div>
<table class="table table-bordered table-sm text-center">
    <thead class="table-dark">
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Tên Đệm</td>
        <td>Họ</td>
        <td>Ngày Sinh</td>
        <td>SĐT</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>Mật khẩu</td>
        <td>Thao tác</td>
    </tr>
    </thead>
    <tbody class="align-middle">
    <c:forEach items="${listKH}" var="u">
        <tr>
            <td>${u.idKH}</td>
            <td>${u.maKH}</td>
            <td>${u.tenKH}</td>
            <td>${u.tenDemKH}</td>
            <td>${u.hoKH}</td>
            <td>${u.ngaySinhKH}</td>
            <td>${u.sdtKH}</td>
            <td>${u.diaChiKH}</td>
            <td>${u.thanhPhoKH}</td>
            <td>${u.quocGiaKH}</td>
            <td>${u.matKhauKH}</td>
            <td>
                <a href="/removeKH?id=${u.idKH}" class="btn btn-danger"  onclick="return confirm('Bạn có muốn xóa không ?')" >Xóa</a>
                <a href="/detailKH?id=${u.idKH}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>