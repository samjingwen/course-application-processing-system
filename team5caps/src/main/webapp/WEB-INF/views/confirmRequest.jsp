<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Show Student</title>
</head>
<body>
	<div class="container">
	<form:form modelAttribute="request" method="POST" action="${pageContext.request.contextPath}/lecturer/confirm/${newRequest.getModuleID()}">
		<table>
		<tr>
				<td>Student ID :</td>
				<td>${newRequest.getStudentID() }</td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td>${newRequest.getStudentName() }</td>
			</tr>
			<tr>
				<td>Module ID :</td>
				<td>${newRequest.getModuleID() }</td>
			</tr>
			<tr>
				<td>Course Name :</td>
				<td>${newRequest.getCourseName() }</td>
			</tr>
			
			<tr>
				<td>Lecturer Name :</td>
				<td>${newRequest.getLecturerName() }</td>
			</tr>
			<tr>
				<td>Venue :</td>
				<td>${newRequest.getVenue() }</td>
			</tr>
			<tr>

				<td><form:button name="submit" type="submit" value="s">
						Confirm
					</form:button></td>
				<td><a href="javascript:history.back()" title="Back to site"
				class="error-back">Back</a></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>