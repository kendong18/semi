<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<table align="center" width="90%">
	
	<c:if test="${null eq loginUser }">
		<tr align="right">
			<td><a href=login.jsp>로그인</a></td>
		</tr>
		<tr align="right">
			<td><a href=memberInsert.jsp>회원가입</a></td>
		</tr>
	</c:if>
	<c:if test="${null ne loginUser}">
		<tr align="right">
			<td><a href=logout.jsp>로그아웃</a></td>
		</tr>
		<tr align="right">
			<td><a href="memberdetail.do?co_id=${loginUser}">회원수정</a></td>
		</tr>
	</c:if>	
	
</table>