<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table style="border: 1 solid black; width: 100%">
	<tr>
		<td width="20%">
			<form:label path="movieNameTh"> <spring:message code="label.name.th" /> </form:label> <span class="require">*</span>
		</td>
		<td width="80%">
			<form:input path="movieNameTh" maxlength="200" />
		</td>
		
	</tr>
	
	<tr>
		<td>
			<form:label path="movieNameEn">	<spring:message code="label.name.en" /> </form:label>
		</td>
		<td>
			<form:input path="movieNameEn" maxlength="200"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="movieNameDisplay"> <spring:message code="movie.display.name" />  </form:label>
		</td>
		<td>
			<form:input path="movieNameDisplay" maxlength="200"/>
		</td>
	</tr>
	
</table>