<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TimeTable</title>
</head>
<body>

<table >
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
			<c:forEach var="morcourse" items="${morcoursetime}" varStatus="status"> 
                         <td>${morcourse.value}</td>                     
            </c:forEach>
               </tr>
                <tr>
			  <th>14:00-5:30</th>
			<c:forEach var="aftcourse" items="${aftcoursetime}" varStatus="status"> 
                         <td>${aftcourse.value}</td>                     
            </c:forEach>
               </tr>
                <tr>
			  <th>18:00-21:30</th>
			<c:forEach var="evecourse" items="${evecoursetime}" varStatus="status"> 
                         <td>${evecourse.value}</td>                     
            </c:forEach>
               </tr>      
	</table>

</body>
</html>