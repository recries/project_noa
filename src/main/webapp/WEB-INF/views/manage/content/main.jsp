<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>projectNoA</title>
</head>

<%@ include file="../../../includeFiles/include_source.jsp"  %>
<link type="text/css" rel="stylesheet" href="../../../../source/css/manage.css">

<body>
<%@ include file="../../includeJsp/manageHeader.jsp" %>
<body>
<main class="main">

    <section class="section">
        <h2 class="section-title">회원 관리</h2>
        <table class="table">
            <thead class="table-head">
            <tr class="table-row">
                <th class="table-cell">아이디</th>
                <th class="table-cell">이름</th>
                <th class="table-cell">이메일</th>
                <th class="table-cell">등록일</th>
            </tr>
            </thead>
            <tbody class="table-body">
                <c:forEach items="${adminList}" var="row" varStatus="status">
                    <tr class="table-row">
                        <td class="table-cell">${row.admin_id}</td>
                        <td class="table-cell">${row.admin_name}</td>
                        <td class="table-cell">${row.admin_email}</td>
                        <td class="table-cell">${row.w_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<footer>
    <!-- Footer 내용 -->
</footer>


</body>
</html>
