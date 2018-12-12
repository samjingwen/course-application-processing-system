<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {
		$('#AvailMods').DataTable();
	})
</script>

<title>Available Modules</title>
</head>
<form:form action="${pageContext.request.contextPath}/studentenroll/modules/{sid}" method="POST">
<body>


	<div name="availm">
		<table id="AvailMods" class="display">
			<caption>List of available modules:</caption>
			<br>
			<thead>
				<tr>
					<td><b>Academic Year</b></td>
					<td><b>Module ID</b></td>
					<td><b>Module Name</b></td>
					<td><b>Lecturer</b></td>
					<td><b>Day of Week</b></td>
					<td><b>Time Slot</b></td>
					<td><b>Venue</b></td>
					<td><b>Enroll</b></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${formattedmodules}" var="formattedmodules"
					varStatus="index">

					<tr>
						<td>${formattedmodules.getYear()}</td>
						<td>${formattedmodules.moduleID}</td>
						<td>${formattedmodules.coursedetail.courseName}</td>
						<td>${formattedmodules.lecturer.user.firstName}
							${formattedmodules.lecturer.user.lastName}</td>
						<td>${formattedmodules.getDay()}</td>
						<td>${formattedmodules.getTime()}</td>
						<td>${formattedmodules.venue}</td>
						<td align="center"><input type="checkbox" name="modid" value="${formattedmodules.moduleID}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<input type = "submit" name="Enroll" value="Enroll">
</body>
</form:form>
</html>