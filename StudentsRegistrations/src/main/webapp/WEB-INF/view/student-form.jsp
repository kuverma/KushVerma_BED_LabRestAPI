<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student details</title>
</head>

<body>

	<div class="container">
		<c:if test="${action=='add'}">
			<h3>Add Student Details</h3>
		</c:if>
		<c:if test="${action=='update'}">
			<h3>Update Student Details</h3>
		</c:if>
		<h3>Student Directory</h3>
		<hr>


		<form action="/StudentRegistrations/student/saveStudent" method="POST">

			<c:if test="${action=='add'}">
				<!-- Add hidden form field to handle update -->
				<input type="hidden" name="id" value="${student.studentId}">
				<input type="hidden" name="action" value="add">
			</c:if>
			<c:if test="${action=='update'}">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="id" value="${id}">
			</c:if>

			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>
			<div class="form-inline">

				<input type="text" name="lastName" value="${student.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			<div class="form-inline">
				<input type="text" name="course" value="${student.course}"
					class="form-control mb-4 col-4" placeholder="Course">
			</div>
			<div class="form-inline">
				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="/StudentRegistrations/student/list">Back to Students List</a>
	</div>
</body>

</html>










