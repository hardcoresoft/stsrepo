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
	<link href="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.structure.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.theme.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/dataTable/dataTables.jqueryui.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/boon.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui/1.11.1/jquery-ui.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery/dateTimePicker/jquery.datetimepicker.js" />" ></script>
	<script src="<c:url value="/resources/js/dataTable/jquery.dataTables.min.js" />" ></script>
	<script src="<c:url value="/resources/js/dataTable/dataTables.jqueryui.js" />" ></script>
	<script src="<c:url value="/resources/js/utils/common.js" />" ></script>
	
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
				<div class="login-info" align="right" style="color:white; padding-right: 15px; padding-top: 8px" >
					 
					<c:if test="${SPRING_SECURITY_CONTEXT ne null}">
<%-- 					You are logged in as: <sec:authentication property="principal.username"/><br/>	 --%>

						ยินดีต้อนรับ คุณ<sec:authentication property="principal.firstName"/>
						&nbsp;<sec:authentication property="principal.lastName"/>&nbsp;( <sec:authentication property="principal.username"/> )<br/>
						<sec:authentication property="principal.lastLogin" var="lastLogin" scope="session"/>
						เข้าสู่ระบบครั้งสุดท้ายเมื่อ <fmt:formatDate value="${lastLogin}" pattern="dd/MM/yyyy HH:mm:ss"/><br/>
						<c:url var="logoutUrl" value="/logout" />
 						( <a style="color:white; text-decoration:none;  " href="${logoutUrl}">ออกจากระบบ</a> )
					</c:if>
					
					<%--  
					<c:if test="${SPRING_SECURITY_CONTEXT eq null}">
						<c:url var="loginUrl" value="/login" />
						(<a href="${loginUrl}">Login</a>)
					</c:if>
					--%>
					
				</div>
			</div>
	
			<div id="content">
				<sitemesh:write property='body' />
				<div style="clear:both"></div>
			</div>
	</div>
</body>
</html>