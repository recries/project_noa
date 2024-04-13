<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>노아</title>
</head>

<%@ include file="../../../includeFiles/include_source.jsp"  %>
<link type="text/css" rel="stylesheet" href="../../../../source/css/manage.css">
<link type="text/css" rel="stylesheet" href="../../../../source/css/main.css">

<body>
<%@ include file="../../includeJsp/manageHeader.jsp" %>
<body>
<main class="main">
    <section class="section">
        <form id="deleteCategoryForm" method="post" target="hiddenframe">
        <h2 class="section-title">레시피 카테고리</h2>
        <table class="table">
            <thead class="table-head">
            <tr class="table-row">
                <th class="table-cell allClick">선택</th>
                <th class="table-cell">이름</th>
                <th class="table-cell">종류</th>
                <th class="table-cell">설명</th>
                <th class="table-cell">등록일</th>
            </tr>
            </thead>
            <tbody class="table-body">
                <c:forEach items="${categoryList}" var="row" varStatus="status">
                    <tr class="table-row">
                        <td class="table-cell"><input type="checkbox" class="checkBox" name="category_idx" value="${row.category_idx}"></td>
                        <td class="table-cell">${row.category_name}</td>
                        <td class="table-cell">${row.category_content}</td>
                        <td class="table-cell">admin@example.com</td>
                        <td class="table-cell">2023-01-01</td>
                    </tr>
                </c:forEach>
                <c:if test="${categoryList[0] == null}">
                    <tr class="table-row">
                        <td class="table-cell" colspan="100" style="text-align: center;">카테고리를 추가해주세요.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
        <div class="btn_warp">
            <button class="btn cm_btn01 deleteCategoryBtn" type="button">삭제</button>
            <button class="btn cm_btn02 addCategoryBtn" type="button">추가</button>
        </div>
        </form>
    </section>
</main>
<div class="modal hidden" id="addCategoryModal">
    <div class="modal-content">
        <span class="modalClose">&times;</span>
        <h2 class="forgotModalTitle">
            <span class="active">카테고리 추가</span></h2>
        <p>아래 정보를 입력해주세요.</p>
        <form id="categoryForm" method="post" target="hiddenframe">
            <div class="input-group modal-input-group">
                <label for="category_name">카테고리</label>
                <input type="text" id="category_name" maxlength="20" name="category_name" placeholder="커피" required>
                <label for="category_content">설명</label>
                <textarea id="category_content" name="category_content" style="width:91%; height: 150px" placeholder="색이 어둡고 쓴맛이 있으며 약산성인 커피는 주로 카페인 함량으로 인해 인간에게 자극 효과를 준다." ></textarea>
            </div>
            <button type="button" class="greenBtn" id="categorySave">저장하기</button>
        </form>
    </div>
    <div class="background"></div>
</div>

<footer>
    <!-- Footer 내용 -->
</footer>

<script>
    $('.addCategoryBtn').on('click', function(){
        $('#addCategoryModal').removeClass('hidden');
    });

    $('#categorySave').on('click', function(){
        if($('#category_name').val() === ''){
            alert('카테고리 이름을 작성해주세요.');
            return false;
        }
        if($('#category_content').val() === ''){
            alert('카테고리 설명을 작성해주세요.');
            return false;
        }
        var category = [{
            category_name: $('#category_name').val(),
            category_content: $('#category_content').val(),
        }];

        $.ajax({
            type: 'POST',
            url: '/manage/recipes/insertCategory',
            contentType: 'application/json',
            data: JSON.stringify({ category: category }),
            dataType: 'json',
            success: function(data) {
                alert('저장되었습니다.');
                location.reload();
            },
            error: function(xhr, status, error) {
                console.log("error: " + error);
            }
        });
    });
    $('.deleteCategoryBtn').on('click', function(){
        var categoryChecked = [];
        $('.checkBox').each(function(){
            if($(this).prop('checked')) {
                categoryChecked.push($(this).val());
            }
        });
        if(categoryChecked.length === 0) {
            alert('1개 이상 선택해주세요');
        } else {
            var deleteForm = $('#deleteCategoryForm');
            deleteForm.attr('action','/manage/recipes/deleteCategory');
            deleteForm.submit();
            location.reload();
        }
    });

</script>
<script src="../../../../source/js/common.js"></script>
<%@ include file="../../../includeFiles/include-body.jsp" %>
</body>
</html>

