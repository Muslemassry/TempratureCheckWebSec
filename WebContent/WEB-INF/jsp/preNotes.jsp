<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="logout.html">Admin Page</a></li>
				</ul>
			</nav>
			
			

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<div class="box">
					<div class="content">

					<!-- Elements -->
						<h2 id="elements">View PreNotes <b>bold</b></h2>
						<div class="row 200%">
							<div class="11u 12u$(medium)">
								<!-- Text stuff -->
									<hr />
									
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>ID</th>
												    <th>From</th>
												    <th>To</th>
												    <th>Description</th>
												    <th>Edit</th>
												</tr>
											</thead>
											<tbody>
											
											<c:forEach items="${preNotes}" var="preNote">
										        <tr>
										            <td>${preNote.preTempNoteId}</td>
										            <td>${preNote.fromDegree}</td>
										            <td>${preNote.toDegree}</td>
										            <td>${preNote.perNoteDesc}</td>
										            <td><a href="/TempratureCheckWebSec/editPreNote.html?id=${preNote.preTempNoteId}">Edit PreNote!</a></td>
										        </tr>
										    </c:forEach>
											</tbody>
										</table>
										
										<hr />
										<ul class="actions">
											<li><a href="/TempratureCheckWebSec/login.html" class="button special">Admin Page</a></li>
										</ul>
									</div>
									
									
							</div>
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