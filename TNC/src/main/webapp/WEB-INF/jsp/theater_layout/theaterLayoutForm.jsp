<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table>
	
	<tr>
		<td width="20%">
			<form:label path="layoutName"> <spring:message code="label.layout.name" /> </form:label> <span class="require">*</span>
		</td>
		<td width="60%">
			<form:input path="layoutName" maxlength="500" size="50" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="description"> <spring:message code="label.description" />  </form:label>
		</td>
		<td>
			<form:textarea id="description"  path="description" cols="50" rows="10" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="seatAmount"> <spring:message code="label.amount" />  </form:label>
		</td>
		<td>
			<form:input path="seatAmount" maxlength="10" size="5" />
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
	
</table>