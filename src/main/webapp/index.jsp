<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="team" class="beans.TeamBean" scope="session" />
<body>
	<h3></h3>
	<form action="process_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Add Player Form</caption>
			<tr>
				<td>Choose A Team</td>
				<td><select name="abbr">
						<c:forEach var="a" items="${sessionScope.team.abbreviations}">
							<option value="${a}">${a}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter Player Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><input type="number" name="avg" /></td>
			</tr>
			<tr>
				<td>Enter Wickets Taken</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
</body>
</html>