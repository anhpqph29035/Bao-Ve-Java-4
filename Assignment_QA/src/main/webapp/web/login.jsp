<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Design by foolishdeveloper.com -->
    <title>Login</title>
    <link rel="icon" type="image/x-icon" href="../img/loogo.png">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../logincss/login.css">
</head>
<body>
<div class="background">
    <div class="shape"></div>
    <div class="shape"></div>
</div>
   <c:if test="${not empty loii}">
       <script>
           alert("${loii}");
       </script>
   </c:if>

<form action="/loginto" method="post">
    <h3>Login Here</h3>
    <label>Username</label>
    <input type="text" placeholder="Email or Phone" id="maKH" name="maKH">

    <label>Password</label>
    <input type="password" placeholder="Password" id="passKH" name="passKH">

    <button type="submit">Log In</button>
</form>
</body>
</html>
