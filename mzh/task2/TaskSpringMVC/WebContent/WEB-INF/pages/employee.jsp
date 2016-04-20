<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<h1>Add/Edit employee</h1>
	<c:if test="${!empty employee.id}">
		<c:url var="action" value="/employee/${employee.id}"></c:url>
	</c:if>
	<c:if test="${empty employee.id}">
		<c:url var="action" value="/employee"></c:url>
	</c:if>
	<form:form action="${action}" commandName="employee" method="post">
		<table>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="Last Name" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="First Name" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="status">
						<spring:message text="Status" />
					</form:label></td>
				<td><form:select path="status" class="form-control" id="status">
						<form:options items="${statuses}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="address.country">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="address.country" /></td>
			</tr>
			<tr>
				<td><form:label path="address.city">
						<spring:message text="City" />
					</form:label></td>
				<td><form:input path="address.city" /></td>
			</tr>
			<tr>
				<td><form:label path="personalInfo.passportNumber">
						<spring:message text="Passport Number" />
					</form:label></td>
				<td><form:input path="personalInfo.passportNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="personalInfo.driverLicenseNumber">
						<spring:message text="Driver License Number" />
					</form:label></td>
				<td><form:input path="personalInfo.driverLicenseNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="unit">
						<spring:message text="Unit Name" />
					</form:label></td>
				<td><form:select path="unit">
						<form:options items="${units}" itemLabel="name" itemValue="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="projects">
						<spring:message text="Projects Name" />
					</form:label></td>
				<td><form:select path="projects" multiple="true">
						<form:options items="${projects}" itemLabel="name" itemValue="name" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty employee.id}">
						<input type="submit" value="<spring:message text="Edit"/>" />
					</c:if> <c:if test="${empty employee.id}">
						<input type="submit" value="<spring:message text="Add"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
</body>
</html>