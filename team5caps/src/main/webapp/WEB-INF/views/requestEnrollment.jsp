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
	<div class="container">
	<h1>THIS IS REQUEST ENROLLMENT</h1>
	<div>
		<form:form modelAttribute="request" method="POST" cssClass="maingrid"
			action="${pageContext.request.contextPath}/lecturer/request">
			<div>
				<table>
					<tr>
						<td>Module ID :</td>
						<td>
							<form:select name="mList" path="moduleID" >
								<c:forEach items="${modules}" var="mid">
									<option value="${mid}"><c:out value="${mid}" /></option>
								</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Student ID:</td>
						<td><form:input path="studentID" size="40" /></td>
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
	</div>
</body>
</html>