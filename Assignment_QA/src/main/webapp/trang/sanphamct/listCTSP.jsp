<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sản Phẩm Chi Tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container-fluid">
<div  class="text-center mt-3 mb-3">
    <h2>Chi Tiết Sản Phẩm</h2>
</div>

<div class="text-start mb-3 mt-4">
    <a href="home" class="btn btn-success">Home</a>
    <a href="product" class="btn btn-success">Sản Phẩm</a>
    <a href="nsx" class="btn btn-success">NSX</a>
    <a href="colors" class="btn btn-success">Màu Sắc</a>
    <a href="dongSP" class="btn btn-success">Dòng SP</a>
    <a href="showAddSPCT" class="btn btn-success">Thêm</a>
</div>

<table class="table table-bordered table-sm container-fluid text-center">
    <thead class="table-dark">
    <tr>
        <td>ID</td>
        <td>Ảnh</td>
        <td>Sản Phẩm</td>
        <td>NSX</td>
        <td>Màu Sắc</td>
        <td>Dòng SP</td>
        <td>Năm Bảo Hành</td>
        <td>Mô Tả</td>
        <td>Số Lượng Tồn</td>
        <td>Giá Nhập</td>
        <td>Giá Bán</td>
        <td>Thao Tác</td>
    </tr>
    </thead>
    <tbody class="align-middle">
    <c:forEach items="${listSPCT}" var="u">
        <tr>
            <td>${u.idCTSP}</td>
            <td><img src="img/sanpham/${u.anhCTSP}" width="200"></td>
            <td>${u.sanPham.tenSP}</td>
            <td>${u.nsxCTSP.tenNSX}</td>
            <td>${u.mauSac.tenMS}</td>
            <td>${u.dongCTSP.tenDSP}</td>
            <td>${u.namBH}</td>
            <td>${u.moTa}</td>
            <td>${u.soLuongTon}</td>
            <td>${u.giaNhap}</td>
            <td>${u.giaBan}</td>
            <td>
                <a href="/removeSPCT?id=${u.idCTSP}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')" >Xóa</a>
                <a href="/detailSPCT?id=${u.idCTSP}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>