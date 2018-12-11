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
<div>
<form:form modelAttribute="user" method="POST" cssClass="maingrid"
	action="${pageContext.request.contextPath}/home/authenticate">
	<div>
	<table>
		<tr>
			<td><spring:message code="fieldLabel.username" /></td>
			<td><form:input path="userID" size="40" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.password" /></td>
			<td><form:password path="password" size="40" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
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