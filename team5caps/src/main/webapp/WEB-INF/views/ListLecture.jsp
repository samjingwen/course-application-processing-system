<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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
	<h1>Lecturer List</h1>
		<a href="${pageContext.request.contextPath}/lecturer/create">Add LECTURER</a>
	<table id="example" class="display">
		

		<thead>
			<tr>
				<th>#</th>
				<th>Lecturer ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Position</th>
				<th>Edit</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lec" varStatus="s" items="${lList}">

				<tr>
					<td>${s.index+1}</td>
					<td>${lec.getLecturerID()}</td>
					<td>${lec.getUser().getFirstName()}</td>
					<td>${lec.getUser().getLastName()}</td>
					<td>${lec.getUser().getEmailAddress()}</td>
					<td>${lec.getPosition()}</td>
					<td align="center"><a
					href="${pageContext.request.contextPath}/lecturer/edit/${lec.getLecturerID()}">
						Edit
				</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>