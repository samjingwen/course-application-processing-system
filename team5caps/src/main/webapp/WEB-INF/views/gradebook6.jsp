<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form name="selectoneww" method="POST" modelAttribute="module"
		action="${pageContext.request.contextPath}/grade/gradebook/exact">
		<form:select name="selectone" path="moduleID">
			<c:forEach var="cl" items="${courselist}">
				<option value="${cl.value.getModuleID()}">${cl.key}</option>
			</c:forEach>
		</form:select>
		<input type='submit' name=submit value='Search' />

	</form:form>
</body>
</html>