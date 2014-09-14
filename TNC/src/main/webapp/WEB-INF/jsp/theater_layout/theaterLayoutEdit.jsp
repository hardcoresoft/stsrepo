<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script src="<c:url value="/resources/js/utils/common.js" />"></script>
	
	<title>Edit Theater Layout</title>
	
</head>
<body>
	<c:url var="actionUrl" value="/theater_layout/add" />
	<form:form action="${ actionUrl }" method="post" commandName="theaterLayout" enctype="multipart/form-data">
	
		<div id="pageHeader">
			<h3><spring:message code="btn.edit" /><spring:message code="theaterLayout.header" /></h3>
		</div>
		
		<div id="form">
			
			<form:hidden path="theaterLayoutId" />
		
			<jsp:include page="theaterLayoutForm.jsp"></jsp:include>
		</div>
		
		<div id="btnFooter">
			<input type="submit" value="<spring:message code="btn.edit" />" />
		</div>
		
	</form:form>
</body>
</html>