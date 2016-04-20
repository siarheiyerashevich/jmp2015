<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>
	<c:url var="action" value="/file"></c:url>
	<form method="post" action="${action}" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>Pick file #1:</td>
				<td><input type="file" name="uploadFile" size="50" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Upload" /></td>
			</tr>
		</table>
</body>
</html>