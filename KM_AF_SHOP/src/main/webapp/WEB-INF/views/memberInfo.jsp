<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Login V4</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<!--===============================================================================================-->
<script>
</script>
</head>

<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('/resources/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="/update" role="form" method="post" autocomplete="off">
					<span class="login100-form-title p-b-49">
						회원정보 수정
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "아이디를 입력해주세요.">
						<span class="label-input100">아이디</span>
						<input class="input100" type="text" name="userId" value = "${member.userId}" readonly="readonly">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" data-validate="비밀번호를 입력해주세요.">
						<span class="label-input100">비밀번호</span>
						<input class="input100" type="password" name="userPw" placeholder="비밀번호를 입력해주세요.">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="이름을 입력해주세요.">
						<span class="label-input100">이름</span>
						<input class="input100" type="text" name="userName" value="${member.userName}">
						<span class="focus-input100" data-symbol="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="이메일을 입력해주세요.">
						<span class="label-input100">이메일</span>
						<input class="input100" type="email" name="userEmail" value="${member.userEmail}">
						<span class="focus-input100" data-symbol="&#xf15a;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="연락처를 입력해주세요.">
						<span class="label-input100">연락처</span>
						<input class="input100" type="tel" name="userTel" value="${member.userTel}">
						<span class="focus-input100" data-symbol="&#xf2be;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="우편번호를 입력해주세요.">
						<span class="label-input100">우편번호</span>
						<input class="input100" type="number" name="userZipcode" value="${member.userZipcode}">
						<span class="focus-input100" data-symbol="&#xf159;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="주소를 입력해주세요.">
						<span class="label-input100">주소</span>
						<input class="input100" type="text" name="userAddr1" value="${member.userAddr1}">
						<span class="focus-input100" data-symbol="&#xf159;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate="상세 주소를 입력해주세요.">
						<span class="label-input100">상세 주소</span>
						<input class="input100" type="text" name="userAddr2" value="${member.userAddr2}">
						<span class="focus-input100" data-symbol="&#xf159;"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" id="submit">
								정보 수정
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/resources/js/main.js"></script>

</body>
</html>