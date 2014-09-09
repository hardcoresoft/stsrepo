<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script src="<c:url value="/resources/js/utils/common.js" />"></script>
		
		<title>Add Movie</title>
		
		<script type="text/javascript">
			$( document ).ready(function() {

				$("#releasedDate").datepicker( pickerOpts );

				$("#expirationDate").datepicker( pickerOpts );
				
// 				$("#releasedDate").datetimepicker(
// 					{
// 						//yearOffset:543,
// 						timepicker:false,
// 						format:'d/m/Y',
// 						formatDate:'Y/m/d',
// 						minDate:'-1970/01/01' // yesterday is minimum date
// 					},
// 					$.datepicker.regional['th']
// 				);
				
// 				$("#expirationDate").datetimepicker(
// 					{
// 						//yearOffset:543,
// 						timepicker:false,
// 						format:'d/m/Y',
// 						formatDate:'Y/m/d',
// 						minDate:'-1970/01/01' // yesterday is minimum date
// 					},
// 					$.datepicker.regional['th']
// 				);
				
			  
			});
		</script>
		
	</head>
	<body>
		<form:form action="/tnc/movie/save" method="post" commandName="movie">
		
			<div name="pageHeader">
				<h3><spring:message code="movie.header.add" /></h3>
			</div>
			
			<div name="form">
				<jsp:include page="movieForm.jsp"></jsp:include>
			</div>
			
			<div name="btnFooter">
				<input type="submit" value="<spring:message code="btn.add" />" />
			</div>
			
		</form:form>
	</body>
</html>