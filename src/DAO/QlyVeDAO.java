package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CTKM_DTO;
import DTO.QlyToursDTO;
import DTO.VeDTO;
import Util.JDBCUtil;

public class QlyVeDAO {
	public static QlyVeDAO getIntance() {
		return new QlyVeDAO();
	}

	public ArrayList<VeDTO> selectAllVe() {
		ArrayList<VeDTO> ketqua = new ArrayList<VeDTO>();
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "select * from ve";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String mave = rs.getString("mave");
				String makht = rs.getString("makht");
				String makh = rs.getString("makh");
				double giave = rs.getDouble("giave");
				String makm = rs.getString("makm");
				String mahd = rs.getString("mahd");
				double giavegg = rs.getDouble("giavegg");
				VeDTO ve=new VeDTO(mave, makht, mahd, makm, makh, giave,giavegg);
				ketqua.add(ve);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public ArrayList<CTKM_DTO> selectAllCTKM() {
		ArrayList<CTKM_DTO> ketqua = new ArrayList<CTKM_DTO>();
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "select * from ctkm";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String makm = rs.getString("makm");
				String matour = rs.getString("matour");
				CTKM_DTO ctkm=new CTKM_DTO(makm,matour);
				ketqua.add(ctkm);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int InsertVe(VeDTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO ve (mave,makht,makh,giave,makm,mahd,giavegg)" + " VALUES('"
					+ t.getMave() + "','" + t.getMakht() + "','" + t.getMakh() + "'," + t.getGiave() + ",'"
					+ t.getMakm() + "','" + t.getMahd() + "','"+t.getGiavegg()+"')";
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int InsertCTKM(CTKM_DTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO ctkm (makm,matour)" + " VALUES('"
					+ t.getMakm() + "','" + t.getMatour() + "')";
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	
	
	
}
