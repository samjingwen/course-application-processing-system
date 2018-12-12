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
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<c:if test="${not empty sessionScope.USERSESSION}">

						<c:choose>
							<c:when
								test="${sessionScope.USERSESSION.user.accessLevel eq 'Administrator' }">

								<li><a href="#">Admin Btn1</a></li>
								<li><a href="#">Admin Btn2</a></li>
								<li><a href="#">Admin Btn3</a></li>


							</c:when>
						</c:choose>
					</c:if>







				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Welcome
							${sessionScope.USERSESSION.user.accessLevel}
							${sessionScope.USERSESSION.user.firstName }</a></li>
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

