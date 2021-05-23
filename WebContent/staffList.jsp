<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원정보리스트</title>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	
		<table border="1" width="90%" align="center" height="100%">
			<tr>
				<th>직원사번</th>
				<th>이름</th>
				<th>직급</th>
				<th>주민번호</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>학력사항</th>
				<th>월급</th>
				<th>소속부서</th>
				<th>직원고용형태</th>
				<th>입사일</th>
				<th>퇴사일</th>
				<th>수정하기</th>
			</tr>
			
				
			<c:forEach var="list" items="${DTO }">
			<tr>
				<td>
					<c:out value="${list.getSf_no()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_name()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_rank()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_jumin()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_add()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_tel()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_adu()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_pay()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_co()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_type()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_start()}"></c:out>
				</td>
				<td>
					<c:out value="${list.getSf_end()}"></c:out>
				</td>
				<td>
					<input type="button" value="수정하기" onclick="location.href='staffdetail?sf_no=${list.getSf_no()}'"/> / 
					<input type="button" value="삭제하기" onclick="location.href='staffdelete?sf_no=${list.getSf_no()}'"/> / 
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="13">
				<input type="button" value="직원추가하기" onclick="location.href='staffInsert.jsp'"/>
				</td>
			</tr>
		</table>
		
	<%@ include file="bottom.jsp" %>
</body>
</html>