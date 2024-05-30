<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>projectNoA</title>
</head>
<style type="text/css">
    .card-text{
        white-space: break-spaces;
    }

</style>
<%@ include file="../../../includeFiles/include_source.jsp"  %>
<link type="text/css" rel="stylesheet" href="../../../../source/css/manage.css">

<body>
<%@ include file="../../includeJsp/manageHeader.jsp" %>
<body>
<main class="container mt-5">
    <section>
        <form id="deleteCategoryForm" method="post" target="hiddenframe">
            <h2 class="mb-4">카테고리</h2>
            <div class="row">
                <c:forEach items="${categoryList}" var="row" varStatus="status">
                    <div class="col-lg-3 col-md-4 mb-4">
                        <div class="card h-100">
                            <img src="https://via.placeholder.com/150" class="card-img-top" alt="이미지"
                                 data-bs-toggle="modal" data-bs-target="#detailModal"
                                 data-category-name="${row.category_name}" data-category-content="${row.category_content}">
                            <div class="card-body">
                                <div class="form-check">
                                    <label class="form-check-label" for="category_idx${row.category_idx}">${row.category_name}</label>
                                    <input type="checkbox" class="form-check-input" id="category_idx${row.category_idx}" name="category_idx" value="${row.category_idx}">
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="mt-3">
                <button class="btn btn-danger" id="deleteCategoryBtn" type="button">삭제</button>
                <button class="btn btn-primary" id="addCategoryBtn" data-bs-toggle="modal" data-bs-target="#addCategoryModal" type="button">추가</button>
            </div>
        </form>
    </section>
</main>

<div class="modal fade" id="detailModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <form action="/common/uploadFile" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="upload_type" value="category" />
        <input type="hidden" name="upload_allow_ext">
        <input type="file" name="file" id="file_logo" ext_filter="jpg,jpeg,png,gif" value="" style="display:none;">
        <div class="modal-content">
            <div class="preview_cont imageView">
                <span class="img_wrap">
                    <img src="" alt="선택된 이미지" class="preview">
                </span>
                <label for="" class="btn btn-primary logo_upload_btn">이미지 업로드</label>
                <input type="hidden" name="category_image" value="">
                <p class="cm_highlight logo_text">※ 대용량 이미지는 업로드가 불가합니다. <br>(세로 150px 이하, 이미지 파일, 1M이하)</p>
            </div>
            <div class="modal-header">
                <input type="text" class="modal-title fs-5" id="categoryNameInput" value="">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <textarea class="modal-body" id="categoryContentTextarea" maxlength="200"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                <button type="button" id="categoryUpdate" class="btn btn-primary">저장</button>
            </div>
        </div>
        </form>
    </div>
</div>

<div class="modal fade" id="addCategoryModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <input type="text" class="modal-title fs-5" id="newCategoryNameInput" value="" placeholder="카테고리 명">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <textarea class="modal-body" id="newCategoryContentTextarea" maxlength="200"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                <button type="button" id="categoryInsert" class="btn btn-primary">저장</button>
            </div>
        </div>
    </div>
</div>

<%--<div class="modal hidden" id="addCategoryModal">
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
</div>--%>


<footer>
    <!-- Footer 내용 -->
</footer>

<script>

    $('.logo_upload_btn').click(function() {
        $('#file_logo').click();
    });

    $('#detailModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget); // 모달을 열게 한 버튼
        var categoryName = button.data('category-name'); // data-category-name 속성 값
        var categoryContent = button.data('category-content'); // data-category-content 속성 값
        var modal = $(this);
        modal.find('#categoryNameInput').val(categoryName);
        modal.find('#categoryContentTextarea').val(categoryContent);
    });

    $('#addCategoryModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget); // 모달을 열게 한 버튼
        var modal = $(this);
        modal.find('#newCategoryNameInput').val('');
        modal.find('#newCategoryContentTextarea').val('');
    });


    $('#categoryInsert').on('click', function(){
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

