<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div class="text-center mt-3 mb-3">
    <h2>Thêm Nhân Viên</h2>
</div>
<body class="container col-md-6">
<form action="/addNV" method="post" onsubmit="alert('Thêm thành công !!')">
    <input type="hidden" class="form-control" name="idNV">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="maNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="tenNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" name="tenDemNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Họ</label>
        <input type="text" class="form-control" name="hoNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Giới Tính</label>
        <input type="radio" name="gtNV" value="Nam" checked> Nam
        <input type="radio" name="gtNV" value="Nữ"> Nữ
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" name="ngaySinhNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Điạ Chỉ</label>
        <input type="text" class="form-control" name="diaChiNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">SDT</label>
        <input type="text" class="form-control" name="sdtNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control" name="matKhauNV" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Cửa Hàng</label>
        <select name="cuaHang.idCH" class="form-select" aria-label="Default select example">
            <c:forEach items="${listCH}" var="u">
                <option value="${u.idCH}">${u.tenCH}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Chức Vụ</label>
        <select name="chucVu.idCV" class="form-select" aria-label="Default select example">
            <c:forEach items="${listCV}" var="u">
                <option value="${u.idCV}">${u.tenCV}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Trạng Thái</label>
        <select name="ttNV" class="form-select" aria-label="Default select example">
            <option value=1>Đi làm</option>
            <option value=0>Nghỉ làm</option>
        </select>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn thêm không ?')">Add</button>
        <a href="nhanvien" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
