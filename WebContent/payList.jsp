<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>정규직급여리스트</title>
<script src="js/pay.js"></script>
</head>
<body>
	<%@ include file="toptop.jsp" %>
	<%@ include file="top.jsp" %>
	<form name="sfForm">
	<table border="1" width="90%" align="center" height="100%">
		<tr>
			 <td>직원사번</td>
	         <td>이      름</td>
	         <td>연      차</td>
	         <td>세전급여 </td>
	         <td>급여합계</td>
	         <td>4대 보험</td>
	         <td>급여총계</td>
		</tr>
	</table>
	<table border="1" width="90%" align="center" height="100%" id="pay">
		
	</table>
	</form>		
		<input type="button" value="직원추가"  onclick='addRow(1)'/>
		<input type="button" value="직원삭제" onclick='deleteRow(-1)'/>
			
	
	<%@ include file="bottom.jsp" %>
	
</body>
</html>