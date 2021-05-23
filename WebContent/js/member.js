function loginCheck() {
	if (document.frm.co_id.value.length == "") {
		alert("아이디를 써주세요");
		frm.co_id.focus();
		return false;
	}
	if (document.frm.co_pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.co_pwd.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.co_id.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.co_id.focus();
		return;
	}
	var url = "idCheck.do?co_id=" + document.frm.co_id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(co_id) {
	opener.frm.co_id.value = document.frm.co_id.value;
	opener.frm.reid.value = document.frm.co_id.value;
	self.close();
}

function memberinsertCheck() {
	if (document.frm.co_name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.co_name.focus();
		return false;
	}
	if (document.frm.co_id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.co_id.focus();
		return false;
	}
	if (document.frm.co_id.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.co_id.focus();
		return false;
	}
	if (document.frm.co_pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.co_pwd.focus();
		return false;
	}
	if (document.frm.co_pwd.value != document.frm.co_repwd.value) {
		alert("암호가 일치하지 않습니다.");
		frm.co_pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.co_id.focus();
		return false;
	}
	return true;
}