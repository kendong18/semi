<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:if test="${empty loginUser }"> --%>
<%-- 	<jsp:forward page="main.do"></jsp:forward> --%>
<%-- </c:if> --%>


<c:if test="${null eq loginUser }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main.jsp</title>
</head>

<body>
	<%@ include file="toptop.jsp" %><br />	
	<%@ include file="top.jsp" %>		
	
	<table border="1" align="center" width="90%">
		<br /><br /><br />
		<br /><br /><br />	
		<h3 align="center">${loginUser}님 환영합니다.</h3>
		<br /><br /><br />	
		<br /><br /><br />		
	</table>
	
	<%@ include file="bottom.jsp" %>	
</body>
</html>

