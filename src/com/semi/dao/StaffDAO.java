package com.semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.semi.dto.StaffDTO;

public class StaffDAO {
	public static StaffDAO instance = null;
	private ConnDAO pool;

	public StaffDAO() {
		pool = ConnDAO.getInstance();
	}

	public static StaffDAO getInstance() {
		if (instance == null) {
			instance = new StaffDAO();
		}
		return instance;
	}
	
	
	/**직원입력메서드**/
	public boolean insertStaff(StaffDTO sDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		boolean flag = false;

		try {
			con = pool.getConnection();
			sql = "insert into staff_tbl (SF_NO, SF_NAME, SF_RANK, SF_JUMIN, SF_ADD, SF_TEL, SF_ADU, SF_PAY, SF_CO, SF_TYPE, SF_START, SF_END) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sDTO.getSf_no());
			pstmt.setString(2, sDTO.getSf_name());
			pstmt.setString(3, sDTO.getSf_rank());
			pstmt.setString(4, sDTO.getSf_jumin());
			pstmt.setString(5, sDTO.getSf_add());
			pstmt.setString(6, sDTO.getSf_tel());
			pstmt.setString(7, sDTO.getSf_adu());
			pstmt.setInt(8, sDTO.getSf_pay());
			pstmt.setString(9, sDTO.getSf_co());
			pstmt.setString(10, sDTO.getSf_type());
			pstmt.setString(11, sDTO.getSf_start());
			pstmt.setString(12, sDTO.getSf_end());
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.err.println("staffdao insertStaff err:" + e.getMessage());
		} finally {
			pool.freeClose(con, pstmt);
		}

		return flag;
	}

	/**직원리스트메서드**/
	public Vector<StaffDTO> getStaff() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<StaffDTO> vlist = new Vector<StaffDTO>();

		try {
			con = pool.getConnection();
			sql = "select * from staff_tbl order by sf_no desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StaffDTO dto = new StaffDTO();
				dto.setSf_no(rs.getInt(1));
				dto.setSf_name(rs.getString(2));
				dto.setSf_rank(rs.getString(3));
				dto.setSf_jumin(rs.getString(4));
				dto.setSf_add(rs.getString(5));
				dto.setSf_tel(rs.getString(6));
				dto.setSf_adu(rs.getString(7));
				dto.setSf_pay(rs.getInt(8));
				dto.setSf_co(rs.getString(9));
				dto.setSf_type(rs.getString(10));
				dto.setSf_start(rs.getString(11));
				dto.setSf_end(rs.getString(12));
				vlist.addElement(dto);
			}
		} catch (Exception e) {
			System.err.println("StaffDAO getStaff err:" + e.getMessage());
		} finally {
			pool.freeClose(con, stmt, rs);
		}
		return vlist;
	}

	/**직원수정시보여지는메서드**/
	public StaffDTO get_Staff(int sf_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		StaffDTO dto = new StaffDTO();

		try {
			con = pool.getConnection();
			sql = "select * from staff_tbl where sf_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sf_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSf_no(rs.getInt("Sf_no"));
				dto.setSf_name(rs.getString("Sf_name"));
				dto.setSf_rank(rs.getString("Sf_rank"));
				dto.setSf_jumin(rs.getString("Sf_jumin"));
				dto.setSf_add(rs.getString("Sf_add"));
				dto.setSf_tel(rs.getString("Sf_tel"));
				dto.setSf_adu(rs.getString("Sf_adu"));
				dto.setSf_pay(rs.getInt("Sf_pay"));
				dto.setSf_co(rs.getString("Sf_co"));
				dto.setSf_type(rs.getString("Sf_type"));
				dto.setSf_start(rs.getString("Sf_start"));
				dto.setSf_end(rs.getString("Sf_end"));
			}
		} catch (Exception e) {
			System.err.println("StaffDAO get_staff err:" + e.getMessage());
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}

	/**직원정보수정메서드**/
	public boolean updateStaff(StaffDTO udto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql = "";
		boolean flag=false;
		
		try {
			con=pool.getConnection();
			sql="update Staff_tbl set sf_name=?, sf_rank=?, sf_jumin=?, SF_add=?, sf_tel=?, "
					+ "sf_adu=?, sf_pay=?, sf_co=?, sf_type=?, sf_start=?, sf_end=? where sf_no=?";
			pstmt=con.prepareStatement(sql);
			
		
			pstmt.setString(1, udto.getSf_name());
			pstmt.setString(2, udto.getSf_rank());
			pstmt.setString(3, udto.getSf_jumin());
			pstmt.setString(4, udto.getSf_add());
			pstmt.setString(5, udto.getSf_tel());
			pstmt.setString(6, udto.getSf_adu());
			pstmt.setInt(7, udto.getSf_pay());
			pstmt.setString(8, udto.getSf_co());
			pstmt.setString(9, udto.getSf_type());
			pstmt.setString(10, udto.getSf_start());
			pstmt.setString(11, udto.getSf_end());
			pstmt.setInt(12, udto.getSf_no());
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
				
			System.out.println("업데이트성공");
		
		}catch(Exception e) {
			System.err.println("Staffdao updateStaff err:"+e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
		
	 return flag;
	}
	
	/**직원정보삭제메서드**/
	public void deleteStaff(int sf_no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="";
		boolean flag=false;
		try {
			con=pool.getConnection();
			sql="delete from staff_tbl where sf_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sf_no);
			pstmt.executeUpdate();
			System.out.println("삭제성공");
		}catch(Exception e) {
			System.err.println("staffdao deletestaff err:"+e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
		
	}
	
	
	/**직원사번중복체크메서드**/
	public int DuplicatStaff(int sf_no) {
		int result=-1;
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try {
			con=pool.getConnection();
			sql="select sf_no from staff_tbl where sf_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sf_no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
		}catch(Exception e) {
			System.err.println("staffdao DuplicatStaff err:"+e.getMessage());
		}finally {
			pool.freeClose(con, pstmt, rs);
		}
		return result;
	}
}
