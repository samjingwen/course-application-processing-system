<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="container">
<h1>THIS IS NEW STUDENT PAGE</h1>
<form:form method="POST" modelAttribute="newUser"
	action="${pageContext.request.contextPath}/lynn/newstudent">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				
				<tr>
				   <td><s:message code="fieldLabel.studentID" /> *</td>
				   <td><form:input path="userID"/>
				 </tr>
				<tr>
				   <td><s:message code="fieldLabel.firstName" /> *</td>
				   <td><form:input path="firstName"/>
				 </tr>
				<tr>
				   <td><s:message code="fieldLabel.lastName" /></td>
				   <td><form:input path="lastName"/>
				   <form:errors path="lastName" cssStyle="color: red;" /></td>
				 </tr>
				
				<tr>
				   <td><s:message code="fieldLabel.emailAddress" /></td>
				   <td><form:input path="emailAddress"/>
				   <form:errors path="emailAddress" cssStyle="color: red;" /></td>
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