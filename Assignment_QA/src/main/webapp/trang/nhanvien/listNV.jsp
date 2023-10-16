<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container-fluid">
<div class="text-center mt-3 mb-3">
    <h2>Quản Lý Nhân Viên</h2>
</div>
<div class="text-start mb-3 mt-4">
    <a href="home" class="btn btn-success">Home</a>
    <a href="chucvu" class="btn btn-success">Chức Vụ</a>
    <a href="cuahang" class="btn btn-success">Cửa Hàng</a>
    <a href="khachhang" class="btn btn-success">Khách Hàng</a>
    <a href="showAddNV" class="btn btn-success">Thêm</a>
</div>
<table class="table table-bordered table-sm text-center">
    <thead class="table-dark">
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Tên Đệm</td>
        <td>Họ</td>
        <td>Giới Tính</td>
        <td>Ngày Sinh</td>
        <td>Địa Chỉ</td>
        <td>SĐT</td>
        <td>Mật khẩu</td>
        <td>Cửa Hàng</td>
        <td>Chức Vụ</td>
        <td>Trạng Thái</td>
        <td>Thao tác</td>
    </tr>
    </thead>
    <tbody class="align-middle">

    <c:forEach items="${listNV}" var="u">
        <tr>
        <td>${u.idNV}</td>
        <td>${u.maNV}</td>
        <td>${u.tenNV}</td>
        <td>${u.tenDemNV}</td>
        <td>${u.hoNV}</td>
        <td>${u.gtNV}</td>
        <td>${u.ngaySinhNV}</td>
        <td>${u.diaChiNV}</td>
        <td>${u.sdtNV}</td>
        <td>${u.matKhauNV}</td>
        <td>${u.cuaHang.tenCH}</td>
        <td>${u.chucVu.tenCV}</td>
        <td>${u.ttNV}</td>
        <td>
            <a href="/removeNV?id=${u.idNV}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')" >Xóa</a>
            <a href="/detailNV?id=${u.idNV}" class="btn btn-primary">Detail</a>
        </td>
    </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>