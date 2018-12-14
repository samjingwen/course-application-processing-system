<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Student ID is invalid or request already pending.
	<form:form method="GET" modelAttribute="drop"
		action="${pageContext.request.contextPath}/lecturer/request">
		<input type="submit" name="delete" class="button" value="Back" />
	</form:form>
</body>
</html>