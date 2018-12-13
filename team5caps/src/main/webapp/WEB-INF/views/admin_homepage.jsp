<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Homepage</title>
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
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

<script>
window.onload = function () {

	var name
	var value
	var
	
var chart = new CanvasJS.Chart("chartContainer", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Popularity of Courses"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: true,
		toolTipContent: "{name}: <strong>{y}%</strong>",
		indexLabel: "{name} - {y}%",
		dataPoints: [
				
			{ y: 100, name: "School Aid", exploded: true },
			{ y: 20, name: "Medical Aid" },
			{ y: 5, name: "Debt/Capital" },
			{ y: 3, name: "Elected Officials" },
			{ y: 7, name: "University" },
			{ y: 17, name: "Executive" },
			{ y: 22, name: "Other Local Assistance"}
			
		]
	}]
});
chart.render();
}

function explodePie (e) {
	if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
	} else {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
	}
	e.chart.render();

}
</script>

</head>
<body>
	<div class="container">
<h1>Admin Homepage</h1>
---
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<p>--------------------------------------------empty
<a href="${pageContext.request.contextPath}/admin/manage/courses">Show all courses</a>
<a href="${pageContext.request.contextPath}/admin/manage/approval">Show approval</a>
</br>
</br>
</br>
</br>	
</br>

</br>
</br></br>
</br>
</br>
</br>
</br>
container-----------------------------------
</p>

	<h3>Students not enrolled</h3>
	</br>

	
		<table id="pagination" class="table table-striped">
			<caption>List of students yet enrolled to a course: </caption>
			<thead>
				<tr>
					<td>#</td>
					<td>Student ID</td>
					<td>Student Name</td>
					<td>Email</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listNotEnrolled}" var="student"
					varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${student.studentID}</td>
						<td>${student.user.firstName} ${student.user.lastName}</td>
						<td>${student.user.emailAddress}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		</br>
					<div style="direction: rtl;"><form:form method="GET" modelAttribute="email"
								action="${pageContext.request.contextPath}/admin/sendHtmlEmailReminder">
								<input type="submit" name="email" value="Remind All"
									class="button" />
							</form:form></div>
	</div>
	<br>
</body>
</html>