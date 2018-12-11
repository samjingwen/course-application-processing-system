<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border = "3">
<tr>
<td>#</td>
<td>Course Name</td>
<td>Grade</td>
</tr>
<c:forEach items = "${courseList}" var = "course" varStatus = "index">
<tr>
<td>${index.index+1}</td>
<td>${course.module.coursedetail.courseName}</td>
<td>${course.grade}</td>
</tr>
</c:forEach>
</table>
<h3>GPA: ${gpa}</h3>
</body>
</html>