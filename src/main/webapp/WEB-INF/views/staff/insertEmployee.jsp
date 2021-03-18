<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<div class="container-fluid">

		<header>
			<!-- 			<div class="row align-items-center menu"> -->
			<!-- 				<div class="col-sm-3"> -->
			<!-- 					<h1>vmh</h1> -->
			<!-- 				</div> -->
			<!-- 				<div class="col-sm-6"> -->
			<!-- 					<ul class="nav justify-content-center"> -->
			<!-- 						<li class="nav-item"><a class="nav-link" href="user/listUser">User</a></li> -->
			<!-- 						<li class="nav-item"><a class="nav-link" href="#">Depart</a> -->
			<!-- 						</li> -->
			<!-- 						<li class="nav-item"><a class="nav-link" href="#">Employee</a> -->
			<!-- 						</li> -->
			<!-- 						<li class="nav-item"><a class="nav-link" href="#">Record</a> -->
			<!-- 						</li> -->
			<!-- 						<li class="nav-item"><a class="nav-link" href="#">Summarize</a> -->
			<!-- 						</li> -->
			<!-- 					</ul> -->

			<!-- 				</div> -->
			<!-- 				<div class="col-sm-3"> -->
			<%-- 					<form class="form-inline" action=""> --%>
			<!-- 						<input class="form-control mr-sm-2" type="text" -->
			<!-- 							placeholder="Search"> -->
			<!-- 						<button class="btn btn-success" type="submit">Search</button> -->
			<%-- 					</form> --%>
			<!-- 				</div> -->
			<!-- 			</div> -->
			<jsp:include page="../header.jsp" />
		</header>

		<main class="container">
			<div style="margin-top: 100px;" class="card card-primary">
				<div style="background: #57b846;" class="card-header">
					<h3 class="card-title">Add Employee</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<div class="card-body">
					<form:form action="/staff/insert" method="post"
						modelAttribute="employee">
						<div hidden="" class="form-group row">
							<label class="col-sm-2 col-form-label">ID</label>
							<div class="col-sm-10">
								<form:input path="id" class="form-control" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Full name</label>
							<div class="col-sm-10">

								<form:input path="name" id="fullname" class="form-control" type="text" />
								<br>
								<form:errors path="name" id="fullnameerror" style="color:red;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Gender</label>
							<div class="col-sm-10">
								<form:radiobutton path="gender" id="gender" value="true" label="Nam" />
								<form:radiobutton path="gender" id="gender" value="false" label="Nữ" />
								<br>
								<form:errors path="gender" id="gendererror" style="color:red;" />

							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Birthday</label>
							<div class="col-sm-10">
								<form:input path="birthday" id="birthday" class="form-control"
									placeholder="dd/MM/yyyy" />
								<br>
								<form:errors path="birthday" id="birthdayerror" style="color:red;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Image</label>
							<div class="col-sm-10">
								<form:input path="photo" type="file" cssClass="form-control"
									name="photo" id="photo" />

								<!-- 								<input type="file" class="form-control" name="photo"> -->
								<%-- 								<form:hidden path="photo" /> --%>
								<br>
								<form:errors path="photo" id="photoerror" style="color:red;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<form:input id="email" path="email" name="email"
									class="form-control" type="text" />
								<br>
								<form:errors id="emailerror" path="email" style="color:red;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Phone</label>
							<div class="col-sm-10">
								<form:input path="phone" id="phone" name="phone"
									class="form-control" type="text" value="phone" maxlength="10" />
								<br>
								<form:errors path="phone" id="phoneerror" style="color:red;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Salary</label>
							<div class="col-sm-10">
								<form:input path="salary" id="salary" name="salary"
									class="form-control" type="text" />
								<br>
								<form:errors path="salary" id="salaryerror" style="color:red;" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Note</label>
							<div class="col-sm-10">
								<form:textarea path="note" id="note"  name="note"
									class="form-control" maxlength="500" rows="3" />
								<br>
								<form:errors path="note" id="noteerror" style="color:red;" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Depart</label>
							<div class="col-sm-10">
								<form:select path="depart.id" items="${depart}" itemValue="id"
									itemLabel="name" class="form-control" />
							</div>
						</div>

						<div>
							<button type="submit" id="insert" class="btn btn-primary">Insert</button>
							<a href="/staff/listStaff" id="exit" class="btn btn-primary">Exit</a>
						</div>
					</form:form>
				</div>
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