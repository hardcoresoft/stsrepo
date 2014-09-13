<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table>
	
	<tr>
		<td width="20%">
			<form:label path="movieCode"> <spring:message code="label.code" /> </form:label> <span class="require">*</span>
		</td>
		<td width="60%">
			<form:input path="movieCode" maxlength="10" size="10" />
		</td>
		<td width="20%" align="left"><form:errors cssstyle="color:red" path="movieCode" />
		
	</tr>
	
	<tr>
		<td>
			<form:label path="movieNameTh"> <spring:message code="label.name.th" /> </form:label> <span class="require">*</span>
		</td>
		<td>
			<form:input path="movieNameTh" maxlength="200" size="50" />
		</td>
		<td align="left"><form:errors cssstyle="color:red" path="movieNameTh" />
		
	</tr>
	
	<tr>
		<td>
			<form:label path="movieNameEn">	<spring:message code="label.name.en" /> </form:label>
		</td>
		<td>
			<form:input path="movieNameEn" maxlength="200" size="50"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="movieNameDisplay"> <spring:message code="movie.display.name" />  </form:label>
		</td>
		<td>
			<form:input path="movieNameDisplay" maxlength="200" size="50"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="releasedDate"> <spring:message code="movie.released.date" />  </form:label>
		</td>
		<td>
			<form:input id="releasedDate" path="releasedDate" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="expirationDate"> <spring:message code="movie.expiration.date" />  </form:label>
		</td>
		<td>
			<form:input id="expirationDate" path="expirationDate" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="duration"> <spring:message code="movie.duration" />  </form:label>
		</td>
		<td>
			<form:input id="duration" path="duration" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="synopsis"> <spring:message code="movie.synopsis" />  </form:label>
		</td>
		<td>
			<form:textarea id="synopsis"  path="synopsis" cols="50" rows="10" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="director"> <spring:message code="movie.director" />  </form:label>
		</td>
		<td>
			<form:textarea id="director"  path="director" cols="50" rows="3" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="actor"> <spring:message code="movie.actor" />  </form:label>
		</td>
		<td>
			<form:textarea id="actor"  path="actor" cols="50" rows="3" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="activeStatus"> <spring:message code="label.status" />  </form:label>
		</td>
		<td>
			<form:checkbox id="activeStatus"  path="activeStatus" value="Active" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="movieImage"> <spring:message code="label.image" />  </form:label>
		</td>
		<td>
			<form:input id="movieImage"  path="movieImage" type="file" />
		</td>
	</tr>
	

</table>