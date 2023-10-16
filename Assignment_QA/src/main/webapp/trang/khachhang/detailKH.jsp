<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Sửa Khách Hàng</h2>
</div>
<body class="container col-md-6">
<form action="/updateKH" method="post" onsubmit="alert('Sửa thành công !!')">
    <input type="hidden" class="form-control" value="${listUD.idKH}" name="idKH">
    <div  class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" value="${listUD.maKH}" name="maKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" value="${listUD.tenKH}" name="tenKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" value="${listUD.tenDemKH}" name="tenDemKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Họ</label>
        <input type="text" class="form-control" value="${listUD.hoKH}" name="hoKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" value="${listUD.ngaySinhKH}" name="ngaySinhKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Số điện thoại</label>
        <input type="text" class="form-control" value="${listUD.sdtKH}" name="sdtKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" value="${listUD.diaChiKH}" name="diaChiKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Thành Phố</label>
        <input type="text" class="form-control"  value="${listUD.thanhPhoKH}" name="thanhPhoKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Quốc Gia</label>
        <input type="text" class="form-control"  value="${listUD.quocGiaKH}" name="quocGiaKH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control"  value="${listUD.matKhauKH}" name="matKhauKH" required>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn sửa không ?')">Add</button>
        <a href="khachhang" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
