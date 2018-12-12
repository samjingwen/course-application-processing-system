<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
</head>

<body>
	<table id="Enrolment" class="table table-stripeds" >
		<tr>
			<td>No</td><&nbsp>
			<td>Module ID</td><&nbsp>
			<td>Course Name</td><&nbsp>
			<td>Student ID</td><&nbsp>
			<td>Student Name</td><&nbsp>
			<td>Enrolment Status</td><&nbsp>
		</tr>
		<c:forEach items="${modules}" var="module" varStatus="index">
			<tr>
				<td>${index.index+1}</td>
				<td>${module.module.moduleID}</td>>
				<td>${module.module.coursedetail.courseName}</td>>
				<td>${module.student.studentID}</td>>
				<td>${module.student.user.firstName} ${module.student.user.lastName}</td>>
				<td>${module.enrollStatus}</td>
			
			</tr>
		</c:forEach>
	</table>
</body>
</html>