<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Dòng Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Thêm Dòng Sản Phẩm</h2>
</div>
<body class="container col-md-6">
<form action="/addDSP" method="post" onsubmit="alert('Thêm thành công !!')">
    <input type="hidden" class="form-control"  name="idDSP">
    <div  class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control"  name="maDSP" required>
    </div>
    <div  class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="tenDSP" required>
    </div>
    <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn thêm không ?')">Add</button>
        <a href="dongSP" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>
