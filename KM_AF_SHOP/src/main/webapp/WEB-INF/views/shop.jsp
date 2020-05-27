<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head><title>macarpig - shop</title>

<%@include file="./includes/header.jsp" %>
<% String cCode = request.getParameter("c");
   String cLevel = request.getParameter("l"); %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
var jsonData = JSON.parse('${category}');

var cate1Arr = new Array();
var cate1Obj = new Object();
var cate2Arr = new Array();
var cate2Obj = new Object();
var present;
var title;

for(var i = 0; i < jsonData.length; i++){
   if(jsonData[i].level == "1"){
      cate1Obj = new Object();
      cate1Obj.cateCode = jsonData[i].cateCode;
      cate1Obj.cateName = jsonData[i].cateName;
      cate1Arr.push(cate1Obj);
   }
   if(jsonData[i].cateCode == <%=cCode%>){
      title = jsonData[i].cateName;
      if(<%=cLevel%> == "1"){
         present = jsonData[i].cateCode;
      }else if(<%=cLevel%> == "2"){
         present = jsonData[i].cateCodeRef;
      }
   }
}
$(document).ready(function(){
	

var cate1Div = $("div.category1");

for(var i = 0; i < cate1Arr.length; i++){
  cate1Div.append('<a href=\"/controller/shop?c='+cate1Arr[i].cateCode+'&l=1\">'+cate1Arr[i].cateName+'</a>');
}

for(var i = 0; i < jsonData.length; i++){
   if(jsonData[i].level == "2"){
      if(jsonData[i].cateCodeRef == present){
         cate2Obj = new Object();
         cate2Obj.cateCode = jsonData[i].cateCode;
         cate2Obj.cateName = jsonData[i].cateName;
         cate2Arr.push(cate2Obj);
      }
   }
}

var cate2Div = $('div.category2');

for(var i = 0; i < cate2Arr.length; i++){
   cate2Div.append("<a href='/controller/shop?c="+cate2Arr[i].cateCode+"&l=2'>"+cate2Arr[i].cateName+"</a>");
}

var cateH1 = $("h1.latestitems");
if(<%=cCode%>==0){
	cateH1.append("All");
}else{
	cateH1.append(title);
}
});
alert(cate1Div.html());
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
         <h1 class="text-center latestitems"></h1>
      </div>
      <div class="wow-hr type_short">
         <span class="wow-hr-h">
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         </span>
      </div>
   </div>
   
   <!-- Category (JSON 사용. 왜? 상위카테고리랑 하위 카테고리랑 분류하는 계산이 필요하니까!) -->
   <div class="row">   
   <div class="c12 text-center filtertagscats">
   <a href="/controller/shop?c=0&l=0">All</a>
   <div class="category1" id="category1"></div>
   </div></div>
   
   <div class="row">   
   <div class="c12 text-center filtertagscats">
   <div class="category2"></div>
   </div></div>
   
   
   <!-- Items -->
   <c:forEach items="${list}" var="list">
   <li>
      <div class="goodsImg">
         <img src="${list.gdsImg}">
      </div>
      <div class="goodsName">
         <a href="/controller/product?n=${list.gdsCode}">${list.gdsName}</a>
      </div>
   </li>
   </c:forEach>
   
   <!-- 상품들이 한 줄에 세 개씩 보여짐 -->
   <div class="row">
   <c:forEach items="${list}" var="list">
   <c:set var="i" value="1" />
      <div class="col-md-4">
         <div class="productbox">
            <div class="fadeshop">
               <div class="captionshop text-center" style="display: none;">
                  <h3>Item Name</h3>
                  <p>
                      This is a short excerpt to generally describe what the item is about.
                  </p>
                  <p>
                     <a href="#" class="learn-more detailslearn"><i class="fa fa-shopping-cart"></i> Purchase</a>
                     <a href="#" class="learn-more detailslearn"><i class="fa fa-link"></i> Details</a>
                  </p>
               </div>
               <span class="maxproduct"><img src="${list.gdsImg}" alt=""></span>
            </div>
            <div class="product-details">
               <a href="/controller/product?n=${list.gdsCode}">
               <h1>${list.gdsName}</h1>
               </a>
               <span class="price">
               <span class="edd_price">${list.gdsPrice}</span>
               </span>
            </div>
         </div>
      </div>
      <c:if test="${i eq 3}">
    <c:out value="</div><div class='row'>" />
	</c:if>
	<c:set var="i" value="${i + 1}"/>
</c:forEach>
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