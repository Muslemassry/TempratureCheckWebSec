<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<title>Elements - Transitive by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${customCSS}" />
	</head>
	<body class="subpage">

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="index.html">Transitive <span>by TEMPLATED</span></a></div>
				<a href="#menu" class="toggle"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="login.html">Home</a></li>
					<li><a href="logout.html">Logout</a></li>
				</ul>
			</nav>
			
			

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<div class="box">
					<div class="content">

					<!-- Elements -->
						<h2 id="elements">Add Today's Note</h2>
						<h3>${message}</h3>
						<div class="row 200%">
						<form:form method ="POST" action ="/TempratureCheckWebSec/addNote.html" class="11u 12u$(medium)">
							<div >
								<!-- Text stuff -->
									<hr />
									<blockquote>
									Today is <b>DATE</b> with Degree <b>DEGREE</b>
									<br/> 
									<br/>
									
									
									<div class="field">
										<form:label for="noteDesc" path="noteDesc">Description</form:label>
										<form:input id="noteDesc" type="text" placeholder="Description" path="noteDesc"></form:input>
									</div>
									<ul class="actions align-left">
										<li><input value="Save" class="button special" type="submit"></li>
									</ul>
									</blockquote>
							</div>
							</form:form>
						</div>
						</div>
					</div>
				</div>
			</section>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
	</body>
</html>