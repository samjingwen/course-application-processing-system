<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">




<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {
		$('#pagination').DataTable();
	})
</script>






<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student List</h1>
	<table id="pagination" class="display">

		<thead>
			<tr>
				<th>#</th>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Description</th>
				<th>MinVacancy</th>
				<th>MaxVacancy</th>
				<th>Credits</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cd" varStatus="s" items="${cdList}">

				<tr>
					<td>${s.index+1}</td>
					<td>${cd.getCourseID()}</td>
					<td>${cd.getCourseName()}</td>
					<td>${cd.getDescription()}</td>
					<td>${cd.getMinVacancy()}</td>
					<td>${cd.getMaxVacancy()}</td>
					<td>${cd.getCredits()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<select name="mList">
		<c:forEach items="${modules}" var="mid">
			<option value="${mid}"><c:out value="${mid}" /></option>
		</c:forEach>
	</select>

</body>
</html>