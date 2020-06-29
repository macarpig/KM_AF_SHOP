<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%@include file="./includes/header.jsp" %>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
<script>
$(document).ready(function() {
    var activeSystemClass = $('.list-group-item.active');

    //something is entered in search form
    $('#system-search').keyup( function() {
       var that = this;
        // affect all table rows on in systems table
        var tableBody = $('.table-list-search tbody');
        var tableRowsClass = $('.table-list-search tbody tr');
        $('.search-sf').remove();
        tableRowsClass.each( function(i, val) {
        
            //Lower text for case insensitive
            var rowText = $(val).text().toLowerCase();
            var inputText = $(that).val().toLowerCase();
            if(inputText != '')
            {
                $('.search-query-sf').remove();
                tableBody.prepend('<tr class="search-query-sf"><td colspan="6"><strong>검색 결과: "'
                    + $(that).val()
                    + '"</strong></td></tr>');
            }
            else
            {
                $('.search-query-sf').remove();
            }

            if( rowText.indexOf( inputText ) == -1 )
            {
                //hide rows
                tableRowsClass.eq(i).hide();
                
            }
            else
            {
                $('.search-sf').remove();
                tableRowsClass.eq(i).show();
            }
        });
        //all tr elements are hidden
        if(tableRowsClass.children(':visible').length == 0)
        {
            tableBody.append('<tr class="search-sf"><td class="text-muted" colspan="6">No entries found.</td></tr>');
        }
    });
});

$(document).on('click', '#btnWriteForm', function(e){
	e.preventDefault();

	location.href = "${pageContext.request.contextPath}/faqForm";
});
</script>
<style>
input[id="answer"] {
	display:none;
}	
</style>
<br><br><br>
<div class="container">
<h2>FaQ 게시판 <br><br><br><br><br></h2>
	<div class="row">
        <div class="col-md-3">
            <form action="#" method="get">
                <div class="input-group">
                    <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </span>
                </div>
            </form>
        </div>
		<div class="col-md-9">
		
    	 <table class="table table-list-search">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>질문</th>
                            <th>작성자</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:choose>

				<c:when test="${empty faqList }" >

					<tr><td colspan="3" align="center">데이터가 없습니다.</td></tr>

				</c:when> 

				<c:when test="${!empty faqList}">
                       <c:forEach var="list" items="${faqList}">

						<tr>
						<td>
							<c:out value="${list.faqId }"/>
						</td>
						<td>
						<div class="faq">
							<input type="checkbox" id="answer">
							<label for="answer"><c:out value="${list.faqQ}"/></label>
							<div><p><c:out value="${list.faqA}"/></p></div>
						</div>	
						</td>

							<td>관리자</td>
						</tr>				
					</c:forEach>

				</c:when>

					</c:choose>
                    </tbody>
                </table>
                
                <div>
                <c:choose>
                <c:when test="${member.userAuth == 1 }">
			<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm" style="float: right;">글쓰기</button>
			</c:when><c:otherwise></c:otherwise></c:choose>
			</div>   
		</div>
	</div>
</div>
<br><br><br><br><br>