<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Bare - Project</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="${path}/resources/assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${path}/resources/css/styles.css" rel="stylesheet" />
</head>
<body>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/project/search">Project</a>
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
        <h1>Steam page</h1>
        <div class="row mt-3 dtoList">
            <div class="col">

                <div class="card">
                    <div class="card-header">
                        Steam Sale
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">
                            <Sale></Sale>
                        </h5>

                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Title</th>
                                <th scope="col">Original Price</th>
                                <th scope="col">Sale Percent</th>
                                <th scope="col">Sale price</th>
                                <th scope="col">Date</th>
                            </tr>
                            </thead>
                            <c:forEach items="${dtoList}" var="board">
                                <tbody>
                                <tr>
                                    <th scope="row">${board.sno}</th>
                                    <td>
                                        <img src="${board.image}">
                                        <a href='${board.link}' class="dtoLink">
                                            <c:out value="${board.title}"/> </a>
                                    </td>
                                    <td>${board.original_price}</td>
                                    <td>${board.sale_percent}</td>
                                    <td>${board.sale_price}</td>
                                    <td>${board.regdate}</td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                        <ul class="pagination">
                            <c:if test="${pageMaker.prev}">
                            <li class="page-item">
                                <a class="page-link" href="${pageMaker.start-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            </c:if>
                            <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                            <li class="page-item <c:out value="${pageMaker.page == num ? 'active' :'' }"/> ">
                                <a class="page-link" href="${num}">${num}</a></li>
                            </c:forEach>
                            <c:if test="${pageMaker.next}">
                            <li class="page-item">
                                <a class="page-link" href="${pageMaker.end + 1 }" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            </c:if>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<form class="actionForm" action="/project/steam" method="get">
    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
</form>
<script>
    const linkDiv = document.querySelector(".pagination")
    const actionForm = document.querySelector(".actionForm")



    linkDiv.addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()

        const target = e.target

        if (target.getAttribute("class") !== 'page-link') {
            return
        }

        const pageNum = target.getAttribute("href")
        actionForm.querySelector("input[name='page']").value = pageNum
        actionForm.setAttribute("action", "/project/steam")
        actionForm.submit()

    }, false)


</script>
</body>
</html>
