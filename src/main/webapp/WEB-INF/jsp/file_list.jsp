<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<%@ include file="head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body>
<%@ include file="menu.jsp"%>
<div style="margin-top:50px; text-align:center; height:50px;">
				<h3>File List</h3>
				<hr>
				<div class="table-responsive">
	<table align="center">
		<tr>
		    <th>File Name</th>
		    <th>Category</th>
			<th>File Desc</th>
			<th>Updated Time</th>
		</tr>
		<c:forEach items="${fileList}" var="file">
			<tr>
				<td>${file.name}</td>
				<td>${file.category}</td>
				<td>${file.desc}</td>
				<td>${file.updatedTime}</td>
				<td><a href="do_download?name=${file.name}">download</a></td>
				<td>
				    <form action="do_upload" method="post" enctype="multipart/form-data">
                    <input type="file" name="${file.name}" size="50" /><input type="submit" value="Upload" />
                    </form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>
