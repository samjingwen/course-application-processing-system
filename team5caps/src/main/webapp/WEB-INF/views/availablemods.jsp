<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Available Modules</title>
</head>
<body>
	<table>
		<tr>
			<td>Academic Year</td>
			<td>Module ID</td>
			<td>Module Name</td>
			<td>Lecturer</td>
			<td>Day of Week</td>
			<td>Time Slot</td>
			<td>Venue</td>
		</tr>
		<c:forEach items="${modules}" var="modules" varStatus="index">
			<tr>
				<td>${modules.academicYear}</td>
				<td>${modules.moduleID}</td>
<%-- 				<td>${modules.coursedetail.courseName}</td> --%>
				<td>${users.firstName}</td>
				<td>${modules.dayofWeek}</td>
				<td>${modules.timeslot}</td>
				<td>${modules.venue}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>