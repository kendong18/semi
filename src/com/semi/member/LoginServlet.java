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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입하고 넘어오는 곳
				String url = "login.jsp";
				
				HttpSession session = request.getSession();
				if(session.getAttribute("loginUser")!=null) {
					url="main.jsp";
				}
				
				RequestDispatcher rd=request.getRequestDispatcher(url);
				rd.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println(request.getParameter("co_id"));
				//정보를입력하고 로그인되서 메인페이지로 넘어가는 곳
				String url="login.jsp";
				String co_id=request.getParameter("co_id");
				String co_pwd=request.getParameter("co_pwd");
				
				MemberDAO dao = MemberDAO.getInstance();
				
				int result=dao.userCheck(co_id, co_pwd);
				
				
				if(result==1) {
					
					HttpSession session = request.getSession();
					session.setAttribute("loginUser",co_id);
					request.setAttribute("message", "로그인 되었습니다.");
					url="main.jsp";			
					
				}else if(result==0){
					request.setAttribute("message", "비밀번호가 틀립니다.");
				}else if(result==-1) {	
					request.setAttribute("message", "존재하지 않는 아이디 입니다.");
				}
				RequestDispatcher rd=request.getRequestDispatcher(url);
				rd.forward(request, response);
	}

}
