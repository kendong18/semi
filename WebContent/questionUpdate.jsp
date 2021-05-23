<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${null eq loginUser }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의사항 수정</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	<form action="questionupdate.do" method="post">
	<table align="center" width="30%" border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="q_title" size="25" value="${UDDTO.getQ_title() }"></td>
		</tr>
		<tr>
			<td>내용물</td>
			<td><textarea rows="40" cols="40" name="q_content">${UDDTO.getQ_content()}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" />
				<input type="button" value="돌아가기" onclick="history.back()" />
			</td>
		</tr>
	</table>
	<input type="hidden" value="${UDDTO.getQ_no()}" name="q_no">
	</form>
</body>
</html>