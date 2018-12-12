<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is user edit page</h1>
  <form:form action="${pageContext.request.contextPath}/user/edit.html" method="POST" modelAttribute="user">
    ID: <form:input path="id" size="10" readonly="true"/> <br/>
    OLD PASSWORD: <form:input path="oldpassword" size="40"/> <br/>
    NEW PASSWORD: <form:input path="newpassword" size="40"/> <br/>
    CONFIRM PASSWORD: <form:input path="confirmation" size="40"/> <br/>
    <input type="submit" value ="Submit"/> <br/>
    <input type="reset" value ="Cancel"/> <br/>
  </form:form>
</body>
</html>