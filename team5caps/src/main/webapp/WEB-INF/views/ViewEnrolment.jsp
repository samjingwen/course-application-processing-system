
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
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
    <c:forEach var="module" items="${modules}">
     <option>${module.module.moduleID}</option>
    </c:forEach>
</select> --%>
	<table id="Enrolment" class="table table-stripeds">
		<thead>
			<tr>
				<td align="center">No</td>
				<td align="center">Module ID</td>
				<td align="center">Course Name</td>
				<td align="center">Student ID</td>
				<td align="center">Student Name</td>
				<td align="center">Enrolment Status</td>
			</tr>
		</thead>
		<h1>${module.module.moduleID}</h1>
		<tbody>
			<c:forEach items="${modules}" var="module" varStatus="index">
				<tr>
					<td align="center">${index.index+1}</td>
					<td align="center">${module.module.coursedetail.courseName}</td>
					<td align="center">${module.student.studentID}</td>
					<td align="center">${module.student.user.firstName}
						${module.student.user.lastName}</td>
					<td align="center">${module.enrollStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>