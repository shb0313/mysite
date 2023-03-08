<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/guestbook-spa.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var startNo = 0;
var isEnd = false;

var messageBox = function(title, message, callback) {
	$("#dialog-message p").text(message);
	$("#dialog-message").attr("title", title).dialog({
		width : 340,
		height : 170,
		modal : true,
		buttons : {
			"확인" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {
			callback && callback();
		}

	});
}

var render = function(vo, mode) {
	
	var htmls = 
		"<li data-no='" + vo.no + "'>" + 
		"	<strong>" + vo.name	+ "</strong>" + 
		"	<p>" + vo.message + "</p>" + 
		"	<strong></strong>" + 
		"	<a href='' data-no='" + vo.no + "'>삭제</a>" + 
		"</li>"; 
			
	$("#list-guestbook")[mode ? "prepend" : "append"](htmls);
}

var fetch = function() {
	
	$.ajax({
		url: "${pageContext.request.contextPath }/guestbook/api?sno=" + startNo,
		type: "get",
		dataType: "json",
		data: startNo,
		success: function(response) {
			console.log(response);
	
			if (response.result === 'fail') {
				console.error(response.message);
				return;
			}
			
			// detect end
			if(response.data.length == 0){
				isEnd = true;
				return;
			}

			console.log(response.data);

			response.data.forEach(function(vo) {
				render(vo);
			});
			
			startNo = $('#list-guestbook li').last().data('no') || 0;
		},
		error: function(xhr, status, e){
			console.error(status + ":" + e);
		}
	});
}

// add
$(function() {
	$("#add-form").submit(function(event) {
		event.preventDefault();
		
		// form serialization
		var vo = {};
		vo.name = $("#input-name").val();
		vo.password = $("#input-password").val();
		vo.message = $("#tx-content").val();

		// name, password, content 중에 하나라도 빠진 경우 dialog
		if(vo.name == ''){
			messageBox("회원가입", "이름 잊었지요?", function() {
				$("#input-name").focus();
			});
			
			return;
	
		} else if(vo.password == '') {
			messageBox("회원가입", "비밀번호 잊었지요?", function() {
				$("#input-password").focus();
			});
			
			return;
			
		} else if(vo.message == '') {
			messageBox("회원가입", "내용 잊었지요?", function() {
				$("#tx-content").focus();
			});
			
			return;
		}
		
		// validation & messagebox
		$.ajax({
			url: "${pageContext.request.contextPath }/guestbook/api",
			type: "post",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify(vo),
			success: function(response) {
				console.log(response);
				
				if(response.result === 'fail') {
					console.error(response.message);
					return;
				}
				
				render(response.data, true);
			}
		});	
		
		$("#input-name").val('');
		$("#input-password").val('');
		$("#tx-content").val('');
	});
});

// delete
$(function() {
	// 삭제 dialog jQuery 객체 미리 만들기
	var $dialogDelete = $("#dialog-delete-form").dialog({
		autoOpen: false,
		modal: true,
		buttons: {
			"삭제": function() {
				console.log("ajax 삭제하기");
				
				no = $("#hidden-no").val();				
				password = $("#password-delete").val();	
				
				//비밀번호 입력이 null인 경우
				if(password == null || password == ''){
					messageBox("메세지 삭제", "비밀번호 잊었지요?");
					return;
				}
				
				$.ajax({
					url: "${pageContext.request.contextPath }/guestbook/api/" + no,
					async: true,
					type: "delete",
					dataType: "json",
					data: password,
					success: function(response) {
						console.log(response);
						
						if(response.result === 'fail') {
							console.error(response.message);
							return;
						}

						if(response.data === -1) {
							console.log("비밀번호 틀렸지요?");	
							$("#dialog-delete-form p.validateTips.error").show();
						}
						
						$(this).dialog('close');
						$("li[data-no=" + no + "]").remove();
					},
					error: function(xhr, status, e){
						console.error(status + ":" + e);
					}
				});
			},
			"취소": function() {
				console.log("삭제 dialog의 폼 데이터 리셋하기");
				$(this).dialog('close');
			}
		},
		close: function(){
			$("#hidden-no").val("");
			$("#password-delete").val("");
			$("#dialog-delete-form p.validateTips.error").hide();
		}
		
	});

	// 메세지 삭제 버튼 click event 처리(Live Event)
	$(document).on('click', "#list-guestbook li a", function(event) {
		event.preventDefault();
		
		console.log($(this).data("no"));
		$("#hidden-no").val($(this).data("no"));
		
		$("#password-delete").val('');
		
		$dialogDelete.dialog('open');		

	});

	//최초 리스트 가져오기
	fetch();
});

$(function(){
	$(window).scroll(function(){
		var $window = $(this);
		var $document = $(document);
	
		var windowHeight = $window.height();
		var documentHeight = $document.height();
		var scrollTop = $window.scrollTop();
		
		if(documentHeight < windowHeight + scrollTop + 10) {
			console.log("리스트 추가");
			fetch();
		}
	});
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="guestbook">
				<h1>방명록</h1>
				<form id="add-form" action="" method="post">
					<input type="text" id="input-name" placeholder="이름">
					<input type="password" id="input-password" placeholder="비밀번호">
					<textarea id="tx-content" placeholder="내용을 입력해 주세요."></textarea>
					<input type="submit" value="보내기" />
				</form>
				<ul id="list-guestbook"></ul>
			</div>
			<div id="dialog-delete-form" title="메세지 삭제" style="display:none">
  				<p class="validateTips normal">작성시 입력했던 비밀번호를 입력하세요.</p>
  				<p class="validateTips error" style="display:none">비밀번호가 틀립니다.</p>
  				<form>
 					<input type="password" id="password-delete" value="" class="text ui-widget-content ui-corner-all">
					<input type="hidden" id="hidden-no" value="">
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
  				</form>
			</div>
			<div id="dialog-message" title="" style="display:none; line-height: 75px">
  				<p></p>
			</div>						
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>