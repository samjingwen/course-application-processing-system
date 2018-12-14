<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all courses</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
</head>

<body>

	<h1>Student drop confirmation</h1>
	<div class="container">
		<table class="table table-striped">
			<caption>Are you sure you want to drop this student?</caption>
			<thead>
				<tr>
					<td>Course Name</td>
					<td>Module ID</td>
					<td>Student Name</td>
					<td>Student Status</td>
				</tr>
			</thead>
			<tbody>
				<td>${module.coursedetail.courseName}</td>
				<td>${module.moduleID}</td>
				<td>${student.user.lastName} ${student.user.firstName}</td>
				<td>${student.status}</td>
			</tbody>
		</table>
		<form:form method="POST" modelAttribute="enroll"
			action="${pageContext.request.contextPath}/admin/manage/courses/${module.moduleID}/${student.studentID}">
			<input type="submit" name="delete" value="Confirm" class="button" />
		</form:form>
		
		<form:form method="GET" modelAttribute="cancel"
			action="javascript:history.back()">
			<input type="submit" name="back" value="Cancel" class="button" />
		</form:form>
		
	</div>
	
	<br>
</body>
</html>