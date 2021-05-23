<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${null eq loginUser }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 업데이트</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	<form action="noticeupdate.do" method="post">
	<table border="1" align="center" width="30%">
		
		<tr>
			<td>타이틀</td>
			<td><input name="n_title" type="text" size="25" value="${UDTO.getN_title()}" required="required" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="45" cols="45" name="n_content" required="required"><c:out value="${UDTO.getN_content()}"></c:out></textarea></td>
		</tr>
		<tr>
			<td>작성된 날짜</td>
			<td><c:out value="${UDTO.getN_date()}"></c:out></td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="button" onclick="history.back()" value="목록">
				<input type="submit" value="수정"> 
			</td>
		</tr>
	
	</table>
	<input type="hidden" value="${UDTO.getN_no()}" name="n_no">
	</form>
	
</body>
</html>