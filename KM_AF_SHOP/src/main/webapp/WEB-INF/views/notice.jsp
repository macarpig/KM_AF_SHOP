<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%@include file="./includes/header.jsp" %>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판</title>
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
</style>
<c:url var="getNoticeList" value="/notice"></c:url>
<script>
	
	$(document).on('click', '#btnWriteForm', function(e){
		e.preventDefault();

		location.href = "${pageContext.request.contextPath}/noticeForm";
	});
	
	function fn_contentView(noticeId){
		var url = "${pageContext.request.contextPath}/getNoticeContent";
		url = url + "?noticeid="+noticeId;
		location.href = url;
	}
	
</script>
</head>
<body bgcolor="white">
<article>
	<div class="container" role="main">
	<h2>공지게시판<br><br><br></h2>
	<table class="table table-striped table-sm" bgcolor="white">

		<colgroup>

			<col style="width:auto;" />

			<col style="width:15%;" />

			<col style="width:10%;" />

			<col style="width:10%;" />

		</colgroup>

		<thead>

			<tr>
				
				<th>글제목</th> 

				<th>작성자</th>

				<th>작성일</th>

				<th>조회수</th>

			</tr>

		</thead>

		<tbody>

			<c:choose>

				<c:when test="${empty noticeList }" >

					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>

				</c:when> 

				<c:when test="${!empty noticeList}">

					<c:forEach var="list" items="${noticeList}">

						<tr>
						<td>
							<a href="#" onclick="fn_contentView(<c:out value="${list.noticeId}"/>)">
							<c:out value="${list.notiTitle}"/>
							</a>
						</td>

							<td>관리자</td>

							<td><c:out value="${list.notiDate}"/></td>

							<td><c:out value="  ${list.notiView}"/></td>
						</tr>				
					</c:forEach>

				</c:when>

			</c:choose>

		</tbody>

	</table>
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
		</div>
		</div>
	</article>
</body>
</html>