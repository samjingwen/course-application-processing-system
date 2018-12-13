
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {
		$('#Enrolment').DataTable();
	})
</script>
<title>Enrolment Status</title>
</head>

<body>
<%-- <select name="moduleID" id="moduleId">
    <c:forEach var="module" items="${modulesdrop}">
     <option>${module.moduleID}</option>
    </c:forEach>
</select> --%>
	<div class="container">
	<table id="Enrolment" class="table table-stripeds">
		<thead>
			<tr>
				<td align="center">No</td>
				<td align="center">Student ID</td>
				<td align="center">Student Name</td>
				<td align="center">Enrolment Status</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${modules}" var="module" varStatus="index">
				<tr>
					<td align="center">${index.index+1}</td>
					<td align="center">${module.student.studentID}</td>
					<td align="center">${module.student.user.firstName}
						${module.student.user.lastName}</td>
					<td align="center">${module.enrollStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>