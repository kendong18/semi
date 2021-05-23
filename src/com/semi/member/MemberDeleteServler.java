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


@WebServlet("/memberDelete.do")
public class MemberDeleteServler extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String co_id=request.getParameter("co_id");
				
		MemberDAO dao=MemberDAO.getInstance();
		int result=dao.deleteMember(co_id);
		
		if(result==1) {
			
			HttpSession session = request.getSession();
			session.invalidate();		
			
		}else {
			request.setAttribute("message", "회원정보 삭제 실패");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
