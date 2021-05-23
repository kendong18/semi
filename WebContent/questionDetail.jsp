<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세보기</title>
</head>
<body>
<%@ include file="toptop.jsp" %>
<%@ include file="top.jsp" %>
	
	<table border="1" align="center" width="30%">
		<tr>
			<td>제목</td>
			<td><c:out value="${QDDTO.getQ_title()}"></c:out></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><c:out value="${QDDTO.getCo_id()}"></c:out> </td>
		</tr>
		<tr>
			<td>내용</td>
			<td><c:out value="${QDDTO.getQ_content()}"></c:out> </td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="button" onclick="history.back()" value="목록">
				<c:if test="${loginUser eq QDDTO.getCo_id() || loginUser eq 'admin'}">
					<input type="button" onclick="location='questionupdate.do?q_no=${QDDTO.getQ_no()}'" value="수정">
					<input type="button" onclick="location='questiondelete.do?q_no=${QDDTO.getQ_no()}'" value="삭제">
				</c:if>
		</td>
		</tr>
		<tr>
			<td>
				댓글
			</td>
			<td>
				<c:out value="${QDDTO.getQ_comment()}"></c:out>
			</td>
		</tr>
		<c:if test="${loginUser eq 'admin' }">
		<form action="questioncontent.do" method="post">
		<tr>
			<td colspan="2">
				댓글
				<input type="hidden" name="q_no" value="${QDDTO.getQ_no()}" />
				<input type="text" name="q_comment" required="required" /><input type="submit" value="댓글작성" />
			</td>
		</tr>
		</form>
		</c:if>
	</table>
	

</body>
</html>