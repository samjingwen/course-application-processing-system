<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
<h1><center><u>ADD NEW LECTURER</u></center></h1>
<form:form method="POST" modelAttribute="lecturer"
	action="${pageContext.request.contextPath}/admin/lecturer/create">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				
				<tr>
				   <td><s:message code="LecturerID"/> *</td>
				   <td><form:input path="lecturerID" value="${LID}" readonly="true" />
				   
				   <form:errors path="lecturerID" cssStyle="color: red;" /></td>
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
				<tr>
				   <td><s:message code="Position" /></td>
				   <td><form:input path="position"/>
				   <form:errors path="position" cssStyle="color: red;" /></td>
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