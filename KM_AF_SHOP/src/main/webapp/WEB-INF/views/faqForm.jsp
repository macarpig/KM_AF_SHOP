<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
		location.href="${pageContext.request.contextPath}/getFaqList";
	});
	
	$(document).ready(function() {
		var mode='<c:out value="${mode}"/>';
			$("#btnSave").click(function(e) {
				var title = $("#faqQ").val();
				var content = $("#faqA").val();
				if(title == "") {
					alert('질문을 입력해 주세요.');
					$("#faqQ").focus();
					return;
				}
				if(content == "") {
					alert('답변을 입력해 주세요.');
					$("#faqA").focus();
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
			<h2>faq 글 작성</h2>
			<form:form name="form" id="form" role="form" modelAttribute="FaqVO" method="post" action="${pageContext.request.contextPath}/saveFaq">
				<form:hidden path="faqId"/>
				<input type="hidden" name="mode" />
				<div class="mb-3">
					<label for="faqQ">질문</label>
					<form:input path="faqQ" class="form-control" id="faqQ" placeholder="질문을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="notiContent">답변</label>
					<form:textarea path="faqA" class="form-control" rows="5" id="content" placeholder="답변을 입력해 주세요"/>
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
