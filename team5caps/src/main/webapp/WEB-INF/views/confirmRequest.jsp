<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="request" method="POST" action="${pageContext.request.contextPath}/sjw/confirm/${newRequest.getModuleID()}">
		<table>
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
				<td><form:button name="clear" type="reset" value="r" >
						Back
					</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>