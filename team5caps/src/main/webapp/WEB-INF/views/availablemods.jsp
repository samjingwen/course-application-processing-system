<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<c:forEach items="${modules}" var="module" varStatus="index">
			<tr>
				<td>${module.academicyear}</td>
				<td>${module.moduleID}</td>
				<td>${module.coursedetail.courseName}</td>
				<td>${module.lecturer.users.firstName}</td>
				<td>${module.dayofWeek}</td>
				<td>${module.timeslot}</td>
				<td>${module.venue}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>