<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!doctype html>
<html lang="en">
<head>
<title>User</title>
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

		<header>
			<div class="row align-items-center menu">
				<div class="col-sm-3">
					<a class="logo" href="/admin">vmh</a>
				</div>
				<div class="col-sm-6">
					<ul class="nav justify-content-center">
						<li class="nav-item"><a class="nav-link" href="user/">User</a></li>
						<li class="nav-item"><a class="nav-link"
							href="depart/listDepart">Depart</a></li>
						<li class="nav-item"><a class="nav-link"
							href="staff/listStaff">Employee</a></li>
						<li class="nav-item"><a class="nav-link"
							href="record/listRecord">Record</a></li>
						<li class="nav-item"><a class="nav-link" href="summarize">Summarize</a>
						</li>
					</ul>

				</div>
				<div class="col-sm-3">
					<form class="form-inline" action="staff/search" method="get">
						<input name="name" class="form-control mr-sm-2" type="text"
							placeholder="Search">
						<button class="btn btn-success" type="submit">Search</button>
					</form>
				</div>
			</div>
			<%-- 			<jsp:include page="../header.jsp" /> --%>
		</header>

		<main class="container-fluid">
			<div style="margin-top: 100px;" class="card card-primary">
				<div style="background: #57b846;" class="card-header">
					<h3 class="card-title">List Employee</h3>
					<div class="card-header-right">
						<ul class="list-unstyled card-option">
							<li><i class="fa fa-chevron-left"></i></li>
							<li><i class="fa fa-window-maximize full-card"></i></li>
							<li><i class="fa fa-minus minimize-card"></i></li>
						</ul>
					</div>
				</div>
				<!-- /.card-header -->
				<!-- form start -->

				<div class="card-body">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<th>ID</th>
									<th>Full name</th>
									<th>Gender</th>
									<th>Birthday</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Salary</th>
									<th>Note</th>
									<th>Depart ID</th>
									<th>Image</th>
									<th>Update</th>
									<th>Delete</th>
								</tr>

								<c:forEach var="em" items="${listStaff}">

									<tr>

										<td>${em.id}</td>
										<td>${em.name}</td>
										<td>${em.gender?'Nam':'Nữ'}</td>
										<td><f:formatDate value="${em.birthday}"
												pattern="dd/MM/yyyy" /> <input type="hidden"
											value="${em.birthday}"></td>

										<td>${em.email }</td>
										<td>${em.phone }</td>
										<td>${em.salary}</td>
										<td>${em.note }</td>
										<td>${em.depart.id}</td>
										<%-- 								<c:url value = "/image/${em.photo}"/> --%>
										<td><img src="<c:url value = "images/${em.photo}"/>"
											width="50px"></td>
										<td><a href="/staff/update/${em.id}"
											class="btn btn-primary">Update</a></td>


										<td><a href="/staff/delete/${em.id}"
											class="btn btn-primary">Delete</a></td>

									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!-- /.card-body -->


				<form:form action="/staff/insert" method="get">
					<div class="card-footer">
						<button type="submit" class="btn btn-primary">Insert</button>
						<a href="staff/listStaff" class="btn btn-danger">List Staff</a>

						<nav style="display: inline-block; margin-left: 520px;"
							aria-label="Page navigation example">
							<ul class="pagination">
								
								<li class="page-item"><a class="page-link"
									href="staff/listStaff">1</a></li>

								<c:forEach var="page" begin="2" end="${countPage}">
									<li class="page-item"><a class="page-link"
										href="staff/listStaff/${page}">${page}</a></li>
								</c:forEach>

							</ul>
						</nav>

					</div>

				</form:form>
			</div>

		</main>
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