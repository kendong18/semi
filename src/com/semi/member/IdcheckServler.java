package com.semi.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.MemberDAO;


@WebServlet("/idCheck.do")
public class IdcheckServler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입페이지에서 중복확인 버튼을눌렀을때.
				String co_id=request.getParameter("co_id");
				
				MemberDAO dao=MemberDAO.getInstance();
				int result=dao.confirmID(co_id);
				
				request.setAttribute("co_id", co_id);
				request.setAttribute("result", result);
				
				RequestDispatcher rd=request.getRequestDispatcher("idCheck.jsp");
				rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
