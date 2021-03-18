<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<base href="${pageContext.servletContext.contextPath }/">
<link rel="stylesheet" href="/template/admin.css">
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
			<!-- 						<li class="nav-item"><a class="nav-link" href="">Depart</a></li> -->
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
				<h1>${mess}</h1>
				<div style="background: #57b846;" class="card-header">
					<h3 class="card-title">Add Record</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<form:form action="/record/insertRecord" method="post"
					modelAttribute="record">
					<div class="card-body">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Staff</label>
							<div class="col-sm-10">
								<form:select path="staff.id" items="${staff}" itemValue="id"
									itemLabel="name" class="form-control" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Type</label>
							<div class="col-sm-10">
								<form:radiobutton path="type" value="true" label="Good" />
								<form:radiobutton path="type" value="false" label="Not Good" />
								<br>
								<form:errors path="type" cssStyle="color:red;" />
							</div>

						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Reason</label>
							<div class="col-sm-10">
								<form:textarea path="reason" class="form-control"
									maxlength="200" rows="3" /> <br>

								<form:errors path="reason" style = "color:red;"/>
							</div>

						</div>
						<div hidden="" class="form-group row">
							<label class="col-sm-2 col-form-label">Date</label>
							<div class="col-sm-10">
								<form:input path="date" />
							</div>
						</div>
					</div>
					<!-- /.card-body -->

					<div class="card-footer">
						<button type="submit" class="btn btn-primary">Insert</button>
						<a href="record/listRecord" class="btn btn-danger">List Record</a>
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