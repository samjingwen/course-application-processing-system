<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<c:url value="/css/bootstrap.css" var="ss" />
<link rel="STYLESHEET" type="text/css" href="${ss}" />

</head>
<body>
<div>
	<div class="container">
<form:form modelAttribute="user" method="POST" 
	action="${pageContext.request.contextPath}/home/authenticate">
	<div align="center">
	<table>
		<tr></tr>
		<tr>
			<td><spring:message code="fieldLabel.username" />&nbsp</td>
			<td colspan="2"><form:input path="userID" size="40" /></td>
		</tr>
		
		<tr>
			<td><spring:message code="fieldLabel.password" />&nbsp</td>
			<td colspan="2"><form:password path="password" size="40" /></td>
		</tr>
	
		<tr>
			<td>&nbsp;</td>
			<td><form:button name="submit" type="submit" value="s" cssClass="btn btn-default">
						Submit
					</form:button></td>
			<td><form:button name="clear" type="reset" value="r" cssClass="btn btn-default">
						Clear
					</form:button></td>
		</tr>
	</table>
	</div>
</form:form>
</div>
</div>
</body>
</html>