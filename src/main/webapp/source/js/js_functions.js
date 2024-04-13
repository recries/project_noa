//	Null Check 
function chkNull( obj ){
	if(obj.value.split(" ").join("") == "")	return true;
	return false;	
}

// input확인
function chkTextInput( obj, alertMSG ){
	if ( chkNull(obj) ){
		alert(alertMSG);
		obj.focus();
		return true;
	}
	return false; 
}

// 비밀번호 복잡도 규칙 체크
function advance_pass() {
    var pass_case = function (inputPass, num) {
        var sRegexp = [/[A-Z]/, /[a-z]/, /[0-9]/, /[\~\!\@\#\$\^\*\(\)\_\+\{\}\[\]]/];
        return sRegexp[num].test(inputPass);
    }

    var add_item_case = function (inputPass, add_item) {
        return (inputPass.indexOf(add_item) > -1) ? false : true;
    }

    var passwdCheck = function (inputPass) {
        var cnt = 0, cnt2 = 1, cnt3 = 1;
        var temp = "";

        for (i = 0; i < inputPass.length; i++) {
            temp_pass1 = inputPass.charAt(i);

            next_pass = (parseInt(temp_pass1.charCodeAt(0))) + 1;
            temp_p = inputPass.charAt(i + 1);
            temp_pass2 = (parseInt(temp_p.charCodeAt(0)));
            if (temp_pass2 == next_pass)
                cnt2 = cnt2 + 1;
            else
                cnt2 = 1;
            if (temp_pass1 == temp_p)
                cnt3 = cnt3 + 1;
            else
                cnt3 = 1;
            if (cnt2 > 3) break;
            if (cnt3 > 3) break;
        }
        if (cnt2 > 3) {
            alert("비밀번호에 순차적인 숫자를 4개이상 사용해서는 안됩니다.");
            return false;
        }
        if (cnt3 > 3) {
            alert("비밀번호에 반복된 숫자를 4개이상 사용해서는 안됩니다.");
            return false;
        }
        return true;
    }

    this.advance_pass_conf = function (inputPass, add_item) {
        // 비밀번호(패스워드) 유효성 체크 (문자, 숫자, 특수문자의 조합으로 6~16자리)
		var ObjUserPassword = inputPass;

		//if(ObjUserPassword.value != objUserPasswordRe.value)
		//{
		//  alert("입력하신 비밀번호와 비밀번호확인이 일치하지 않습니다");
		//  return false;
		//}

		var alert_msg = '비밀번호는 영문, 숫자 조합으로 10자 이상 또는 영문, 숫자, 특수기호를 사용하여 8자 이상으로 조합 할 수 있습니다.';

		if(ObjUserPassword.value.length<8) {
			alert(alert_msg);
			return false;
		}

		if (ObjUserPassword.value.length >= 8 && ObjUserPassword.value.length < 10){
			//영문, 숫자 특수기호 조합 확인
			if(!ObjUserPassword.value.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/)) {
				alert(alert_msg);
				return false;
			}
		}else{
			var chk_num = ObjUserPassword.value.search(/[0-9]/g); 
			var chk_eng = ObjUserPassword.value.search(/[a-z]/ig);

			if(chk_num < 0 || chk_eng < 0){ 
				alert(alert_msg); 
				return false;
			}
		}

		//if(ObjUserID.value.indexOf(ObjUserPassword) > -1) {
		//  alert("비밀번호에 아이디를 사용할 수 없습니다.");
		//  return false;
		//}

		var SamePass_0 = 0; //동일문자 카운트
		var SamePass_1 = 0; //연속성(+) 카운드
		var SamePass_2 = 0; //연속성(-) 카운드

		for(var i=0; i < ObjUserPassword.value.length; i++) {
			var chr_pass_0 = ObjUserPassword.value.charAt(i);
			var chr_pass_1 = ObjUserPassword.value.charAt(i+1);

			//동일문자 카운트
			if(chr_pass_0 == chr_pass_1) {
				SamePass_0 = SamePass_0 + 1
			}

			var chr_pass_2 = ObjUserPassword.value.charAt(i+2);

			//연속성(+) 카운드
			if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == 1) {
				SamePass_1 = SamePass_1 + 1
			}

			//연속성(-) 카운드
			if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == -1) {
				SamePass_2 = SamePass_2 + 1
			}
		}

		if(SamePass_0 > 1) {
			alert("비밀번호에 동일문자를 3번 이상 사용할 수 없습니다.");
			return false;
		}

		if(SamePass_1 > 1 || SamePass_2 > 1 ) {
			alert("비밀번호에 연속된 문자열(123 또는 321, abc, cba 등)을\n 3자 이상 사용 할 수 없습니다.");
			return false;
		}

		return true;
    }
}

function pw_check(obj){
	// 비밀번호(패스워드) 유효성 체크 (문자, 숫자, 특수문자의 조합으로 6~16자리)
	var ObjUserPassword = obj;

	//if(ObjUserPassword.value != objUserPasswordRe.value)
	//{
	//  alert("입력하신 비밀번호와 비밀번호확인이 일치하지 않습니다");
	//  return false;
	//}

	var alert_msg = '비밀번호는 영문, 숫자 조합으로 10자 이상 또는 영문, 숫자, 특수기호를 사용하여 8자 이상으로 조합 할 수 있습니다.';

	if(ObjUserPassword.value.length<8) {
		alert(alert_msg);
		return false;
	}

	if (ObjUserPassword.value.length >= 8 && ObjUserPassword.value.length < 10){
		//영문, 숫자 특수기호 조합 확인
		if(!ObjUserPassword.value.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/)) {
			alert(alert_msg);
			return false;
		}
	}else{
		var chk_num = ObjUserPassword.value.search(/[0-9]/g); 
		var chk_eng = ObjUserPassword.value.search(/[a-z]/ig);

		if(chk_num < 0 || chk_eng < 0){ 
			alert(alert_msg); 
			return false;
		}
	}

	//if(ObjUserID.value.indexOf(ObjUserPassword) > -1) {
	//  alert("비밀번호에 아이디를 사용할 수 없습니다.");
	//  return false;
	//}

	var SamePass_0 = 0; //동일문자 카운트
	var SamePass_1 = 0; //연속성(+) 카운드
	var SamePass_2 = 0; //연속성(-) 카운드

	for(var i=0; i < ObjUserPassword.value.length; i++) {
		var chr_pass_0 = ObjUserPassword.value.charAt(i);
		var chr_pass_1 = ObjUserPassword.value.charAt(i+1);

		//동일문자 카운트
		if(chr_pass_0 == chr_pass_1) {
			SamePass_0 = SamePass_0 + 1
		}

		var chr_pass_2 = ObjUserPassword.value.charAt(i+2);

		//연속성(+) 카운드
		if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == 1) {
			SamePass_1 = SamePass_1 + 1
		}

		//연속성(-) 카운드
		if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == -1) {
			SamePass_2 = SamePass_2 + 1
		}
	}

	if(SamePass_0 > 1) {
		alert("비밀번호에 동일문자를 3번 이상 사용할 수 없습니다.");
		return false;
	}

	if(SamePass_1 > 1 || SamePass_2 > 1 ) {
		alert("비밀번호에 연속된 문자열(123 또는 321, abc, cba 등)을\n 3자 이상 사용 할 수 없습니다.");
		return false;
	}

	return true;
}

//이메일체크 함수
function validate_email(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}

//null체크
function gf_isNull(str) {
	if (str == null) return true;
	if (str == "NaN") return true;
	if (new String(str).valueOf() == "undefined") return true;    
    var chkStr = new String(str);
    if( chkStr.valueOf() == "undefined" ) return true;
    if (chkStr == null) return true;    
    if (chkStr.toString().length == 0 ) return true;   
    return false; 
}

function go_post(arg) {
    var paramArray = [];
    //console.log(arg.split('?').length);
    if (arg.split('?').length > 1) {
        paramArray = arg.split('?')[1].split('&');
    }

	var url = arg.split('?')[0];
    var html = '';
    html = html + '<form name="go_post" action="' + url + '" method="post">';
    for (var i = 0; i < paramArray.length; ++i) {
        var paramData = paramArray[i].split('=');
        html = html + '     <input type="hidden" name="' + paramData[0] + '" value="' + paramData[1] + '" />';
    }
    html = html + '</form>';

    var $html = $(html).appendTo('body');

    if (arguments.length > 1) {
        if (arguments[1] == '_blank') {
            var target = arguments[1];
            var feature = '';
            var random_val = Math.floor((Math.random() * 99999) + 10000);

            if (arguments.length > 2) {
                feature = arguments[2];
            }

            window.open('', 'go_post' + random_val, feature);
            document.go_post.target = "go_post" + random_val;
            document.go_post.action = url;
            document.go_post.submit();

            $html.remove();
        }else if (arguments[1] == 'hiddenframe') {
			var $hiddenframe = $('<iframe name="hiddenframe" style="display:none"></iframe>').appendTo('body');
			document.go_post.target = "hiddenframe";
			document.go_post.action = url;
			document.go_post.submit();
			$hiddenframe.remove();
			$html.remove();
        }else if (arguments[1] == '_parent') {
        	document.go_post.target = "_parent";
        	document.go_post.action = url;
        	document.go_post.submit();
		}
    } else {
        $html.submit();
    }
}

//Table Row 추가(최대추가한정)
function tblAddRows(tblName, maxAdd) {
	var $tbl = $('#'+tblName);
	var total_tr_length = $tbl.find('tbody:last tr').length;
	var tr_length = $tbl.find('tbody:first tr').length;
	
	if(maxAdd > (total_tr_length/tr_length)){
		var $cloning = $tbl.find('tbody:first tr').clone(true);
		$cloning.find('.dev_datepicker').removeClass('hasDatepicker').attr('id', '');
		$tbl.find('tbody:last').append($cloning);
		jqDatepicker($cloning.find('.dev_datepicker'));
	}else{
		alert("최대"+maxAdd+"개까지 추가가능합니다.");
	}
}

function tblDelRows(el) {
	$(el).parents('tr:first').remove();
} 

function tblInitRows(el) {
	var $tr = $(el).parents('tr:first');
	$tr.find(':text').val('');
	$tr.find('select').each(function(){
		$(this).val($(this).find('option:eq(0)').val());
	});

	$tr.find('textarea').val('');
} 


//Table Tbody 추가(최대추가한정)
function tblAddTbodys(tblName, maxAdd) {
	var $tbl = $('#'+tblName);
	var total_tbody_length = $tbl.find('tbody:visible').length;
	
	if(maxAdd > total_tbody_length){
		var $cloning = $tbl.find('tbody:first').clone(true);
		$cloning.find('.dev_datepicker').removeClass('hasDatepicker').attr('id', '');
		$tbl.find('tbody:last').after($cloning);
		jqDatepicker($cloning.find('.dev_datepicker'));
	}else{
		alert("최대"+maxAdd+"개까지 추가가능합니다.");
	}
}

function tblDelTbodys(el) {
	$(el).parents('tbody:first').remove();
}

function tblInitTbodys(el) {
	var $tbody = $(el).parents('tbody:first');
	$tbody.find(':text').val('');
	$tbody.find('select').each(function(){
		$(this).val($(this).find('option:eq(0)').val());
	});

	$tbody.find('textarea').val('');
} 


//Table Tbody 추가(최대추가한정) + 첨부파일추가(첨부파일num)
//이윤재 NCS파일추가
function tblAddTbodysFile(tblName, maxAdd) {
	var $tbl = $('#'+tblName);
	var total_tbody_length = $tbl.find('tbody:visible').length;
	
	if(maxAdd > total_tbody_length){
		var $cloning = $tbl.find('tbody:first').clone(true);
		$cloning.find('.dev_datepicker').removeClass('hasDatepicker').attr('id', '');
		$tbl.find('tbody:last').after($cloning.show());
		jqDatepicker($cloning.find('.dev_datepicker'));

		$tbl.find('tbody:visible [name="file_num"]').each(function(){
			$(this).val($tbl.find('tbody:visible [name="file_num"]').index($(this)) + 1);
		});
	}else{
		alert("최대"+maxAdd+"개까지 추가가능합니다.");
	}
}

function tblDelTbodysFile(el) {
	var $tbl = $(el).parents('table:first');
	$(el).parents('tbody:first').remove();
	$tbl.find('tbody:visible [name="file_num"]').each(function(){
		$(this).val($tbl.find('tbody:visible [name="file_num"]').index($(this)) + 1);
	});
} 

function tblInitTbodysFile(el) {
	var $tbody = $(el).parents('tbody:first');
	$tbody.find(':text').val('');
	$tbody.find('select').each(function(){
		$(this).val($(this).find('option:eq(0)').val());
	});

	$tbody.find('textarea').val('');

	var $btn_ncs_upload = $tbody.find('.btn_ncs_upload');
	$btn_ncs_upload.removeClass('btn-success').addClass('btn-warning');

	var $glyphicon_upload = $btn_ncs_upload.find('.glyphicon-ok');
	$glyphicon_upload.removeClass('glyphicon-ok').addClass('glyphicon-upload');

	$tbody.find('.btn_upload_view').hide();
} 


function tblDelRows2(el) {
	$(el).parents('tr:first').next().remove();
	$(el).parents('tr:first').remove();
}

function tblInitRows2(el) {
	var $tr = $(el).parents('tr:first');
	$tr.find(':text').val('');
	$tr.find('select').each(function(){
		$(this).val($(this).find('option:eq(0)').val());
	});
	$tr.find('textarea').val('');

	$tr = $tr.next();
	$tr.find(':text').val('');
	$tr.find('select').each(function(){
		$(this).val($(this).find('option:eq(0)').val());
	});
	$tr.find('textarea').val('');
}

function gf_set_paging(form_id, currentPage){
	
	var el_form = $('#' + form_id);
	var totalData = el_form.find('[name="page_total_count"]').val();
	var dataPerPage = el_form.find('[name="page_per_count"]').val();
	if(typeof dataPerPage == "undefined" || dataPerPage == null || dataPerPage == ""){dataPerPage = 20;}
	var pageCount = 10;
	    
    var totalPage = Math.ceil(totalData/dataPerPage);    // 총 페이지 수
    var pageGroup = Math.ceil(currentPage/pageCount);    // 페이지 그룹

    var last = pageGroup * pageCount;    // 화면에 보여질 마지막 페이지 번호
    if(last > totalPage)
        last = totalPage;
    var first = last - (pageCount-1);    // 화면에 보여질 첫번째 페이지 번호
    if(first < 1)
    	first = 1;
    var next = last+1;
    var prev = first-1;

    var html = '';
    var class_active = '';
    
    if(prev > 0)
        html += '<li><a href=javascript:gf_go_paging("' + form_id + '",' + prev + ')><</a></li> ';
    
    for(var i = first; i <= last; i++){
    	class_active = '';
    	if(i == currentPage) class_active = ' class="active"';
        html += '<li' + class_active + '><a href=javascript:gf_go_paging("' + form_id + '",' + i + ')>' + i + '</a></li> ';
    }
    
    if(last < totalPage)
        html += '<li><a href=javascript:gf_go_paging("' + form_id + '",' + next + ')>></a></li> ';
        
    $(".pagination").html(html);    // 페이지 목록 생성
    
}

function gf_go_paging(form_id, currentPage){
	var el_form = $('#' + form_id);
	el_form.find('[name="page_current_no"]').val(currentPage);
    el_form.submit();
}

function setModalCookie(name){
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + 1);
	document.cookie=name + "=Y; path=/; expires=" + todayDate.toGMTString() + ";";
}

function openModalPop(name){
	 if(getModalCookie(name)!="Y"){
		$('.' + name).show();
	 }
}

function getModalCookie(name){
	var nameOfCookie = name + "=";
	var x =0;
	while (x<=document.cookie.length){
		var y = (x+nameOfCookie.length);
		if(document.cookie.substring(x,y) == nameOfCookie){
			if((endOfCookie=document.cookie.indexOf(";",y))==-1)
				endOfCookie = document.cookie.length;
			return unescape(document.cookie.substring(y, endOfCookie));
			}
			x=document.cookie.indexOf(" ",x) +1;
			if(x==0)
			break;
			}
		return "";
}
