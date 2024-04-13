<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>노아</title>
</head>

<%@ include file="../../../includeFiles/include_source.jsp"  %>
<link type="text/css" rel="stylesheet" href="../../../../source/css/manage.css">

<body>
<%@ include file="../../includeJsp/manageHeader.jsp" %>
<body>
<main class="main">
    <section class="section">
        <h2 class="section-title">레시피 카테고리</h2>
        <table class="table">
            <thead class="table-head">
            <tr class="table-row">
                <th class="table-cell">선택</th>
                <th class="table-cell">이름</th>
                <th class="table-cell">종류</th>
                <th class="table-cell">설명</th>
                <th class="table-cell">등록일</th>
            </tr>
            </thead>
            <tbody class="table-body">
            <c:forEach items="${sourceList}" var="row" varStatus="status">
                <tr class="table-row">
                    <td class="table-cell"><input type="checkbox"></td>
                    <td class="table-cell">${row.category_name}</td>
                    <td class="table-cell">${row.category_content}</td>
                    <td class="table-cell">admin@example.com</td>
                    <td class="table-cell">2023-01-01</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="btn_warp">
            <button class="btn cm_btn01" type="button">삭제</button>
            <button class="btn cm_btn02" type="button">추가</button>
        </div>
    </section>
</main>

<footer>
    <!-- Footer 내용 -->
</footer>


</body>
</html>
