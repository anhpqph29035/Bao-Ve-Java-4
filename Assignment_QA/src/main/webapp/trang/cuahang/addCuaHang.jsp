<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Cửa Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Thêm Cửa Hàng</h2>
</div>
<body class="container col-md-6">
<form action="/addCH" method="post" onsubmit="alert('Thêm thành công !!')">
    <input type="hidden" class="form-control"  name="idCH">
    <div  class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control"  name="maCH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="tenCH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" name="diaChiCH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Thành phố</label>
        <input type="text" class="form-control" name="thanhPhoCH" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" name="quocGiaCH" required>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn thêm không ?')">Add</button>
        <a href="cuahang" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
