<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<body class="container col-md-6">
<div  class="text-center mt-3 mb-3">
    <h2>Sửa Sản Phẩm</h2>
</div>
<div>
    <form action="/updateSP" method="post" onsubmit="alert('Sửa thành công !!')">
        <input type="hidden" class="form-control"  value="${listUD.idSP}" name="idSP">
        <div class="mb-3">
            <label class="form-label">Ảnh</label>
            <input class="form-control" type="file" value="${listUD.anhSP}" name="anhSP" required>
        </div>
        <div  class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" value="${listUD.maSP}" name="maSP" required>
        </div>
        <div  class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" value="${listUD.tenSP}" name="tenSP" required>
        </div>
        <div class="mt-3 text-center">
            <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn sửa không ?')">Submit</button>
            <a href="product" class="btn btn-success">Back</a>
        </div>
    </form>
</div>
</body>
</html>
