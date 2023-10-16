<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Màu Sắc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container">
<div  class="text-center mt-3 mb-3">
    <h2>Quản Lý Màu Sắc</h2>
</div>
<div class="text-start mb-3 mt-4">
    <a href="home" class="btn btn-success">Home</a>
    <a href="product" class="btn btn-success">Sản Phẩm</a>
    <a href="nsx" class="btn btn-success">NSX</a>
    <a href="dongSP" class="btn btn-success">Dòng SP</a>
    <a href="sanphamct" class="btn btn-success">Chi Tiết Sản Phẩm</a>
    <a href="showAddMS" class="btn btn-success">Thêm</a>
</div>
<table class="table table-bordered table-sm container text-center">
    <thead class="table-dark">
    <tr>
        <td>ID</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Thao tác</td>
    </tr>
    </thead>
    <tbody class="align-middle">
    <c:forEach items="${listMS}" var="u">
        <tr>
            <td>${u.idMS}</td>
            <td>${u.maMS}</td>
            <td>${u.tenMS}</td>
            <td>
                <a href="/removeMS?id=${u.idMS}" class="btn btn-danger"  onclick="return confirm('Bạn có muốn xóa không ?')" >Xóa</a>
                <a href="/detailMS?id=${u.idMS}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>