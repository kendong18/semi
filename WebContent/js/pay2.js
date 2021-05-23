/** 행추가* */
function addRow() {
	// table element 찾기
	const table = document.getElementById('pay');

	// 새 행(Row) 추가
	const newRow = table.insertRow();

	// 새 행(Row)에 Cell 추가
	const newCell1 = newRow.insertCell(0);
	const newCell2 = newRow.insertCell(1);
	const newCell3 = newRow.insertCell(2);
	const newCell4 = newRow.insertCell(3);
	const newCell5 = newRow.insertCell(4);
	const newCell6 = newRow.insertCell(5);
	const newCell7 = newRow.insertCell(6);

	// Cell에 텍스트 추가

	newCell1.innerHTML = "<input type=button value=search onclick=noCheck()><input type=text name=sf_no size=5>";
	newCell2.innerHTML = '<input type=text name=sf_name size=5>';
	newCell3.innerHTML = '<input type=text name=sf_pay size=5>';
	newCell4.innerHTML = '<input type=text size=5>';
	newCell5.innerHTML = '<input type=text size=5>';
	newCell6.innerHTML = '<input type=text size=5>';
	newCell7.innerHTML = '<input type=text size=5>';
}

/** 행삭제* */
function deleteRow(rownum) {

	const table = document.getElementById('pay');
	if(rownum<1){
		const newRow = table.deleteRow(rownum);
	}
	

}
function noCheck(){
	url="paylist.do?search=n";
	window.open(url, "post", "width=500,height=300");
}

function loadSearch(){
	frm=document.noFrm;  // <form name="zipFrm" method="post" >
	frm.action="paylist.do";   // <form action="zipSearch.jsp"> 와 동일
	frm.submit();  // <form><input type="submit" /></form> 과 동일
	// zipSearch.jsp?search=y&area3=입력값
}

function sendSf(sf_no, sf_pay, sf_name){
	// member.jsp => <form name="regForm"> => name="zipcode" =>우편번호 값을 설정
	opener.document.sfForm.sf_no.value=sf_no;  // member.jsp 내부
	
	// member.jsp => <form name="regForm"> => name="address" =>주소 값을 설정
	opener.document.sfForm.sf_pay.value=sf_pay;  	// member.jsp 내부
	
	opener.document.sfForm.sf_name.value=sf_name;
	self.close();  // 새창 닫기
}
