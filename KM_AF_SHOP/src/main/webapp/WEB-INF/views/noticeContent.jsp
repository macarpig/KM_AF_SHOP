<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="getNoticeContent" value="/noticeContent"></c:url>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	//목록 버튼
	$(document).on('click', '#btnList', function(){
		location.href = "${pageContext.request.contextPath}/getNoticeList";
	});
	
	//수정 버튼
	$(document).on('click', '#btnUpdate', function() {
		var url = "${pageContext.request.contextPath}/modifyNotice";
		url = url + "?noticeId="+${noticeContent.noticeId};
		url = url + "&mode=edit";
		
		location.href = url;
	});
	
	//삭제 버튼
	$(document).on('click', '#btnDelete', function() {
		var url = "${pageContext.request.contextPath}/deleteNotice";
		url = url + "?noticeId="+ ${noticeContent.noticeId};
		location.href = url;
	});
</script>
<style>
body {
padding-top: 50px;
padding-bottom: 20px;
}
.board_title {
	font-weight : 700;
	font-size : 22pt;
	margin : 10pt;
}
.board_info_box {
	color : #6B6B6B;
	margin : 10pt;
}
.board_author {
	font-size : 10pt;
	margin-right : 10pt;
}
.board_date {
	font-size : 10pt;
}
.board_content {
	color : #444343;
	font-size : 12pt;
	margin : 10pt;
}
.board_tag {
	font-size : 11pt;
	margin : 10pt;
	padding-bottom : 10pt;
}
</style>
</head>
<body>
<article>
		<div class="container" role="main">
			<h2>공지게시판<br><br><br></h2>
			<div class="bg-white rounded shadow-sm">
				<div class="board_title"><c:out value="${noticeContent.notiTitle}"/></div>
				<div class="board_info_box">
					<span class="board_author"><c:out value="관리자"/>,</span><span class="board_date"><c:out value="${noticeContent.notiDate}"/></span>
				</div>
				<div class="board_content">${noticeContent.notiContent}</div>
			</div>
			<div style="margin-top : 20px">
				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
	</article>
	<%@include file="./includes/footer.jsp" %>
</body>
</html>