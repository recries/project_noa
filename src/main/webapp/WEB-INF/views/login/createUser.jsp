<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<%@ include file="../../includeFiles/include_source.jsp" %>
<link type="text/css" rel="stylesheet" href="../../../source/css/main.css">

<body>
<form class="register-container" action="/login/insertAdminInfo" method="post" id="createAdmin">
    <div class="title">
        <h2>회원 가입</h2>
        <button class="agreeBtn" id="privacyBtn" type="button">개인정보 동의</button>
    </div>
    <div class="register-form">
        <section class="personal-info">
            <h3>개인 정보</h3>
            <div class="input-group">
                <label for="admin_name">이름:</label>
                <input type="text" id="admin_name" name="admin_name" required>
            </div>
            <div class="input-group">
                <label for="gender">성별:</label>
                <select id="gender" name="gender" required>
                    <option value="male">남성</option>
                    <option value="female">여성</option>
                    <option value="other">기타</option>
                </select>
            </div>
            <div class="input-group">
                <label for="admin_nickname">별명:</label>
                <input type="text" id="admin_nickname" name="admin_nickname" required>
            </div>
            <div class="input-group">
                <label for="admin_hp">휴대폰 번호:</label>
                <input type="tel" id="admin_hp" name="admin_hp" required>
            </div>
        </section>
        <section class="account-info">
            <h3>계정 정보</h3>
            <div class="input-group">
                <label for="admin_id">아이디:</label>
                <input type="text" id="admin_id" name="admin_id" required>
                <p class="red_highlight idTag hidden">이미 사용중인 아이디입니다.</p>
                <p class="green_highlight idTag hidden">사용가능한 아이디입니다.</p>
                <p class="red_highlight idTag hidden">5자 이상으로 작성해주세요.</p>
            </div>
            <div class="input-group">
                <label for="admin_email">이메일:</label>
                <input type="email" id="admin_email" name="admin_email" required>
            </div>
            <div class="input-group">
                <label for="admin_password">비밀번호:</label>
                <input type="password" id="admin_password" name="admin_password" required>
                <p class="red_highlight pwTag hidden">비밀번호는 8자 이상으로 작성해주세요.</p>
                <p class="green_highlight pwTag hidden">비밀번호가 같습니다.</p>
                <p class="red_highlight pwTag hidden">비밀번호를 동일하게 작성해주세요.</p>
            </div>
            <div class="input-group">
                <label for="confirm_admin_password">비밀번호 확인:</label>
                <input type="password" id="confirm_admin_password" name="confirm_admin_password" required>
            </div>
        </section>
    </div>

    <button class="greenBtn submitBtn" type="button">가입하기</button>
    <p>이미 계정이 있으신가요? <a href="javascript:go_post('/caresite')">로그인</a></p>

    <section id="privacyModal" class="modal hidden">
        <div class="modal-content">
            <span class="modalClose">&times;</span>
            <h1>개인정보 수집 및 이용 동의</h1>
            <p>
                [노아]은 다음과 같은 개인정보를 수집 및 이용합니다.
            </p>
            <table>
                <tr>
                    <th>수집 항목</th>
                    <td>이름, 이메일 주소, 전화번호, 주소</td>
                </tr>
                <tr>
                    <th>수집 목적</th>
                    <td>회원가입, 서비스 이용, 마케팅 및 광고</td>
                </tr>
                <tr>
                    <th>보유 및 이용 기간</th>
                    <td>회원 탈퇴 시까지</td>
                </tr>
            </table>
            <p>
                [노아]은 원칙적으로 이용자의 동의 없이 개인정보를 제3자에게 제공하지 않습니다. 다만, 다음의 경우에는 예외로 합니다.
            </p>
            <ul>
                <li>법률의 특별한 규정</li>
                <li>이용자의 동의</li>
            </ul>
            <p>
                이용자는 언제든지 자신의 개인정보를 열람, 정정, 삭제할 수 있습니다. 개인정보 열람, 정정, 삭제 및 처리 정지를 위해서는 [노아]의 개인정보 관리책임자에게 서면, 전화 또는 이메일로 연락하시면 안내받을 수 있습니다.
            </p>
            <p>
                [노아]은 개인정보의 안전을 위해 다음과 같은 조치를 취하고 있습니다.
            </p>
            <ul>
                <li>개인정보의 암호화</li>
                <li>개인정보의 보안서버 관리</li>
                <li>개인정보 취급 직원의 최소화 및 교육</li>
            </ul>
            <p>
                이용자는 개인정보에 대한 불만이 있으신 경우 [노아]의 개인정보 관리책임자에게 문의하시기 바랍니다.
            </p>
            <p>
                <strong>개인정보 관리책임자</strong>
                <br>
            <table>
                <tr>
                    <th>이름</th>
                    <td>[김덕훈]</td>
                </tr>
                <tr>
                    <th>직위</th>
                    <td>[연구원]</td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>[010-6515-2353]</td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>[recries12@gmail.com]</td>
                </tr>
            </table>
            <p>
                <input type="radio" id="agree" name="agree" value="yes">
                <label for="agree">동의함</label>
                <input type="radio" id="disagree" name="agree" value="no">
                <label for="disagree">동의하지 않음</label>
            <p>
                동의하지 않을 경우 서비스 이용이 제한될 수 있습니다.
            </p>
        </div>
        <div class="background"></div>
    </section>
</form>

<script>
    $(document).ready(function() {

    });
    $('#privacyBtn').on('click', function (){
       $('#privacyModal').removeClass('hidden');
    });
    $('[name="agree"]').on('change',function (){
        const agree = $('input[name=agree]:checked').val();
        if(agree === 'yes'){
            $('#privacyBtn').addClass('greenBtn').removeClass('agreeBtn');
            $('#privacyModal').addClass('hidden');
        }else{
            $('#privacyBtn').addClass('agreeBtn').removeClass('greenBtn');
        }
    });
    $('#admin_id').on('keyup', function() {
        if($(this).val().length > 4){
            $.ajax({
                type: 'GET',
                url: '/ajax/idCheck',
                contentType: 'application/json',
                data: { "admin_id": $('#admin_id').val() }, // 입력한 어드민 ID 값을 JSON 형태로 전송
                dataType: 'json',
                success: function(data) {
                        if(data.useId){
                            $('.idTag:eq(1)').removeClass('hidden');
                            $('.idTag:eq(0)').addClass('hidden');
                        }else{
                            $('.idTag:eq(0)').removeClass('hidden');
                            $('.idTag:eq(1)').addClass('hidden');
                        }
                        $('.idTag:eq(2)').addClass('hidden');
                },
                error: function(xhr, status, error) {
                    console.log("error: " + error);
                }
            });
        }else{
            $('.idTag:eq(0)').addClass('hidden');
            $('.idTag:eq(1)').addClass('hidden');
            $('.idTag:eq(2)').removeClass('hidden');
        }
    });
    var pw_ok = false;
    $('.submitBtn').on('click',function(){
       if($('#admin_name').val() === ''){
            alert('성함을 작성해주세요.');
            $('#admin_name').focus();
            return false;
        }
        if($('#admin_nickname').val() === ''){
            alert('별명을 작성해주세요.');
            $('#admin_nickname').focus();
            return false;
        }
        if($('#admin_hp').val() === ''){
            alert('휴대폰 번호를 작성해주세요.');
            $('#admin_hp').focus();
            return false;
        }
        if($('#admin_id').val() === ''){
            alert('사용하실 아이디를 작성해주세요.');
            $('#admin_id').focus();
            return false;
        }
        if($('#admin_email').val() === ''){
            alert('이메일을 작성해주세요.');
            $('#admin_email').focus();
            return false;
        }
        if($('#admin_password').val() === ''){
            alert('사용자 비밀번호를 작성해주세요.');
            $('#admin_password').focus();
            return false;
        }
        if(pw_ok === false){
            alert('비밀번호를 동일하게 입력해주세요.');
            $('#confirm_admin_password').val('').focus();
            return false;
        }
        if($('#agree').prop("checked") === false){
           alert('개인정보 동의를 해주세요.');
           return false;
        }
        $('#createAdmin').submit();
    });
    $('#admin_password, #confirm_admin_password').on('keyup',function (){
       if($('#admin_password').val().length < 8){
           $('.pwTag:eq(0)').removeClass('hidden');
           $('.pwTag:not(:eq(0))').addClass('hidden');
           pw_ok = false;
       }else{
           if($('#admin_password').val() === $('#confirm_admin_password').val()){
               $('.pwTag:eq(1)').removeClass('hidden');
               $('.pwTag:not(:eq(1))').addClass('hidden');
               pw_ok = true;
           }else{
               $('.pwTag:eq(2)').removeClass('hidden');
               $('.pwTag:not(:eq(2))').addClass('hidden');
               pw_ok = false;
           }
       }
    });
</script>
<script src="../../../source/js/common.js"></script>
<%@ include file="../../includeFiles/include-body.jsp" %>
</body>
</html>
