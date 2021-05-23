<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 작성페이지</title>
	<script src="js/member.js"></script>
		
</head>

<body>
	<%@ include file="toptop.jsp" %><br />	
	<%@ include file="top.jsp" %>
	
	<table width="40%" align="center">
		<tr>
			<td align="center">
				
				<table width="100%">
					<form action="memberInsert.do" method="post" name="frm">
						<table>
						<tr align="center">
							<td colspan="2"><h3><b>회원가입</b></h3><br />	* 입력값은 필수 사항입니다.</td>
						</tr>
						<tr>
							<td width="35%">아이디</td>
							<td width="65%">
								<input type="text" name="co_id" size="40" required placeholder="4자리 이상" />*
								<input type="hidden" name="reid" size="40" />
								<input type="button" value="중복확인" onclick="idCheck()" />
							</td>
						</tr>			
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="co_pwd" size="40" required />*</td>
						</tr>			
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" name="co_repwd" size="40" required />*</td>
						</tr>
						</table>
			<!-- 		-----로그인정보-----		 -->
			
						<table>
						<tr>
							<td width="35%">회사명</td>
							<td width="65%"><input type="text" name="co_name" size="40" required />*</td>
						</tr>
						<tr>
							<td>사업자 번호</td>
							<td><input type="text" name="co_num" size="40" required />*</td>
						</tr>
						<tr>
							<td>회사 대표명</td>
							<td><input type="text" name="co_ceo" size="40" required />*</td>
						</tr>
						<tr>
							<td>회사주소</td>
							<td><input type="text" name="co_add" size="40" /></td>
						</tr>
						<tr>
							<td>회사 연락처</td>
							<td><input type="tel" name="co_tel" size="40" /></td>
						</tr>	
						</table>					
			<!-- 		-----회사정보-----		 -->
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="회원가입" onclick="memberinsertCheck()"  />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="다시쓰기" />
							</td>
						</tr>															
					</form>
				</table>
				
			</td>
		</tr>
	</table>	
	
	<%@ include file="bottom.jsp" %>			
</body>
</html>