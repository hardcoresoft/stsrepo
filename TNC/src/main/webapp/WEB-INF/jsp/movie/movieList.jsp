<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
</head>
<body>
	<c:url var="addUrl" value="/movie/add" />
	<table style="border-collapse: collapse; border: 1px solid black; width: 100%">
		<tr>
			<th colspan="2"><h2>Movie List.</h2></th>
		</tr>
		<tr>
			<a href="${ addUrl }">new record</a>
		</tr>
		<tr>
			<td colspan="2">
				<table style="width: 100%; border: 1px solid green;">
					<tr>
						<th>Movie Name</th>
						<th>Released Date</th>
						<th>Expiration Date</th>
						<th>Duration</th>
						<th>Movie Image</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						
					</tr>
					
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
					<c:otherwise>
						<tr>
							<td colspan="7" style="text-align: center; color: red;"> record not found !! </td>
						</tr>
					</c:otherwise>
				</c:choose>
				<!-- End loop movie -->
					
				</table>
			</td>
		</tr>
	</table>
</body>
</html>