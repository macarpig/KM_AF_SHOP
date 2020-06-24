<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head><title></title>

<%@include file="./includes/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">


</script>
</head>

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

<body>
<!-- CONTENT =============================-->
<section class="item content">
<div class="container toparea">
	<div class="underlined-title">
      <div class="editContent">
         <h1 class="text-center latestitems">${member.userName}님의 마이페이지</h1>
      </div>
       
      <div class="wow-hr type_short">
         <span class="wow-hr-h">
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         </span>
      </div>
   </div>
   
   <div class="row">
		<div class="col-md-4">
			<div class="productbox">
				<div class="product-details">
					<a href="${pageContext.request.contextPath}/cartCheck">
					<span class="maxproduct"><img src="resources/images/cart.png" alt=""></span>
					<h1>장바구니</h1>
					</a>
					<span class="price">
					<span class="edd_price">장바구니 가기</span>
					</span>
				</div>
			</div>
		</div>
		<!-- 회원정보 수정 -->
		<div class="col-md-4">
			<div class="productbox">
				<div class="product-details">
					<a href="${pageContext.request.contextPath}/memberInfo">
					<span class="maxproduct"><img src="resources/images/membership.png" alt=""></span>
					<h1>회원정보 수정</h1>
					</a>
					<span class="price">
					<span class="edd_price">회원정보 수정하기</span>
					</span>
				</div>
			</div>
		</div>
		<!-- /.productbox -->
		<div class="col-md-4">
			<div class="productbox">
				<div class="product-details">
					<a href="${pageContext.request.contextPath}/orderList?c=${member.userId}">
					<span class="maxproduct"><img src="resources/images/list.png" alt=""></span>
					<h1>주문내역</h1>
					</a>
					<span class="price">
					<span class="edd_price">주문내역 보기</span>
					</span>
				</div>
			</div>
		</div>
		
	</div>
</div>
</div>
</section>

<%@include file="./includes/footer.jsp" %>