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
	<h1>Student List</h1>
	<%-- <form:form modelAttribute="user" method="POST" cssClass="maingrid"
	action="${pageContext.request.contextPath}/student/create"> --%>
	<a href="${pageContext.request.contextPath}/admin/student/create">Add Student</a>
	<table id="example" class="display">

		<thead>
			<tr>
				<th>#</th>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Enrollment Date</th>
				<th>Status</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stu" varStatus="s" items="${sList}">

				<tr>
					<td>${s.index+1}</td>
					<td>${stu.getStudentID()}</td>
					<td>${stu.getUser().getFirstName()}</td>
					<td>${stu.getUser().getLastName()}</td>
					<td>${stu.getUser().getEmailAddress()}</td>
					<td>${stu.getEnrollmentDate()}</td>
					<td>${stu.getStatus()}</td>
					<td align="center"><a
					href="${pageContext.request.contextPath}/admin/student/edit/${stu.getStudentID()}">
					Edit
				</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- </form:form> --%>
	</div>
</body>
</html>