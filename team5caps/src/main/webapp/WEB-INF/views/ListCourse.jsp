<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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
		$('#example').DataTable();
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1>
		<b>Course List</b>
	</h1>
	<form:form modelAttribute="course" method="POST" cssClass="maingrid"
		action="${pageContext.request.contextPath}/admin/courses/create">
		<a href="${pageContext.request.contextPath}/admin/courses/create">ADD
			COURSE</a>

		<table id="example" class="display">

			<thead>

				<tr>
					<th>#</th>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Description</th>
					<th>Min Vacancy</th>
					<th>Max Vacancy</th>
					<th>Credits</th>
					<th>Edit</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" varStatus="s" items="${cList}">

					<tr>
						<td>${s.index+1}</td>
						<td>${course.getCourseID()}</td>
						<td>${course.getCourseName()}</td>
						<td>${course.getDescription()}</td>
						<td>${course.getMinVacancy()}</td>
						<td>${course.getMaxVacancy()}</td>
						<td>${course.getCredits()}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/courses/edit/${course.getCourseID()}">
								Edit </a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</form:form>
	</div>
</body>
</html>