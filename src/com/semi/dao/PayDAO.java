package com.semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.semi.dto.StaffDTO;

public class PayDAO {
	
	public static PayDAO instance = null;
	
	private ConnDAO pool;
	
	public PayDAO() {
		pool = ConnDAO.getInstance();
	}
	
	public static PayDAO getInstance() {
		if(instance == null) {
			instance = new PayDAO();
		}
		return instance;
	}
	
	public ArrayList<StaffDTO> noSearch(int sf_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<StaffDTO> alist = new ArrayList<StaffDTO>();
		try {
			con = pool.getConnection();
			sql = "select * from staff_tbl where sf_no like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sf_no);
			rs= pstmt.executeQuery();	// 급여, 이름, 사원번호
			while(rs.next()) {
				StaffDTO dto = new StaffDTO();
				dto.setSf_no(rs.getInt("sf_no"));
				System.out.println(rs.getInt("sf_no"));
				dto.setSf_name(rs.getString("sf_name"));
				dto.setSf_pay(rs.getInt("sf_pay"));
				alist.add(dto);
			}
		}catch (Exception e) {
			System.out.println("" + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt, rs);
		}
		return alist;
	}
	
}
