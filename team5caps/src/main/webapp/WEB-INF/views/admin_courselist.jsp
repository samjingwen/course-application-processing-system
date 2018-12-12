<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all courses</title>
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
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

	<h1>Courses</h1>
	<div class="container">
		<table id="pagination" class="table table-striped">
			<caption>Available Courses</caption>
			<thead>
				<tr>
					<td>#</td>
					<td>Course ID</td>
					<td>Course Name</td>
					<td>Capacity</td>
					<td>Credits</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listAllCourse}" var="course" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td><a
							href='${pageContext.request.contextPath}/admin/manage/courses/<c:out value="${course.courseID}"/>'>${course.courseID}</a></td>
						<td>${course.courseName}</td>
						<td>${enrolledCapacity.get(index.index)}/
							${course.maxVacancy}</td>
						<td>${course.credits}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
</body>
</html>