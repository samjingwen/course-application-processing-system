<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">SJW</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/home/aboutus">About Us</a></li>
					<c:if test="${not empty sessionScope.USERSESSION}">
						<c:choose>
							<c:when
								test="${sessionScope.USERSESSION.user.accessLevel eq 'Administrator' }">
								<li><a href="${pageContext.request.contextPath}/admin/homepage">Dash board</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/manage/courselist">Manage Courses</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/manage/approval">Manage Request Approval</a></li>
							</c:when>
							<c:when
								test="${sessionScope.USERSESSION.user.accessLevel eq 'Lecturer' }">
								<li><a
									href="${pageContext.request.contextPath}/lecturer/request">Request Enrollment</a></li>
								<li><a href="${pageContext.request.contextPath}/lecturer/courselist">View Course History</a></li>
								<li><a href="${pageContext.request.contextPath}/grade/gradebook">Grade</a></li>
							</c:when>
							<c:when
								test="${sessionScope.USERSESSION.user.accessLevel eq 'Student' }">
								<li><a href="${pageContext.request.contextPath}/Timetable">Timetable</a></li>
								<li><a
									href="${pageContext.request.contextPath}/studentenroll/modules">View
										Available Modules</a></li>
								<li><a
									href="${pageContext.request.contextPath}/studentenroll/currenroll">Current
										Enrollment</a></li>
								<li><a
									href="${pageContext.request.contextPath}/studentGrade/">View
										GPA</a></li>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${empty sessionScope.USERSESSION }">
						<%-- <li><a href="#">Anon Btn1</a></li>
						<li><a href="#">Anon Btn2</a></li>
						<li><a href="#">Anon Btn3</a></li> --%>

					</c:if>


				</ul>


				<ul class="nav navbar-nav navbar-right">
					<c:if test="${empty sessionScope.USERSESSION }">
						<li><a href="${pageContext.request.contextPath}/home/login">Login</a>
					</c:if>

					<c:if test="${not empty sessionScope.USERSESSION }">
						<li><a href="#">Welcome
								${sessionScope.USERSESSION.user.accessLevel}
								${sessionScope.USERSESSION.user.firstName }</a></li>
						<li><a href="${pageContext.request.contextPath}/home/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
</div>

