<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="./includes/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

   <div class="container">
      <div class="row">
         <div class="col-md-12 text-center">
            <div class="text-homeimage">
               <div class="maintext-image" data-scrollreveal="enter top over 1.5s after 0.1s">
                   Increase Digital Sales
               </div>
               <div class="subtext-image" data-scrollreveal="enter bottom over 1.7s after 0.3s">
                   Boost revenue with Scorilo
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
</header>
<!-- CONTENT =============================-->
<section class="item content">
<div class="container toparea">
	<div class="underlined-title">
		<div class="editContent">
			<h1 class="text-center latestitems">${member.userId} 님의 주문내역</h1>
		</div>
		<div class="wow-hr type_short">
			<span class="wow-hr-h">
			<i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
			</span>
		</div>
	</div> 
	
	<div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
		<form id="edd_checkout_cart_form" method="post">
			<div id="edd_checkout_cart_wrap">
				<table id="edd_checkout_cart" class="ajaxed">
				<thead>
				<tr class="edd_cart_header_row">
					<th class="edd_cart_item_name">
						 상품정보
					</th>
					<th class="edd_cart_item_price">
						 주문일자
					</th>
					<th class="edd_cart_actions">
						 주문번호
					</th>
					<th class="edd_cart_item_price">
						 주문금액(수량)
					</th>
				</tr>
				</thead>
				
				<tbody>
					<c:choose>
						<c:when test="${empty orderView }" >
							<tr><td colspan="4" align="center">주문내역이 없습니다.</td></tr>
						</c:when>
						
						<c:when test="${!empty orderView}">
							<c:forEach var="list" items="${orderView}">
								<tr class="edd_cart_item" id="edd_cart_item_0_25" data-download-id="25">
								<td class="edd_cart_item_name">
								<div class="edd_cart_item_image">
								<img width="25" height="25" src="<c:out value="${list.gdsImg}"/>" alt="">
								</div>
								<span class="edd_checkout_cart_item_title"><c:out value="${list.gdsName}"/></span>
								</td>
								<td class="edd_cart_item_price">
						 			<c:out value="${list.orderDate}"/>
								</td>
								<td class="edd_cart_actions">
									<c:out value="${list.orderId}"/>
									<a class="edd_cart_remove_item_btn" href="#">
									<c:choose>
										<c:when test="${list.process == 1 }">
											배송준비
										</c:when>
										<c:when test="${list.process == 2 }">
											배송중
										</c:when>
										<c:when test="${list.process == 3 }">
											배송완료
										</c:when>
										<c:otherwise>
											배송오류. 관리자에게 문의하세요
										</c:otherwise>
									</c:choose>
									
								</td>
								<td class="edd_cart_actions">
								
									<c:out value="${list.gdsPrice}"/>(<c:out value="${list.gdsSum}"/>개)
								</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
				</table>
			</div>
		</form>
	</div>
</div>
</section>

<!-- CALL TO ACTION =============================-->
<section class="content-block" style="background-color:#00bba7;">
<div class="container text-center">
	<div class="row">
		<div class="col-sm-10 col-sm-offset-1">
			<div class="item" data-scrollreveal="enter top over 0.4s after 0.1s">
				<h1 class="callactiontitle"> Promote Items Area Give Discount to Buyers <span class="callactionbutton"><i class="fa fa-gift"></i> WOW24TH</span>
				</h1>
			</div>
		</div>
	</div>
</div>
</section>
<%@include file="./includes/footer.jsp"%>