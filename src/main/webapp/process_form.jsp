<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="add" class="beans.addPlayerBean" scope="session"></jsp:useBean>
<body>
<jsp:setProperty property="*" name="addPlayer"/>

<h3>status:</h3>
<h1>${sessionScope.addPlayer.addPlayer()}</h1>
</body>
</html>