<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="">
</head>
<body>


<!-- HEADER =============================-->
<header class="item header margin-top-0">
<div class="wrapper">
   <nav role="navigation" class="navbar navbar-white navbar-embossed navbar-lg navbar-fixed-top">
   <div class="container">
      <div class="navbar-header">
         <button data-target="#navbar-collapse-02" data-toggle="collapse" class="navbar-toggle" type="button">
         <i class="fa fa-bars"></i>
         <span class="sr-only">Toggle navigation</span>
         </button>
         <a href="/" class="navbar-brand brand"> MAKAPIG </a>
      </div>
      <div id="navbar-collapse-02" class="collapse navbar-collapse">
         <ul class="nav navbar-nav navbar-right">
            <li class="propClone"><a href="/shop?c=0&l=0">Shop</a></li>
            <li class="propClone"><a href="/cart">Cart</a></li>
            <li class="propClone"><a href="/getNoticeList">Notice</a></li>
            <li class="propClone"><a href="/getFaqList">FaQ</a></li>
            <c:choose>
        <c:when test="${member == null }">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
        </c:when>
        <c:otherwise>
        <a href="${pageContext.request.contextPath}/mypage">마이페이지</a>
         | 
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
        </c:otherwise>
        </c:choose>
         </ul>
      </div>
      <div>
      
      </div>
   </div>
   </nav>