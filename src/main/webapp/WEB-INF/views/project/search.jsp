<%--
  Created by IntelliJ IDEA.
  User: SH
  Date: 2022-06-05
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Bare - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="${path}/resources/assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${path}/resources/css/styles.css" rel="stylesheet" />
</head>
<body>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page content-->
<div class="container">
    <div class="text-center mt-5">
        <h1>Today's discount</h1>
        <div class="card" style="width: 20rem; float: left">
            <img src="https://w.namu.la/s/9876430c78913a5506d242c6b2af387dde5259ff92bf2863b7970f8eb774ffaae98b1cb37b26028e6ce678794889984900277e877b125120ad7ba65d2a1e68560dd8e3f04cc1a6792191839b22dba83f6948951e6af00bce12dd97a1f16f06c6" style="height:20rem; width: 20rem " class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Steam</h5>
                <p class="card-text">오늘의 할인 보기</p>
                <a href="/project/steam" class="btn btn-primary">정보 보기</a>
            </div>
        </div>
        <div class="card" style="width: 20rem; float: right">
            <img src="https://image.ajunews.com/content/image/2022/01/21/20220121135836317288.jpg" class="card-img-top" style="height:20rem; width: 20rem " alt="...">
            <div class="card-body">
                <h5 class="card-title">MSS</h5>
                <p class="card-text">오늘의 할인 보기</p>
                <a href="/project/mss" class="btn btn-primary">정보 보기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
