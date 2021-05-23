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

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		System.out.println(request.getParameter("co_id"));
		MemberDTO dto=new MemberDTO();
		
		dto.setCo_id(request.getParameter("co_id"));
		dto.setCo_pwd(request.getParameter("co_pwd"));
		dto.setCo_name(request.getParameter("co_name"));
		dto.setCo_num(request.getParameter("co_num"));
		dto.setCo_ceo(request.getParameter("co_ceo"));
		dto.setCo_add(request.getParameter("co_add"));
		dto.setCo_tel(request.getParameter("co_tel"));
		
		MemberDAO dao=MemberDAO.getInstance();
		int result=dao.updateMember(dto);
		
		HttpSession session=request.getSession();
		if(result==1) {
			session.setAttribute("GETMEMBER", dto); 	
			session.setAttribute("message", "회원정보수정에 성공 했습니다.");
			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);	
		}else {
			session.setAttribute("message", "회원정보수정 실패!");
			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);	
		}
	}

}
