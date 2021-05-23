<%@page import="com.semi.dto.QuestionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의사항 게시판</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	
		<table border="1" width="30%" align="center" height="100%">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>답변현황</th>
			</tr>
			<c:choose>
			
			<c:when test="${fn:length(QDTO) == 1 }">
				<tr>
					<td><c:out value="${QDTO[0].getQ_no() }"></c:out> </td>
					<td><a href="questiondetail.do?q_no=${QDTO[0].getQ_no()}"><c:out value="${QDTO[0].getQ_title() }"></c:out></a></td>
					<td><c:out value="${QDTO[0].getCo_id()}"></c:out> </td>
					<td>
						<c:if test="${null ne QDTO[0].getQ_comment() }">답변완료</c:if>
						<c:if test="${null eq QDTO[0].getQ_comment() }">답변대기</c:if> 
					</td>
				</tr>
			</c:when>
			
			<c:when test="${fn:length(QDTO) > 1 }">
			<c:forEach var="list" items="${QDTO}">
			<tr>
				<td align="center">
					<c:out value="${list.getQ_no()}"></c:out>
				</td>
				<td align="center">
					<a href="questiondetail.do?q_no=${list.getQ_no()}"><c:out value="${list.getQ_title()}"></c:out></a>
				</td>
				<td align="right">
					<c:out value="${list.getCo_id()}"></c:out>
				</td>
				<td>
					<c:if test="${null ne list.getQ_comment() }">답변완료</c:if>
					<c:if test="${null eq list.getQ_comment() }">답변대기</c:if>
				</td>
			</tr>
			</c:forEach>
			</c:when>
			
			<c:otherwise>
				<tr>
					<td colspan="4">문의사항이 없습니다.</td>
				</tr>
			</c:otherwise>
			
			</c:choose>
			<c:if test="${loginUser ne null }">
			<tr align="right">
				<td colspan="4"><input type="button" value="문의작성" onclick="location.href='questionWrite.jsp'"></td>
			</tr>
			</c:if>
			
		</table>
	
</body>
</html>