<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
</head>

<body>
   <table>
     <tr>
       <td>#</td>
       <td>Course Detail</td>
       <td>Module ID</td>
     </tr>
     <c:forEach items="${modules}" var="module" varStatus="index">
         <tr>
       <td>${index.index+1}</td>
       <td>${module.coursedetail}</td>
       <td>${module.moduleID}</td>
     </tr>
     </c:forEach>
   </table>
</body>
</html>