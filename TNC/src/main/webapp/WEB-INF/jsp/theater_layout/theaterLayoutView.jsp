<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie View</title>
</head>
<body>
	<div id="pageHeader">
		<h3>
			<spring:message code="theaterLayout.header" />
		</h3>
	</div>

	<div id="form">
		<table class="data-view">
	
			<tr>
				<td width="20%">
					<spring:message code="label.layout.name" />
				</td>
				<td width="80%">
					${theaterLayout.layoutName}
				</td>
				
			</tr>
			
			<tr>
				<td>
					<spring:message code="label.description" />
				</td>
				<td>
					${ theaterLayout.description }
				</td>
				
			</tr>
			
			<tr>
				<td>
					<spring:message code="label.amount" />
				</td>
				<td>
					${ theaterLayout.seatAmount }
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="label.status" />
				</td>
				<td>
					${ movie.activeStatus }
				</td>
			</tr>
			
		<!-- 	<tr> -->
		<!-- 		<td> -->
		<%-- 			<form:label path="movieImage"> <spring:message code="label.image" />  </form:label> --%>
		<!-- 		</td> -->
		<!-- 		<td> -->
		<%-- 			<form:input id="movieImage"  path="movieImage" type="file" /> --%>
		<!-- 		</td> -->
		<!-- 	</tr> -->
			
		</table>
	</div>

	<div id="btnFooter">
		<a href="/tnc/theater_layout/"> <spring:message code="btn.list" /> </a>
	</div>
</body>
</html>