<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Course Grade</title>
<c:url value="/css/style.css" var="ss2"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss2}" />
</head>
<body>
<table>
  <tr colspan="6">
			<td><input type="submit" name="submit"
				value="SUBMIT" /></td>
		</tr>
		<tr>
			<th>#</th>
			<th>Student ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Student Attendance</th>
			<th>Grade</th>
		</tr>
		<c:forEach items="${scList}" var="sc" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${sc.getStudent().getStudentID()}</td>
				<td>${sc.student.user.firstName}</td>
				<td>${sc.student.user.lastName}</td>
				<td>${sc.getAttendance()}</td>
				<td>

						<select name="clr">
							<option>A</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
						</select> 

				</td>

			</tr>
		</c:forEach>
		
		
		
</table>
	
</body>
</html>