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
	<div name="availm">
		<table id="AvailMods" class="table table-stripeds">
			<caption>List of available modules:</caption>
			<br>
			<thread>
			<tr>
				<td><b>Academic Year</b></td>
				<td><b>Module ID</b></td>
				<td><b>Module Name</b></td>
				<td><b>Lecturer</b></td>
				<td><b>Day of Week</b></td>
				<td><b>Time Slot</b></td>
				<td><b>Venue</b></td>
			</tr>
			</thread>
			<tbody>
				<c:forEach items="${formattedmodules}" var="formattedmodules" varStatus="index">
				
					<tr>
						<td>${formattedmodules.academicYear}</td>
						<td>${formattedmodules.moduleID}</td>
						<td>${formattedmodules.coursedetail.courseName}</td>
						<td>${formattedmodules.lecturer.user.firstName}
							${formattedmodules.lecturer.user.lastName}</td>
						<td>${formattedmodules.getDay()}</td>
						<td>${formattedmodules.getTime()}</td>
						<td>${formattedmodules.venue}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>