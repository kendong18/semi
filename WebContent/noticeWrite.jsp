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
	<title>공지사항 작성</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	
	<form action="noticewrite.do" method="post">
		<table align="center" width="30%" border="1">
			<tr>
				<td><b>제목</b><input type="text" name="n_title" size="68" required="required"></td>
			</tr>
			<tr>
				<td><textarea name="n_content" cols="77" rows="10" style="resize: none" required="required" placeholder="글 내용을 입력하세요"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="목록" onclick="history.back()">
					<input type="submit" value="작성">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>