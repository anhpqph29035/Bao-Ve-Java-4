<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Chi Tiết Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Sửa Chi Tiết Sản Phẩm</h2>
</div>
<body class="container col-md-6">
<form action="/updateSPCT" method="post" onsubmit="alert('Sửa thành công !!)">
    <input type="hidden" class="form-control" value="${listUD.idCTSP}"  name="idCTSP">
    <div class="mb-3">
        <label class="form-label">Ảnh</label>
        <input class="form-control" type="file" name="anhCTSP" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Sản Phẩm</label>
        <select name="sanPham.idSP" class="form-select" aria-label="Default select example">
            <c:forEach items="${listSP}" var="u">
                <option value="${u.idSP}" <c:if test="${u.idSP==listUD.sanPham.idSP}">selected</c:if>>${u.tenSP}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">NSX</label>
        <select name="nsxCTSP.idNSX"  class="form-select" aria-label="Default select example">
            <c:forEach items="${listNSX}" var="u">
                <option value="${u.idNSX}" <c:if test="${u.idNSX==listUD.nsxCTSP.idNSX}">selected</c:if>>${u.tenNSX}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Màu Sắc</label>
        <select name="mauSac.idMS"  class="form-select" aria-label="Default select example">
            <c:forEach items="${listMS}" var="u">
                <option value="${u.idMS}" <c:if test="${u.idMS==listUD.mauSac.idMS}">selected</c:if>>${u.tenMS}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Dòng SP</label>
        <select name="dongCTSP.idDSP" class="form-select" aria-label="Default select example">
            <c:forEach items="${listDong}" var="u">
                <option value="${u.idDSP}" <c:if test="${u.idDSP==listUD.dongCTSP.idDSP}">selected</c:if>>${u.tenDSP}</option>
            </c:forEach>
        </select>
    </div>
    <div  class="mb-3">
        <label class="form-label">Năm Bảo Hành</label>
        <input type="text" class="form-control" name="namBH" value="${listUD.namBH}" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Mô Tả</label>
        <input type="text" class="form-control" name="moTa" value="${listUD.moTa}" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Số Lượng Tồn</label>
        <input type="text" class="form-control" name="soLuongTon" value="${listUD.soLuongTon}" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Giá Nhập</label>
        <input type="text" class="form-control" name="giaNhap" value="${listUD.giaNhap}" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Giá Bán</label>
        <input type="text" class="form-control" name="giaBan" value="${listUD.giaBan}" required>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn sửa không ?')">Sửa</button>
        <a href="sanphamct" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
