<%@page import="com.semi.dto.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 게시판</title>
	
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	
		<table border="1" width="30%" align="center" height="100%">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
			<c:choose>
					
					<c:when test="${fn:length(DTO) == 1 }">
						<tr>
							<td>
								<c:out value="${DTO[0].getN_no()}"></c:out>
							</td>
							<td>
								<a href="noticedetail.do?n_no=${DTO[0].getN_no()}"><c:out value="${DTO[0].getN_title()}"></c:out></a>
							</td>
							<td>
								<c:out value="${DTO[0].getN_date() }"></c:out>
							</td>
						</tr>
					</c:when>
					
					<c:when test="${fn:length(DTO) > 1 }">
					
						<c:forEach var="list" items="${DTO}">
							<tr>
								<td>
									<c:out value="${list.getN_no()}"></c:out>
								</td>
								<td>
									<a href="noticedetail.do?n_no=${list.getN_no()}"><c:out value="${list.getN_title()}"></c:out></a>
								</td>
								<td>
									<c:out value="${list.getN_date() }"></c:out>
								</td>
							</tr>
						</c:forEach>
						
					</c:when>
					
					<c:otherwise>
						<tr>
							<td colspan="3">공지가 없습니다.</td>
						</tr>
					</c:otherwise>
					
			</c:choose>
			<c:if test="${loginUser eq 'admin'}">
				<tr align="right">
					<td colspan="3"><input type="button" value="공지작성" onclick="location.href='noticeWrite.jsp'"></td>
				</tr>
			</c:if>
				
		</table>
	
</body>
</html>