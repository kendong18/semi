package com.semi.pay;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.PayDAO;
import com.semi.dto.StaffDTO;

@WebServlet("/paylist.do")
public class PayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PayDAO dao = PayDAO.getInstance();
		String search = request.getParameter("search");
		int sf_no = 0;
		ArrayList<StaffDTO> alist = new ArrayList<StaffDTO>();
		if(search.equals("y")) {
			sf_no = Integer.parseInt(request.getParameter("sf_no"));
			alist = dao.noSearch(sf_no);
			
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("alist", alist);
		session.setAttribute("search1", search);
		
		RequestDispatcher rd = request.getRequestDispatcher("noSearch.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
