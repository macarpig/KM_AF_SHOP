<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head><title>macarpig - shop</title>

<%@include file="./includes/header.jsp" %>
<% String gCode = request.getParameter("n"); %>
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
			<h1 class="text-center latestitems">${product.gdsName}</h1>
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
		<div class="col-md-8">
			<div class="productbox">
				<img src="${product.gdsImg}" alt="">
				<div class="clearfix">
				</div>
				<br/>
				<div class="product-details text-left">
					<p>
						${product.gdsDesc}
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-4">
		개수 :&nbsp;&nbsp;  <select id="countbox">
			<option>1</option>
			<option>2</option>
			</select><p></p>
			<a href="/checkout?n=${product.gdsCode}" class="btn btn-buynow">${product.gdsPrice} - Purchase</a><p></p>
			<a href="#" class="btn btn-buynow">장바구니</a>
			<div class="properties-box">
				<ul class="unstyle">
					<li><b class="propertyname">상품이름:</b> ${procuct.gdsName}</li>
					<li><b class="propertyname">Image Size:</b> 2340x1200</li>
					<li><b class="propertyname">가격:</b> ${product.gdsPrice}</li>
					<li><b class="propertyname">상품등록날짜:</b> ${product.gdsDate}</li>
					<li><b class="propertyname">조회수:</b> ${product.gdsView}</li>
					<li><b class="propertyname">Requires:</b> Easy Digital Downloads</li>
					<li><b class="propertyname">Environment:</b> Wordpress</li>
					<li><b class="propertyname">Any Field Etc:</b> Any Detail</li>
					<li><b class="propertyname">Number:</b> Up to 20 specifications in this box</li>
					<li><b class="propertyname">Live Demo:</b><a target="_blank" href="http://www.wowthemes.net/">http://www.wowthemes.net/</a></li>
				</ul>
			</div>
		</div>
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

<%@include file="./includes/footer.jsp" %>