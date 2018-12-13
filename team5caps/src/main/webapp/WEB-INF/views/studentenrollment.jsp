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
		$('#CurrMods').DataTable();
	})
</script>

<title>Current Modules</title>
</head>
<body>
	<div class="container">
	<form:form method="GET" modelAttribute="curr"
		action="${pageContext.request.contextPath}/studentenroll/curr">
	<div name="currm">
		<table id="CurrMods" class="display">
			<caption>Current Enrollment:</caption>
			<thead>
				<tr>
					<td><b>Academic Year</b></td>
					<td><b>Module ID</b></td>
					<td><b>Module Name</b></td>
					<td><b>Lecturer</b></td>
					<td><b>Day of Week</b></td>
					<td><b>Time Slot</b></td>
					<td><b>Venue</b></td>
					<td><b>Grade</b></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sclist}" var="sclist" varStatus="index">
					<tr>
						<td>${sclist.getYear()}</td>
						<td>${sclist.moduleID}</td>
						<td>${sclist.moduleName}</td>
						<td>${sclist.module.lecturer.user.firstName}
							${sclist.module.lecturer.user.lastName}</td>
						<td>${sclist.getDay()}</td>
						<td>${sclist.getTime()}</td>
						<td>${sclist.venue}</td>
						<td>${sclist.grade}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form:form>
	</div>
</body>

</html>