<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
<h1><center><u>ADD NEW COURSE</u></center></h1>
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/course/create.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				
				<tr>
				   <td><s:message code="CourseID" /> *</td>
				   <td><form:input path="courseID" />
				   <form:errors path="courseID" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="CourseName" /> *</td>
				   <td><form:input path="courseName"/>
				   <form:errors path="courseName" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="Description" /></td>
				   <td><form:input path="description"/>
				   <form:errors path="description" cssStyle="color: red;" /></td>
				 </tr>
				
				<tr>
				   <td><s:message code="MinVacancy" /></td>
				   <td><form:input path="minVacancy"/>
				   <form:errors path="minVacancy" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="MaxVacancy" /></td>
				   <td><form:input path="maxVacancy"/>
				   <form:errors path="maxVacancy" cssStyle="color: red;" /></td>
				 </tr>
				 <tr>
				   <td><s:message code="Credit" /></td>
				   <td><form:input path="credits"/>
				   <form:errors path="credits" cssStyle="color: red;" /></td>
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