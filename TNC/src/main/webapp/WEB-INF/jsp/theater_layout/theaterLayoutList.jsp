<%@include file="../taglib_includes.jsp" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TheaterLayout List</title>
</head>
<body>
	<c:url var="addUrl" value="/theater_layout/add" />
	
	<div id="pageHeader">
		<h3><spring:message code="theaterLayout.header" /></h3>
	</div>
	
	<div id="form">
		<table>
			<tr>
				<td>
					<a href="${ addUrl }" class="btn-new-record"><spring:message code="btn.add" /></a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table class="data-grid">
						<thead>
						<tr>
							<th>Layout Name</th>
							<th>Description</th>
							<th>SeatAmount</th>
							<th>Active Status</th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
						</thead>
						
						<!-- Loop for show theaterLayout -->
						<tbody>
							<c:choose>
								<c:when test="${ not empty theaterLayoutList }">
									<c:forEach items="${ theaterLayoutList }" var="theaterLayout">
										
										<c:url var="editUrl" value="/theater_layout/edit/${ theaterLayout.theaterLayoutId }" />
										<c:url var="deleteUrl" value="/theater_layout/delete/${ theaterLayout.theaterLayoutId }" />
										
										<tr>
											<td>
												<c:out value="${ theaterLayout.layoutName }" />
											</td>
											<td>
												<c:out value="${ theaterLayout.description }" />
											</td>
											<td>
												<c:out value="${ theaterLayout.seatAmount }" />
											</td>
											<td>
												<c:out value="${ theaterLayout.activeStatus }" />
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
					</tbody>
					<!-- End loop theaterLayout -->
						
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>