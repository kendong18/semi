<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보 수정페이지</title>
	<script src="js/member.js"></script>
		
</head>

<body>
	<%@ include file="toptop.jsp" %><br />	
	<%@ include file="top.jsp" %>
	
	<table width="40%" align="center" name="frm">
		<tr>
			<td align="center">
				
				<table width="100%">
					<form action="memberUpdate.do" method="post" name="frm">
						<table width="100%">
						<tr align="center">
							<td colspan="2"><h3><b>회원정보 수정</b></h3><br /></td>
						</tr>
						<tr>
							<td width="35%">아이디</td>
							<td width="65%">${GETMEMBER.getCo_id() }</td>
						</tr>			
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="co_pwd" size="40" required /></td>
						</tr>			
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" name="co_repwd" size="40" required /></td>
						</tr>
						</table>
			<!-- 		-----로그인정보-----		 -->
			
						<table width="100%">
						<tr>
							<td width="35%">회사명</td>
							<td width="65%"><input type="text" name="co_name" size="40" value="${GETMEMBER.getCo_name() }" required /></td>
						</tr>
						<tr>
							<td>사업자 번호</td>
							<td><input type="text" name="co_num" size="40" value="${GETMEMBER.getCo_num() }" required /></td>
						</tr>
						<tr>
							<td>회사 대표명</td>
							<td><input type="text" name="co_ceo" size="40" value="${GETMEMBER.getCo_ceo() }" required /></td>
						</tr>
						<tr>
							<td>회사주소</td>
							<td><input type="text" name="co_add" size="40" value="${GETMEMBER.getCo_add() }" /></td>
						</tr>
						<tr>
							<td>회사 연락처</td>
							<td><input type="tel" name="co_tel" size="40" value="${GETMEMBER.getCo_tel() }" /></td>
						</tr>	
						</table>					
			<!-- 		-----회사정보-----		 -->
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="회원정보 수정" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="다시쓰기" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" value="아이디삭제" onclick="location.href='memberDelete.do?co_id=${GETMEMBER.getCo_id() }'" />								
							</td>
						</tr>
						<input type="hidden" value="${GETMEMBER.getCo_id()}" name="co_id">															
					</form>
				</table>
				
			</td>
		</tr>
	</table>	
	
	<%@ include file="bottom.jsp" %>			
</body>
</html>