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
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
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

	<h1>Request for modules approval</h1>
	<div class="container">
		<table id="pagination" class="table table-striped">
			<caption>List of students</caption>
			<thead>
				<tr>
					<td>#</td>
					<td>Module ID</td>
					<td>Student Name</td>
					<td>Enroll Status</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentcourse}" var="current" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${current.module.moduleID}</td>
						<td>${current.student.user.lastName} ${current.student.user.firstName}</td>
						<td>${current.enrollStatus}</td>
						<td><form:form method="Post" modelAttribute="approve" action="${pageContext.request.contextPath}/admin/manage/approval/${current.module.moduleID}/${current.student.studentID}">
								<input type="submit" name="act" class="button"
									value="Approve" />
							</form:form>
							<form:form method="Post" modelAttribute="reject" action="${pageContext.request.contextPath}/admin/manage/approval/${current.module.moduleID}/${current.student.studentID}">
								<input type="submit" name="act" class="button"
									value="Reject" />
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