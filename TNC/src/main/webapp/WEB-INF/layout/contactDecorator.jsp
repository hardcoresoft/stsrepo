<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.css" />" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.js" />" ></script>
	
	<sitemesh:write property='head' />
</head>

<body>
	This is the decorator body in contact:
	<sitemesh:write property='body' />
</body>
</html>