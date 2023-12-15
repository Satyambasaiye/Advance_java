<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="team" class="bean.TeamBean" scope="session"></jsp:useBean>
<body>
<h3>${sessionScope.team.abbreviations} </h3>
</body>
</html>