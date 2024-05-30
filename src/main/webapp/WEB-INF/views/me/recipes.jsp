<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>projectNoA</title>
</head>

<%@ include file="../../includeFiles/include_source.jsp"  %>
<link type="text/css" rel="stylesheet" href="../../source/css/main.css">

<body>

<%@ include file="../includeJsp/userHeader.jsp" %>
<div class="selection-container">
    <h1>어떤 음료를 만들어볼까요?</h1>
    <div class="drink-options">
        <div class="drink-card" onclick="selectRecipe('coffee')">
            <img src="../../../source/img/coffee.png" alt="커피 아이콘">
            <p>커피</p>
        </div>
        <div class="drink-card" onclick="selectRecipe('smoothie')">
            <img src="../../../source/img/smoothie.png" alt="스무디 아이콘">
            <p>스무디</p>
        </div>
        <div class="drink-card" onclick="selectRecipe('tea')">
            <img src="../../../source/img/tea.png" alt="차 아이콘">
            <p>차</p>
        </div>
        <!-- 다른 음료 아이콘 및 텍스트 추가 -->
    </div>
</div>

</body>
</html>
