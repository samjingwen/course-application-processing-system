<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<c:url value="/css/bootstrap.css" var="ss" />
<link rel="STYLESHEET" type="text/css" href="${ss}" />

</head>
<body>
<h1>THIS IS REQUEST ENROLLMENT</h1>
<div>
<form:form modelAttribute="module" method="POST" cssClass="maingrid"
	action="${pageContext.request.contextPath}/sjw/request">
	<div>
	<table>
		<tr>
			<td>Module ID : </td>
			<td><form:input path="moduleID" size="40" /></td>
		</tr>
			
		
		<tr>
			
			<td><form:button name="submit" type="submit" value="s">
						Submit
					</form:button></td>
			<td><form:button name="clear" type="reset" value="r">
						Clear
					</form:button></td>
		</tr>
	</table>
	</div>
</form:form>
</div>
</body>
</html>