<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Login</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/template/util.css">
<link rel="stylesheet" type="text/css" href="/template/main.css">
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form action="/login" method="post" modelAttribute="auth"
					class="login100-form validate-form p-l-55 p-r-55 p-t-178">
					<span class="login100-form-title"> Sign In </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<form:input class="input100" type="text" path="username" name="username" id="username"
							placeholder="Username" /> <span class="focus-input100" />
					</div>
					<form:errors path="username" id="usernameerror" style="color:red;" />
					
					<div class="wrap-input100 validate-input"
						data-validate="Please enter password">
						<form:input class="input100" type="password" path="password" name="password" id="password"
							placeholder="Password"/> <span class="focus-input100" />
					</div>
					<form:errors path="password" id="passworderror" style="color:red;" />
					<div class="text-right p-t-13 p-b-23">
						<span class="txt1"> Forgot </span> <a href="#" class="txt2">
							Username / Password? </a>
					</div>

					<div class="container-login100-form-btn">

						<button class="login100-form-btn" id="login">Sign in</button>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9"> Don't have an account? </span> <a
							href="#" class="txt3"> Sign up now </a>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>