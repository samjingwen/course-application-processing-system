<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>TimeTable</title>
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	<style>
	table {
    table-layout: fixed;
    word-break:break-all; 
}
    caption{text-align:center;
      font-size:50px;
    }
	</style>
</head>
<body>
	<div class="container">
		 <table class="table table-bordered">  
			<caption>TimeTable</caption>
			<tr>
				<th>Time/Weekday</th>
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
			</tr>
			<tr>
				<th>9:00-11:30</th>
				<c:forEach var="morcourse" items="${morcoursetime}"
					varStatus="status">
					<td bgcolor='${morcourse.value ==" "?"":"#ABC1D1"}'>${morcourse.value}</td>
				</c:forEach>
			</tr>
			<tr>
				<th>14:00-5:30</th>
				<c:forEach var="aftcourse" items="${aftcoursetime}"
					varStatus="status">
					<td bgcolor='${aftcourse.value ==" "?"":"#ABC1D1"}'>${aftcourse.value}</td>
				</c:forEach>
			</tr>
			<tr>
				<th>18:00-21:30</th>
				<c:forEach var="evecourse" items="${evecoursetime}"
					varStatus="status">
					<td bgcolor='${evecourse.value ==" "?"":"#ABC1D1"}'>${evecourse.value}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	
</body>
</html>