<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원수정</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	<form action="staffupdate" method="post">
	<table width="70%" align="center">
		<tr>
			<td align="center">
				
				<table width="100%" >
					
						<tr align="center">
							<td><b>직원정보수정</b><br /></td>
						</tr>
				
						<tr>
							<td width="30%">직원번호 </td>
							<td width=50%><input type="text" name="sf_no" size="50" value="${sDTO.getSf_no()}" readonly/> </td>
						</tr>			
						<tr>
							<td>직원이름</td>
							<td><input type="text" name="sf_name" size="50" value="${sDTO.getSf_name()}" /></td>
						</tr>			
						<tr>
							<td>직원직급</td>
							<td><input type="text" size="50" name="sf_rank" value="${sDTO.getSf_rank()}"/></td>
						</tr>
						<tr>
							<td>직원주민등록번호</td>
							<td><input type="text" name="sf_jumin" size="50" value="${sDTO.getSf_jumin()}"/></td>
						</tr>
						<tr>
							<td>직원주소</td>
							<td><input type="text" name="sf_add" size="50" value="${sDTO.getSf_add()}"/></td>
						</tr>
						<tr>
							<td>직원전화번호</td>
							<td><input type="text" name="sf_tel" size="50" value="${sDTO.getSf_tel()}"/></td>
						</tr>
						<tr>
							<td>직원학력사항</td>
							<td>
								<input type="radio" name="sf_adu" value="0" />중졸
								<input type="radio" name="sf_adu" value="1"/>고졸
								<input type="radio" name="sf_adu" value="2"/>대졸
							</td>
						</tr>
						<tr>
							<td>직원급여</td>
							<td><input type="text" name="sf_pay" size="50" value="${sDTO.getSf_pay()}"/></td>
						</tr>
						<tr>
							<td>소속부서</td>
							<td><input type="text" name="sf_co" size="50" value="${sDTO.getSf_co()}" /> *</td>
						</tr>	
						<tr>
							<td>고용형태</td>
							<td>
								<input type="radio" name="sf_type" value="0"/>정규직
								<input type="radio" name="sf_type" value="1"/>계약직
								<input type="radio" name="sf_type" value="2"/>아르바이트
							</td>
						</tr>					
						<tr>
							<td>입사일</td>
							<td><input type="text" name="sf_start" size="50" required="required" placeholder="YYYYMMDD" value="${sDTO.getSf_start()}"/></td>
						</tr>
						<tr>
							<td>퇴사일</td>
							<td><input type="text" name="sf_end" size="50" placeholder="YYYYMMDD / 퇴사시 수정해주세요" value="${sDTO.getSf_end()}"/></td>
						</tr>										
					
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="수정하기"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="다시쓰기" />
							</td>
						</tr>	
					
				</table>
				
			</td>
		</tr>
	</table>	
</form>
	<%@ include file="bottom.jsp" %>
</body>
</html>