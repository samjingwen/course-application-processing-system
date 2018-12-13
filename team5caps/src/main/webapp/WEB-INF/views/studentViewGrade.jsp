<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
<c:url value="/css/style.css" var="ss2"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss2}" />
</head>
<body>
	<div class="container">
<table>
<tr>
<th>#</th>
<th>Course Name</th>
<th>Grade</th>
</tr>
<c:forEach items = "${courseList}" var = "course" varStatus = "index">
<tr>
<td>${index.index+1}</td>
<td>${course.module.coursedetail.courseName}</td>
<td>${course.grade}</td>
</tr>
</c:forEach>
<tr ><td colspan="3" >GPA: ${gpa}</td></tr>
</table>
</div>
</body>
</html>