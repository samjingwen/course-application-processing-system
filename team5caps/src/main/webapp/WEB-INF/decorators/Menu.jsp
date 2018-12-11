<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<c:if test="${not empty sessionScope.USERSESSION}">
		<c:choose>
			<c:when
				test="${sessionScope.USERSESSION.user.accessLevel eq 'Administrator' }">

				<div class="w3-sidebar w3-bar-block">
					<a href="#" class="w3-bar-item w3-button">Link 1</a> <a href="#"
						class="w3-bar-item w3-button">Link 2</a> <a href="#"
						class="w3-bar-item w3-button">Link 3</a>
				</div>

			</c:when>
			<c:when
				test="${sessionScope.USERSESSION.user.accessLevel eq 'Lecturer' }">
				<li><spring:url value="/manager/pending" var="pending"
						htmlEscape="true" /> <a href="${pending}"> <spring:message
							code="menu.coursesForApproval" />
				</a></li>
				<li><spring:url value="/manager/shistory" var="shistory"
						htmlEscape="true" /> <a href="${shistory}"> <spring:message
							code="menu.subordinateHistory" />
				</a></li>

			</c:when>
			<c:when
				test="${sessionScope.USERSESSION.user.accessLevel eq 'Student'}">
				<li><spring:url value="/staff/history" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.personalHistory" />
				</a></li>
				<li><spring:url value="/staff/course/create" var="apply"
						htmlEscape="true" /> <a href="${apply}"> <spring:message
							code="menu.courseSubmit" />
				</a></li>
				<li><spring:url value="/staff/logout" var="logout"
						htmlEscape="true" /> <a href="${logout}"> <spring:message
							code="menu.logout" />
				</a></li>

			</c:when>
		</c:choose>

	</c:if>

</div>