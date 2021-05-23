function StaffNoCheck() {
	if (document.frm.sf_no.value == "") {
		alert('사번을 입력하여 주십시오.');
		document.frm.sf_no.focus();
		return;
	}
	var url = "staffnocheck?sf_no=" + document.frm.sf_no.value;
	window.open(url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(sf_no) {
	opener.frm.sf_no.value = document.frm.sf_no.value;
	//opener.frm.reid.value = document.frm.sf_no.value;
	self.close();
}