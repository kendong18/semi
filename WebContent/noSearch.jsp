<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="js/pay.js"></script>
</head>
<body>

	<form name="noFrm">
		<table>
			<tr>
				<td>
					사번 입력 <input type="text" name="sf_no" required="required" />
					<input type="button" value="검색" onclick="loadSearch()">
				</td>
			</tr>
			
			<c:if test="${search1 eq 'y'}">
				<c:if test="${alist[0].getSf_no() eq null }">
					<tr>
						<td align="center">검색 결과가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${alist[0].getSf_no() ne null }">
					<tr>
						<td>아래 사원번호를 입력하면 자동으로 입력됩니다.</td>
					</tr>
					<c:forEach var="list" items="${alist}">
						<tr>
							<td>
								이름 : ${list.getSf_name()}<a href="#" onclick="javascript:sendSf('${list.getSf_no()}','${list.getSf_pay()}','${list.getSf_name() }')"> 사번 : ${list.getSf_no()} </a>급여 : ${list.getSf_pay()}
								
								<input type="text" name="annual" required="required" />
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>
			<tr>
				<td>
					<a href="#" onclick="self.close()">닫기</a>
				</td>
			</tr>
		</table>
		<input type="hidden" name="search" value="y">
	</form>

</body>
</html>