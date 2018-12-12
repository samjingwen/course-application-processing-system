<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:url value="/css/style.css" var="ss2"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss2}" />
</head>
<body>
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
</body>
</html>