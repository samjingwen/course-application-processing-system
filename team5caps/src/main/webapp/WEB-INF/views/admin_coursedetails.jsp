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
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 
	pagination script here -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {
		$('#pagination').DataTable();
	})
</script>
</head>
<body>

	<h1>Course details</h1>
	<div class="container">
		<table id="pagination" class="table table-striped">
			<caption>Students currently enrolled</caption>
			<thead>
				<tr>
					<td>#</td>
					<td>Module ID</td>
					<td>Student Name</td>
					<td>Attendance</td>
					<td>Enroll Time</td>
					<td>Drop action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentcourse}" var="current" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${current.module.moduleID}</td>
						<td>${current.student.user.lastName}
							${current.student.user.firstName}</td>
						<td>${current.attendance*100}%</td>
						<td>${current.enrollTime}</td>
						<td><form:form method="GET" modelAttribute="drop" action="${pageContext.request.contextPath}/admin/manage/courses/${current.module.moduleID}/${current.student.studentID}">
								<input type="submit" name="delete" class="button"
									value="Drop Student" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
</body>
</html>