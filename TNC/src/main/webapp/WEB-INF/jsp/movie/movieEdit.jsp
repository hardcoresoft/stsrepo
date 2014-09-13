<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script src="<c:url value="/resources/js/utils/common.js" />"></script>
	
	<title>Edit Movie</title>
	
	<script type="text/javascript">
			$( document ).ready(function() {

				$("#releasedDate").datepicker( pickerOpts );

				$("#expirationDate").datepicker( pickerOpts );
				
			});
		</script>
</head>
<body>
	<c:url var="actionUrl" value="/movie/add" />
	<form:form action="${ actionUrl }" method="post" commandName="movie" enctype="multipart/form-data">
	
		<div id="pageHeader">
			<h3><spring:message code="movie.header.edit" /></h3>
		</div>
		
		<div id="form">
			
			<form:hidden path="movieId" />
		
			<jsp:include page="movieForm.jsp"></jsp:include>
		</div>
		
		<div id="btnFooter">
			<input type="submit" value="<spring:message code="btn.edit" />" />
		</div>
		
	</form:form>
</body>
</html>