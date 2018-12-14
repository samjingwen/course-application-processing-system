<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		$('#CurrMods').DataTable();
	})
</script>

<title>Current Modules</title>
</head>
<body>
	<div class="container">
	<form:form method="POST" modelAttribute="currenroll" cssClass="maingrid"
		action="${pageContext.request.contextPath}/studentenroll/currenroll">
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
					<td><b>Lecturer Rating</b></td>
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
						<td align = "center"><select name = "LRate">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
						<option value = "5">5</option>
						</select></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type ="submit" name="subLectRate" value = "Rate Lecturers"> 
	</div>
	</form:form>
	</div>
</body>

</html>