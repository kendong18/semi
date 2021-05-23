<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>idcheck.jsp</title>
	<script src="js/member.js"></script>
</head>

<body>
	<h3>아이디 중복 확인 및 결과 화면 : 새창</h3>
	<form action="idCheck.do" method="get"  name="frm">
		아이디 <input type="text" name="co_id" value="${co_id }" />
		<input type="submit"  value="중복체크" />
		<br />
		
		<c:if test="${result == 1 }">
			<script type="text/javascript">
				opener.document.frm.co_id.value="";		
			</script>
			
			${co_id } 는 이미 사용중인 아이디 입니다.
		</c:if>
	
		<c:if test="${result == -1 }">
			${co_id } 는 사용가능한 아이디입니다..
			<input type="button"  value="사용"  onclick="idok('${co_id}')" />
		</c:if>
	</form>
</body>
</html>






