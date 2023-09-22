
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("context", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body text-align:center;>
<li><a href="/ParticipantList"><i	class="fa fa-edit fa-fw"></i>Participant List</a></li>
<li><a href="/OrgList"><i	class="fa fa-edit fa-fw"></i>Organization List</a></li>
<li><a href="/statistics"><i	class="fa fa-edit fa-fw"></i>Statistics</a></li>
