package com.semi.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.StaffDAO;
import com.semi.dto.StaffDTO;

@WebServlet("/staffdetail")
public class StaffDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int sf_no= Integer.parseInt(request.getParameter("sf_no"));
		
		StaffDAO dao=StaffDAO.getInstance();
		StaffDTO dto=dao.get_Staff(sf_no);
		
		HttpSession session=request.getSession();
		session.setAttribute("sDTO", dto);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("staffDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		int sf_no= Integer.parseInt(request.getParameter("sf_no"));
		
		StaffDAO dao=StaffDAO.getInstance();
		StaffDTO dto=dao.get_Staff(sf_no);
		
		HttpSession session=request.getSession();
		session.setAttribute("sDTO", dto);
		
		RequestDispatcher rd=request.getRequestDispatcher("staffDetail.jsp");
		rd.forward(request, response);
	}

}
