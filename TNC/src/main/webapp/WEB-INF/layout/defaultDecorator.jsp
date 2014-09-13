<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	
	<link href="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/boon.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.js" />" ></script>
	
	<sitemesh:write property='head' />
</head>

<body>
	<img class="vegas-background" src="<c:url value="/resources/images/bg-main.jpg" />" style="position: fixed; left: 0px; top: -483px; width: 1349px; height: 1243px; bottom: auto; right: auto;z-index: -1">
	<div id="main" class="home">
	
			<!-- Head Begin -->
			<div class="nav-group-main">
				<div class="brand">
					<a class="logo-mini" href="#"></a>
				</div>
			</div>
	
			<div id="content">
				<sitemesh:write property='body' />
				<div style="clear:both"></div>
			</div>
	</div>
</body>
</html>