<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>글작성</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/getNoticeList";
	});
	
	$(document).ready(function() {
		var mode='<c:out value="${mode}"/>';
		if(mode == 'edit') {
			$("input:hidden[name='noticeId']").val(<c:out value="${noticeContent.noticeId}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#notiTitle").val('<c:out value="${noticeContent.notiTitle}"/>');
			$("#notiContent").val('<c:out value="${noticeContent.notiContent}"/>');
		}
			$("#btnSave").click(function(e) {
				var title = $("#notiTitle").val();
				var content = $("#notiContent").val();
				if(title == "") {
					alert('제목을 입력해 주세요.');
					$("#notiTitle").focus();
					return;
				}
				if(content == "") {
					alert('내용을 입력해 주세요.');
					$("#notiContent").focus();
					return;
				}
				e.preventDefault();
				$("#form").submit();
			});
	});
</script>
</head>
<body>
<article>
		<div class="container" role="main">
			<h2>공지 글 작성</h2>
			<form:form name="form" id="form" role="form" modelAttribute="NoticeVO" method="post" action="${pageContext.request.contextPath}/saveNotice">
				<form:hidden path="noticeId"/>
				<input type="hidden" name="mode" />
				<div class="mb-3">
					<label for="notiTitle">제목</label>
					<form:input path="notiTitle" class="form-control" id="notiTitle" placeholder="제목을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="notiContent">내용</label>
					<form:textarea path="notiContent" class="form-control" rows="5" id="content" placeholder="내용을 입력해 주세요"/>
				</div>
			</form:form>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>
</body>
</html>
