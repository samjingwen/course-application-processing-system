<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
</head>

<body>
<select name="moduleID" id="moduleId">
    <c:forEach var="module" items="${modules}">
     <option>${module.module.moduleID}</option>
    </c:forEach>
</select>
	<table id="Enrolment" class="table table-stripeds">
		<tr>
			<td>No</td> 
			<td>Module ID</td> 
			<td>Course Name</td> 
			<td>Student ID</td> 
			<td>Student Name</td> 
			<td>Enrolment Status</td> 
		</tr>
		<c:forEach items="${modules}" var="module" varStatus="index">
			<tr>
				<td>${index.index+1}</td>
				<td>${module.module.moduleID}</td>
				<td>${module.module.coursedetail.courseName}</td>
				<td>${module.student.studentID}</td>
				<td>${module.student.user.firstName}
					${module.student.user.lastName}</td>
				<td>${module.enrollStatus}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>