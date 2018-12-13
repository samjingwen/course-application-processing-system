<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<c:url value="/css/bootstrap.css" var="ss" />
<link rel="STYLESHEET" type="text/css" href="${ss}" />
<decorator:head />
</head>
<body>

<div class="grid-container">
  <div class="headergrid"><%@include file="Header.jsp"%></div>
 
  <div class="menugrid"><%--<%@ include file="Menu.jsp"%>--%></div>
  <div class="maingrid"><decorator:body /></div>  
  <div class="footergrid"><%@ include file="Footer.jsp"%></div>
</div>



</body>
</html>