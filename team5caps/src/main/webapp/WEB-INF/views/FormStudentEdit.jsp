<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="container">
<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/admin/student/edit/${student.studentID}">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="StudentID" /> * </td>
				   <td><form:input path="studentID" readonly="true" disable="true"/></td>
				 </tr>
				<tr>
				   <td><s:message code="FirstName" /></td>
				   <td><form:input path="user.firstName"/></td>
				 </tr>
				
				<tr>
				   <td><s:message code="LastName" /></td>
				   <td><form:input path="user.LastName"/></td>
				 </tr>
				 
				<tr>
				   <td><s:message code="EmailAddress" /></td>
				   <td><form:input path="user.emailAddress"/></td>
				 </tr>
				<%-- <tr>
				   <td><s:message code="EnrollmentDate" /></td>
				   <td><form:input path="enrollmentDate"/></td>
				 </tr> --%>
				<tr>
				   <td><s:message code="Status" /></td>
				   <td><form:input path="status"/></td>
				 </tr>
				
				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
	</div>
</body>
</html>