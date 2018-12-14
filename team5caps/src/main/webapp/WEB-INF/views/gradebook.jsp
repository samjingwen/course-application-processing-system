<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta charset="ISO-8859-1">
<title>Course Grade</title>
<c:url value="css/style.css" var="ss2" />
<link rel="STYLESHEET" type="text/css" href="${ss2}" />
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
	
		<form:form modelAttribute="module" method="POST"
			action="${pageContext.request.contextPath}/grade/gradebook/gradeconfirm">
			
			<table>
				<tr>
					<td><form:input type="text" readonly="readonly" value="${moduleID}"
					path="moduleID" class="form-control"/></td>

					<td><form:button type="submit" name="submit" value="s"
					class="btn btn-primary">SUBMIT</form:button></td>
				</tr>
			</table>
			
			<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Student ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Student Attendance</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${scList}" var="sc" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${sc.getStudent().getStudentID()}</td>
						<td>${sc.student.user.firstName}</td>
						<td>${sc.student.user.lastName}</td>
						<td>${sc.getAttendance()}</td>
						<td><select name="${sc.getStudent().getStudentID()}">
								<option value=" ">--</option>
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
								<option value="E">E</option>
								<option value="F">F</option>
						</select></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
		
		
			
	</form:form>
	</div>
</body>
</html>