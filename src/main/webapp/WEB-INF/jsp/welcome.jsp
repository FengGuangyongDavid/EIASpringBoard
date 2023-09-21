<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
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
<div style="margin-top:50px; text-align:center; height:50px;">
				<h3>Participant List</h3>
				<hr>
				<div class="table-responsive">
	<table style="margin-top: 0px;margin-left: 100px; ">
		<tr>
		    <th>Id</th>
		    <th>Cabin No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Phone No.</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${personList}" var="person">
			<tr>
				<td>${person.personId}</td>
				<td>${person.cabinNo}</td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.age}</td>
				<td>${person.gender}</td>
				<td>${person.phoneNo}</td>
				 <td>${person.cabinStatus}</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>
