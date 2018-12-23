<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<!--
	Transitive by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<spring:url value="/assets/css/main.css" var="customCSS" />
		<title>Transitive by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${customCSS}" />
	</head>
	<body>
<c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo"><a href="index.html">Transitive <span>by TEMPLATED</span></a></div>
				<a href="#menu" class="toggle"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="index.html">Home</a></li>
					<li><a href="/TempratureCheckWebSec/register.html">Register</a></li>
					<li><a href="elements.html">Elements</a></li>
				</ul>
			</nav>

		<!-- Banner -->
		<!--
			To use a video as your background, set data-video to the name of your video without
			its extension (eg. images/banner). Your video must be available in both .mp4 and .webm
			formats to work correctly.
		-->
			<section id="banner" data-video="images/banner">
				<div class="inner">
					<h1>Temperature System Check</h1>
					<p>Welcome to Temprature Check Demo<br />
					This System is used by Employees of <a href="index.html">WebCheck company</a></p>
					<a href="#footer" class="button special scrolly">Get Started</a>
				</div>
			</section>
			
		<!-- Footer -->
			<footer id="footer" class="wrapper">
				<div class="inner">
					<section>
						<div class="box">
							<div class="content">
								<h2 class="align-center">Log in</h2>
								<hr />
								<div class="field">
										${{message}}
								</div>
								<br>
								<form:form method ="POST" action ="/TempratureCheckWebSec/login">
									<div class="field">
										<form:label for="username" path="username">Username</form:label>
										<form:input id="username" type="text" placeholder="Username" path="username" ></form:input>
									</div>
									<div class="field">
										<form:label for="password" path="password">Password</form:label>
										<form:input id="password" type="password" placeholder="Password" path="password"></form:input>
									</div>
									<ul class="actions align-center">
										<li><input value="Login" class="button special" type="submit"></li>
									</ul>
								</form:form>
							</div>
						</div>
					</section>
					<div class="copyright">
						&copy; Web check : <a href="http://localhost:8080/TempratureCheckWebSec/">WebCheck System</a>.
					</div>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
	</body>
</html>