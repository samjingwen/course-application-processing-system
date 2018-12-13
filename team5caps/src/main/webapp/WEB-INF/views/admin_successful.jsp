<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<META charset="ISO-8859-1" http-equiv="refresh" content="5;URL=http://www.javaranch.com">
<title>Operation Successful</title>
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<h1 align=center>Operation successful</h1>
	<center bgcolor="#ffffff">You will be redirected to the homepage automatically in 5 seconds. </center>
		<center style="color:red;"><a href="${pageContext.request.contextPath}/admin/homepage">Click here if to return if your browser does not redirect.</a></center> 
</body>
</html>