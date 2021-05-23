package com.semi.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.StaffDAO;
import com.semi.dto.StaffDTO;

@WebServlet("/staffinsert")
public class StaffInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sf_no=request.getParameter("sf_no");
		String sf_name=request.getParameter("sf_name");
		String sf_rank=request.getParameter("sf_rank");
		String sf_jumin=request.getParameter("sf_jumin");
		String sf_add=request.getParameter("sf_add");
		String sf_tel=request.getParameter("sf_tel");
		String sf_adu=request.getParameter("sf_adu");
		String sf_pay=request.getParameter("sf_pay");
		String sf_co=request.getParameter("sf_co");
		String sf_type=request.getParameter("sf_type");
		String sf_start=request.getParameter("sf_start");
		String sf_end=request.getParameter("sf_end");
		
		StaffDTO dto=new StaffDTO();
		dto.setSf_no(Integer.parseInt(sf_no));
		dto.setSf_name(sf_name);
		dto.setSf_rank(sf_rank);
		dto.setSf_jumin(sf_jumin);
		dto.setSf_add(sf_add);
		dto.setSf_tel(sf_tel);
		dto.setSf_adu(sf_adu);
		dto.setSf_pay(Integer.parseInt(sf_pay));
		dto.setSf_co(sf_co);
		dto.setSf_type(sf_type);
		dto.setSf_start(sf_start);
		dto.setSf_end(sf_end);
		
		StaffDAO dao=StaffDAO.getInstance();
		
		boolean flag = dao.insertStaff(dto);
		if(flag) {
			RequestDispatcher rd=request.getRequestDispatcher("stafflist");
			rd.forward(request, response);
		}else {
		response.sendRedirect("staffInsert.jsp");
		}
	}

}
