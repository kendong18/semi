<%@page import="com.semi.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세보기</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	<form action="noticedetail.do" method="post">
	<table border="1" align="center" width="30%">
		
		<tr>
			<td>타이틀</td>
			<td><c:out value="${DDTO.getN_title()}"></c:out> </td>
			<td></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><c:out value="${DDTO.getN_content()}"></c:out> </td>
		</tr>
		<tr>
			<td>작성된 날짜</td>
			<td><c:out value="${DDTO.getN_date()}"></c:out></td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="button" onclick="history.back()" value="목록">
				<c:if test="${loginUser eq 'admin' }">
					<input type="submit" value="수정"> 
					<input type="button" onclick="location='noticedelete.do?n_no=${DDTO.getN_no()}'" value="삭제">
				</c:if>
			</td>
		</tr>
	
	</table>
	<input type="hidden" value="${DDTO.getN_no()}" name="n_no">
	</form>
</body>
</html>