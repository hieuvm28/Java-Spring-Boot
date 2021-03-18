<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin</title>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<!-- CSS -->
<link rel="stylesheet" href="/template/admin.css">
<base href="${pageContext.servletContext.contextPath }/">
</head>
<body>
	<div class="container-fluid">

		<jsp:include page="header.jsp"></jsp:include>


		<main class="container">
			<!-- List cart -->
			<div class="row align-items-center list-card">
				<div class="col-md-6 col-xl-3">
					<div class="card bg-c-blue order-card">
						<div class="card-block">
							<h6 class="m-b-20">User</h6>
							<div class="d-flex justify-content-between">
								<h2 class="text-right">
									<i class="fas fa-1x fa-users"></i>
								</h2>
								<h2>
									<span>${countUser}</span>
								</h2>
							</div>
							<p class="m-b-0">
								<span class="f-right"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-xl-3">
					<div class="card bg-c-blue order-card">
						<div class="card-block">
							<h6 class="m-b-20">Depart</h6>
							<div class="d-flex justify-content-between">
								<h2 class="text-right">
									<i class="fas fa-1x fa-users"></i>
								</h2>
								<h2>
									<span>${countDepart}</span>
								</h2>
							</div>
							<p class="m-b-0">
								<span class="f-right"></span>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-xl-3">
					<div class="card bg-c-blue order-card">
						<div class="card-block">
							<h6 class="m-b-20">Staff</h6>
							<div class="d-flex justify-content-between">
								<h2 class="text-right">
									<i class="fas fa-1x fa-users"></i>
								</h2>
								<h2>
									<span>${countStaff}</span>
								</h2>
							</div>
							<p class="m-b-0">
								<span class="f-right"></span>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-xl-3">
					<div class="card bg-c-blue order-card">
						<div class="card-block">
							<h6 class="m-b-20">Record</h6>
							<div class="d-flex justify-content-between">
								<h2 class="text-right">
									<i class="fas fa-1x fa-users"></i>
								</h2>
								<h2>
									<span>${countRecord}</span>
								</h2>
							</div>

							<p class="m-b-0">
								<span class="f-right"></span>
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- End-list-cart -->
			<!-- table -->
			
			<h1>${mess}</h1>
			
			<div class="listEmploy">
				<h3>Nhân viên xuất sắc</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Image</th>
							<th scope="col">ID</th>
							<th scope="col">Fullname</th>
							<th scope="col">Email</th>
							<th scope="col">Total Compliment</th>
							<th scope="col">Total Punishment</th>
							<th scope="col">Summarize</th>
							<th scope="col">SendEmail</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${staffGood}">
							<tr>
								<td><img src="<c:url value = "images/${s[0]}"/>" width="50px"></td>
								<td>${s[1]}</td>
								<td>${s[2]}</td>
								<td>${s[3]}</td>
								<td>${s[4]}</td>
								<td>${s[5]}</td>
								<td>${s[4] - s[5]}</td>
								<td>
									<form action="/sendEmail" method="post">
									<input type="hidden" name="name" value="${s[2]}">
									<input type="hidden" name="to" value="${s[3]}">
										<button class="btn btn-block btn-outline-success">Mail</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- end-table -->
		</main>
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