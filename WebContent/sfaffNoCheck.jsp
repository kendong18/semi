<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사번중복체크</title>
	<script src="StaffScript.js"></script>
</head>
<body>
	<h3>직원사번 중복 확인 결과 화면</h3>
	<form action="staffnocheck" method="get" name=frm>
		직원사번:<input type="text" name="sf_no" value="${sf_no}"/>
		<input type="submit" value="충복체크" />
		<br />
		<c:if test="${result==1 }">
			<script >
			opener.document.frm.sf_no.value="";
			</script>
			 ${sf_no}는 이미 사용중인 번호 입니다. 
		</c:if>
		<c:if test="${result==-1}">
			${sf_no}는 사용가능한 번호 입니다.
			<input type="button" value="사용" onclick="idok('${sf_no}')"/>
		</c:if>
	</form>
</body>
</html>