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
	<h1>Lecturers List</h1>
	<table id="example" class="display">

		<thead>
			<tr>
				<th>#</th>
				<th>Lecturer ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Position</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lec" varStatus="s" items="${sList}">

				<tr>
					<td>${s.index+1}</td>
					<td>${lec.getLecturerID()}</td>
					<td>${lec.getUser().getFirstName()}</td>
					<td>${lec.getUser().getLastName()}</td>
					<td>${lec.getUser().getEmailAddress()}</td>
					<td>${lec.getPosition()}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>