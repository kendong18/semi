package com.semi.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.MemberDAO;
import com.semi.dto.MemberDTO;

@WebServlet("/memberdetail.do")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String co_id = request.getParameter("co_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberDTO dto = new MemberDTO();
		
		dto = dao.getMember(co_id);
		
		HttpSession session = request.getSession();
		session.setAttribute("GETMEMBER", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberUpdate.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
