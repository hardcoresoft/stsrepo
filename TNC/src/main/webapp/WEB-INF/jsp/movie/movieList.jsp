<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
</head>
<body>
	<table style="border: 1px solid black; width: 100%">
		<tr>
			<th colspan="2"><h2>Movie List.</h2></th>
		</tr>
		<tr>
			<a href="/tnc/movie/new">new record</a>
<%-- 			<form:button value="/movie/add" >new record</form:button> --%>
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
						<c:when test="${not empty movieList}">
							<c:forEach items="${movieList}" var="movie">
								<tr>
									<td>
										${movie.movieNameDisplay}
									</td>
									<td>
										${movie.releasedDate}111-222
<%-- 										<fmt:formatDate value="${movie.releasedDate}" pattern="dd/MM/yyyy"/> --%>
									</td>
<!-- 									<td> -->
<%-- 										<fmt:formatDate value="${movie.expirationDate}" pattern="dd/MM/yyyy"/> --%>
<!-- 									</td> -->
									<td>
										${movie.duration}
									</td>
									<td>
		 								${movie.movieImage}
									</td>
									<td>
										<a href="/movie/edit/${movie.id}">edit</a>
									</td>
									<td>
										<a href="/movie/delete/${movie.id}">delete</a>
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