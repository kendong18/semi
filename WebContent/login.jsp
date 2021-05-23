<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
</head>

<body>
<!-- 로그인 화면 -->
	
	<form action="login.do" method="post">
		<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="co_id" value="${loginUser}" required /></td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="co_pwd" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" onclick="loginCheck()" />
					<input type="reset" value="취소" />
					<input type="button" value="회원가입" onclick="location.href='memberInsert.do'" />
				</td>
			</tr>		

			<tr>
				<td colspan="2">${message}</td>
			</tr>
	
		</table>
	</form>
</body>
</html>