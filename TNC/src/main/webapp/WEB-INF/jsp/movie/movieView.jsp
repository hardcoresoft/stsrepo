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
			<spring:message code="movie.header.add" />
		</h3>
	</div>

	<div id="form">
		<table style="border: 1px solid black; width: 100%">
	
			<tr>
				<td width="20%">
					<spring:message code="label.code" />
				</td>
				<td width="80%">
					${movie.movieCode}
				</td>
				
			</tr>
			
			<tr>
				<td>
					<spring:message code="label.name.th" />
				</td>
				<td>
					${ movie.movieNameTh }
				</td>
				
			</tr>
			
			<tr>
				<td>
					<spring:message code="label.name.en" />
				</td>
				<td>
					${ movie.movieNameEn }
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.display.name" />
				</td>
				<td>
					${ movie.movieNameDisplay }
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.released.date" />
				</td>
				<td>
					<fmt:formatDate value="${ movie.releasedDate }"  pattern="dd/MM/yyyy"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.expiration.date" />
				</td>
				<td>
					<fmt:formatDate value="${ movie.expirationDate }" pattern="dd-MM-yyyy"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.duration" />
				</td>
				<td>
					<fmt:formatNumber value="${ movie.duration }" pattern="#,##0"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.synopsis" />
				</td>
				<td>
					${ movie.synopsis }
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.director" />
				</td>
				<td>
					${ movie.director }
				</td>
			</tr>
			
			<tr>
				<td>
					<spring:message code="movie.actor" />
				</td>
				<td>	
					${ movie.actor }
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
			
		
	</div>

	<div id="btnFooter">
		<a href="/tnc/movie/"> <spring:message code="btn.list" /> </a>
	</div>
</body>
</html>