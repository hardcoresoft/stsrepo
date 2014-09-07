<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<%-- 	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script> --%>
<%-- 	<script src="<c:url value="/resources/js/main.js" />"></script> --%>
	<sitemesh:write property='head' />
</head>

<body>
	This is the decorator body in contact:
	<sitemesh:write property='body' />
</body>
</html>