<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>노아</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="../../../source/js/js_functions.js"></script>
</head>
<link type="text/css" rel="stylesheet" href="../../../source/css/main.css">

<body>
<div class="login-container">
    <form class="login-form" method="post" action="/login/loginAuth" enctype="application/json">
        <h2>노아에 오신 것을 환영합니다</h2>
        <div class="input-group">
            <label for="admin_id">아이디</label>
            <input type="text" id="admin_id" name="admin_id" required>
            <p class="idTag red_highlight hidden"></p>
        </div>
        <div class="input-group">
            <label for="admin_password">패스워드</label>
            <input type="password" id="admin_password" name="admin_password" required>
        </div>
        <button class="greenBtn" type="submit">로그인</button>
        <p>아직 계정이 없으신가요? <a href="javascript:go_post('/login/createUser')">회원가입</a></p>
        <p style="cursor: pointer;" onclick="$('#forgotModal').removeClass('hidden')">아이디/패스워드 찾기</p>
    </form>
</div>

<div class="modal hidden" id="forgotModal">
    <div class="modal-content">
        <span class="modalClose">&times;</span>
        <h2 class="forgotModalTitle"><span class="active idTitle">아이디</span>/<span class="passTitle">패스워드</span> 찾기</h2>
        <p>아래 정보를 입력해주세요.</p>
        <form id="forgotPasswordForm">
            <div class="input-group modal-input-group">
                <input type="text" class="hidden" id="forgot_id" placeholder="아이디를 입력해주세요.">
                <input type="email" id="forgot_email" placeholder="이메일을 입력해주세요.">
            </div>
            <button type="button" class="greenBtn" id="userCheck">찾기</button>
        </form>
    </div>
    <div class="background"></div>
</div>

<script>
    $('#admin_id').on('keyup', function(){
        if($(this).val().length < 6 ){
            $('.idTag').text("아이디를 6글자 이상 입력해주세요.").removeClass('hidden');
        }
        if($(this).val().length >= 6 ){
            $('.idTag').addClass('hidden');
        }
    });

    $(document).ready(function() {

        $('.login-form').submit(function(){
            if($('#admin_id').val() === '' || $('#admin_id').val().length < 6){
                alert('아이디를 입력해주세요.');
                $('#admin_id').focus();
                return false;
            }
            if($('#admin_password').val() === '' || $('#admin_password').val().length < 8){
                alert('패스워드를 입력해주세요.');
                $('#admin_password').val('').focus();
                return false;
            }
        });
    });
    $('.idTitle').on('click',function(){
        $(this).addClass('active');
        $('#forgot_id').addClass('hidden');
        $('.passTitle').removeClass('active');

    });
    $('.passTitle').on('click',function(){
        $(this).addClass('active');
        $('#forgot_id').removeClass('hidden');
        $('.idTitle').removeClass('active');

    });
    $('#userCheck').on('click',function (){
        $.ajax({
            url: '/login/findAdmin',
            contentType:'utf-8',
            data : {
            },
            dataType : 'json',
            success : function(e){
            }
        });
    });
    $('.login-form').submit(function(event) {
        event.preventDefault();

        var adminData = {
            admin_id: $('#admin_id').val(),
            admin_password: $('#admin_password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/login/loginAuth',
            contentType: 'application/json',
            data: JSON.stringify(adminData),
            success: function(data) {
                go_post("/manage/content/main");
            },
            error: function(xhr, status, error) {
                console.log("error: " + error);
                go_post("/caresite");
            }
        });
    });

</script>
<script src="../../../source/js/common.js"></script>
<%@ include file="../../includeFiles/include-body.jsp" %>
</body>
</html>
