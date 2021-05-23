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

@WebServlet("/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 화면에서 회원가입 버튼을 눌렀을때 회원가입 페이지로 이동
				RequestDispatcher rd=request.getRequestDispatcher("memberInsert.jsp");
				rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입화면에서 모두 입력하고 확인버튼 누를때
				request.setCharacterEncoding("UTF-8");
				
				MemberDTO dto=new MemberDTO();
				dto.setCo_id(request.getParameter("co_id"));
				dto.setCo_pwd(request.getParameter("co_pwd"));
				dto.setCo_name(request.getParameter("co_name"));
				dto.setCo_num(request.getParameter("co_num"));
				dto.setCo_ceo(request.getParameter("co_ceo"));
				dto.setCo_add(request.getParameter("co_add"));
				dto.setCo_tel(request.getParameter("co_tel"));
				
				MemberDAO dao=MemberDAO.getInstance();
				int confirm = dao.confirmID(request.getParameter("co_id"));	//중복체크를 해서 1이나 -1을 받는다.
				
				if(confirm == 1) {							//	1(중복된 결과)을 받았을 경우, index.jsp로 페이지를 이동시킨다.
					response.sendRedirect("tempStay.jsp");
				}else {										// 그렇지 않을 경우 회원가입을 진행한다.
					int result=dao.insertMember(dto);
					HttpSession session=request.getSession();
					if(result==1) {
						session.setAttribute("loginUser", dto.getCo_id()); 	//초기 로그인 화면에서 아이디를 바로 출력
						session.setAttribute("message", "회원가입에 성공 했습니다.");
					}else {
						session.setAttribute("message", "회원가입 실패!");
					}
					
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
	}

}
