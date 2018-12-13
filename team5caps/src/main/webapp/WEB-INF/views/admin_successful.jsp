<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<META charset="ISO-8859-1" http-equiv="refresh" content="5;URL=http://localhost:8080/team5caps/admin/homepage#">
<title>Operation Successful</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	
  <link rel="stylesheet" href="css/popup.css">
<script src="js/popup.js"></script>
</head>

<body>
<div style="line-height:4200%;">

<div class="moving-zone">
    <div class="popup">
        <div class="popup-content">
            <div class="popup-text">
<h1 align=center>Operation successful</h1>
	<center>You will be redirected to the homepage automatically in 5 seconds. </center>
		<center><a href="${pageContext.request.contextPath}/admin/homepage">Click here if to return if your browser does not redirect.</a></center> 
            </div>
        </div>
    </div>
</div>
    <br>
</div>
</body>
</html>