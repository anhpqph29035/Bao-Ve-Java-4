<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="../../img/loogo.png">
</head>
<div  class="text-center mt-3 mb-3">
    <h2>Thêm Sản Phẩm</h2>
</div>
<body class="container col-md-6">
    <form action="/addSP" method="post" onsubmit="alert('Thêm thành công !!')">
        <input type="hidden" class="form-control"  name="idSP">
        <div class="mb-3">
            <label class="form-label">Ảnh</label>
            <input class="form-control" type="file" name="anhSP" required>
        </div>
        <div  class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control"  name="maSP" required>
        </div>
       <div  class="mb-3">
           <label class="form-label">Tên</label>
           <input type="text" class="form-control" name="tenSP" required>
       </div>
        <div class="mt-3 text-center">
        <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có muốn thêm không ?')">Add</button>
        <a href="product" class="btn btn-success">Back</a>
        </div>
    </form>
</body>
</html>
