<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request New Student</title>
</head>
<body>
	<div class="container">
<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/student/create.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="label.student.name" /> *</td>
				   <td><form:input path="name"/>
				   <form:errors path="name" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.nickName" /></td>
				   <td><form:input path="nickName"/>
				   <form:errors path="nickName" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.nric" /> *</td>
				   <td><form:input path="nric"/>
				   <form:errors path="nric" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.mark" /></td>
				   <td><form:input path="mark"/>
				   <form:errors path="mark" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.dob" /></td>
				   <td><form:input path="dob"/>
				   <form:errors path="dob" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.phoneNumber" /></td>
				   <td><form:input path="phoneNumber"/>
				   <form:errors path="phoneNumber" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.email" /></td>
				   <td><form:input path="email"/>
				   <form:errors path="email" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.address" /></td>
				   <td><form:input path="address"/>
				   <form:errors path="address" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.userName" /></td>
				   <td><form:input path="userName"/>
				   <form:errors path="userName" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.password" /></td>
				   <td><form:input path="password"/>
				   <form:errors path="password" cssStyle="color: red;" /></td>
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