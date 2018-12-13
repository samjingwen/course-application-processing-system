<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<h1><center><u>ADD NEW STUDENT</u></center></h1>
<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/student/create">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				
				<tr>
				<td><s:message code="studentID" /> *</td>
				   <td><form:input path="studentID" name="SID" value="${SID}" readonly="true"/></td>
				 </tr>
			<tr>
				   <td><s:message code="FirstName" /> *</td>
				   <td><form:input path="user.firstName"/>
				   <form:errors path="user.firstName" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="LastName" /></td>
				   <td><form:input path="user.lastName"/>
				   <form:errors path="user.lastName" cssStyle="color: red;" /></td>
				 </tr>
				
				<tr>
				   <td><s:message code="EmailAddress" /></td>
				   <td><form:input path="user.emailAddress"/>
				   <form:errors path="user.emailAddress" cssStyle="color: red;" /></td>
				 </tr>
				<%-- <tr>
				   <td><s:message code="EnrollmentDate" /></td>
				   <td><form:input path="enrollmentDate"/>
				   <form:errors path="enrollmentDate" cssStyle="color: red;" /></td>
				 </tr> --%>
				<tr>
				   <td><s:message code="Status" /></td>
				   <td><form:input path="status"/>
				   <form:errors path="status" cssStyle="color: red;" /></td>
				 </tr>
				

				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
</html>