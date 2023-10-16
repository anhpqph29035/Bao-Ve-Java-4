<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Chi Tiết Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Thêm Chi Tiết Sản Phẩm</h2>
</div>
<body class="container col-md-6">
<form action="/addSPCT" method="post" onsubmit="alert('Thêm thành công !!)">
    <input type="hidden" class="form-control"  name="idCTSP">
    <div class="mb-3">
        <label class="form-label">Ảnh</label>
        <input class="form-control" type="file" name="anhCTSP" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Sản Phẩm</label>
        <select name="sanPham.idSP" class="form-select" aria-label="Default select example">
            <c:forEach items="${listSP}" var="u">
                <option value="${u.idSP}">${u.tenSP}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">NSX</label>
        <select name="nsxCTSP.idNSX"  class="form-select" aria-label="Default select example">
            <c:forEach items="${listNSX}" var="u">
                <option value="${u.idNSX}">${u.tenNSX}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Màu Sắc</label>
        <select name="mauSac.idMS"  class="form-select" aria-label="Default select example">
            <c:forEach items="${listMS}" var="u">
                <option value="${u.idMS}">${u.tenMS}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Dòng SP</label>
        <select name="dongCTSP.idDSP" class="form-select" aria-label="Default select example">
            <c:forEach items="${listDong}" var="u">
                <option value="${u.idDSP}">${u.tenDSP}</option>
            </c:forEach>
        </select>
    </div>
    <div  class="mb-3">
        <label class="form-label">Năm Bảo Hành</label>
        <input type="text" class="form-control" name="namBH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Mô Tả</label>
        <input type="text" class="form-control" name="moTa" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Số Lượng Tồn</label>
        <input type="text" class="form-control" name="soLuongTon" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Giá Nhập</label>
        <input type="text" class="form-control" name="giaNhap" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Giá Bán</label>
        <input type="text" class="form-control" name="giaBan" required>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn thêm không ?')">Add</button>
        <a href="sanphamct" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
