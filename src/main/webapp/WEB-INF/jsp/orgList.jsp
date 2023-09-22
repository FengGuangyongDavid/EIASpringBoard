<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<%@ include file="head.jsp"%>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
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
				<h3>Organization List</h3>
				<hr>
				<div class="table-responsive">
	<table style="margin-top: 0px;margin-left: 100px; ">
		<tr>
		    <th>Organization Name</th>
		    <th>Service Category</th>
		</tr>
		<c:forEach items="${orgList}" var="organization">
			<tr>
				<td>${organization.orgName}</td>
				<td>${organization.service}</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>
