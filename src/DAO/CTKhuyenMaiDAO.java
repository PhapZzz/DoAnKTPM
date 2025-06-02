package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CTKhuyenMaiDTO;
import Util.JDBCUtil;

public class CTKhuyenMaiDAO {
	public static CTKhuyenMaiDAO getIntance() {
		return new CTKhuyenMaiDAO();
	}
	
	public ArrayList<CTKhuyenMaiDTO> selectAll(){
		ArrayList<CTKhuyenMaiDTO> result = new ArrayList<CTKhuyenMaiDTO>();
		try {
			//Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//Tạo đối tượng
			java.sql.Statement st = con.createStatement();
			//SQL
			String sql = "SELECT * FROM ctkm ";
			System.out.println(sql);
			ResultSet rs= st.executeQuery(sql);
			//Xu ly ket qua roi tra ve
			while(rs.next()) {
				String makm = rs.getString("makm");
				String matour = rs.getString("matour");
				CTKhuyenMaiDTO ctkm = new CTKhuyenMaiDTO(makm, matour);
                result.add(ctkm);


			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int InsertCTKhuyenMai(CTKhuyenMaiDTO t) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO ctkm (makm, matour) VALUES ('"
		            + t.getMakm() + "' , '" + t.getMatour() +"')";
			System.out.println(sql);
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		
		return kq;
	}
	
	public int deleteCTKhuyenMai(CTKhuyenMaiDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM ctkm WHERE makm = '" + t.getMakm()  + "' AND " + " matour = '" + t.getMatour() + "'";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
}

