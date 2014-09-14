<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
</head>
<body>
	<c:url var="addUrl" value="/movie/add" />
	
	<div id="pageHeader">
		<h3><spring:message code="movie.header" /></h3>
	</div>
	
	<div id="form">
		<table>
			<tr>
				<td>
					<a href="${ addUrl }">new record</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table class="data-grid">
						<thead>
							<tr>
								<th>Movie Name</th>
								<th>Released Date</th>
								<th>Expiration Date</th>
								<th>Duration</th>
								<th>Movie Image</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						
						<tbody>
							<!-- Loop for show movie -->
							<c:choose>
								<c:when test="${ not empty movieList }">
									<c:forEach items="${ movieList }" var="movie">
										
										<c:url var="editUrl" value="/movie/edit/${ movie.movieId }" />
										<c:url var="deleteUrl" value="/movie/delete/${ movie.movieId }" />
										<c:url var="viewUrl" value="/movie/view/${ movie.movieId }" />
										
										<tr>
											<td>
												<a href="${ viewUrl }"> <c:out value="${ movie.movieNameDisplay }" />  </a>
											</td>
											<td>
												<fmt:formatDate value="${ movie.releasedDate }" pattern="dd/MM/yyyy"/>
											</td>
											<td>
												<fmt:formatDate value="${ movie.expirationDate }" pattern="dd/MM/yyyy"/>
											</td>
											<td>
												<c:out value="${ movie.duration }" />
											</td>
											<td>
												<c:out value="${ movie.movieImage }" />
											</td>
											<td>
												<a href="${ editUrl }">edit</a>
											</td>
											<td>
												<a href="${ deleteUrl }">delete</a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
							<!-- End loop movie -->
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>