<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<div>
		<p>List files</p>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<c:if test="${!empty files}">
				<table border="2">
					<tr>
						<th>File Name</th>
						<th>Type</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${files}" var="file">
						<tr>
							<td><c:out value="${file.name}" /></td>
							<td><c:out value="${file.type}" /></td>
							<td><a href="<c:url value='/file/${file.id}' />">Download</a></td>
							<td><a href="<c:url value='/file/${file.id}/remove' />">Remove</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<a href="<c:url value="/file" />">Upload</a>
			<a href="<c:url value="/employees" />">Employees</a>
			<a href="<c:url value="/units" />">Units</a>
			<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
		</c:if>
	</div>
</body>
</html>