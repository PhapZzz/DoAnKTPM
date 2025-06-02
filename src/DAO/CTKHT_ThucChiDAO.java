package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CTKHT_ThucChiDTO;
import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class CTKHT_ThucChiDAO {
	public static CTKHT_ThucChiDAO getIntance() {
		return new CTKHT_ThucChiDAO();
	}

	public ArrayList<CTKHT_ThucChiDTO> selectAll() {
		ArrayList<CTKHT_ThucChiDTO> ketqua = new ArrayList<CTKHT_ThucChiDTO>();
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "select * from ctkht_thucchi";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String makht = rs.getString("makht");
				Date ngay = rs.getDate("ngay");
				String maks = rs.getString("maks");
				Double thanhtienks = rs.getDouble("thanhtienks");
				String mapt = rs.getString("mapt");
				Double thanhtienpt = rs.getDouble("thanhtienpt");
				String manh = rs.getString("manh");
				Double thanhtiennh = rs.getDouble("thanhtiennh");
				Double tongtien=rs.getDouble("tongtien");
				CTKHT_ThucChiDTO ct = new CTKHT_ThucChiDTO(makht, maks, mapt, manh, thanhtienks, thanhtienpt, thanhtiennh, tongtien, ngay);
				ketqua.add(ct);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	public int Insert(CTKHT_ThucChiDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO ctkht_thucchi (makht,ngay,maks,thanhtienks,mapt,thanhtienpt,manh,thanhtiennh,tongtien)" + " VALUES('"
					+ t.getMakht() + "','" + t.getNgay() + "','" + t.getMaks() + "'," + t.getThanhtienks() + ",'"
					+ t.getMapt() + "'," + t.getThanhtienpt() + ",'"+t.getManh()+ "',"+t.getThanhtiennh()+ ","+t.getTongtien()+")";
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

	public int Update(CTKHT_ThucChiDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "UPDATE ctkht_thucchi" + " SET makht='" + t.getMakht() + "',ngay='" + t.getNgay() + "',maks='"
					+ t.getMaks() + "',thanhtienks=" + t.getThanhtienks() + ",mapt='" + t.getMapt() + "',thanhtienpt="
					+ t.getThanhtienpt() +",manh='" + t.getManh() + "',thanhtiennh="
					+ t.getThanhtiennh() +",tongtien="
					+ t.getTongtien()+ " WHERE makht='" + t.getMakht() + "' AND ngay='"+t.getNgay()+"';";
			System.out.println(sql);
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

	public int delete(CTKHT_ThucChiDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "DELETE FROM ctkht_thucchi WHERE makht='" + t.getMakht() + "';";
			System.out.println(sql);
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

	public ArrayList<QlyToursDTO> selectByCondition(String condition,String condType) {
		ArrayList<QlyToursDTO> ketQua = new ArrayList<QlyToursDTO>();
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql="";
			if (condType.equals("Mã Tour")) {
				sql = "SELECT * FROM tours WHERE matour='" + condition + "';";
			} else if (condType.equals("Số ngày")) {
				int ngay=Integer.parseInt(condition);
				sql = "SELECT * FROM tours WHERE songay=" + condition + ";";
			} else if (condType.equals("Nơi đến")) {
				sql = "SELECT * FROM tours WHERE noiden='" + condition + "';";
			}
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String matour = rs.getString("matour");
				String tentour = rs.getString("tentour");
				Integer songay = rs.getInt("songay");
				String noiden = rs.getString("noiden");
				String maloai = rs.getString("maloai");
				String noikhoihanh = rs.getString("noikhoihanh");
				QlyToursDTO t = new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
				ketQua.add(t);
			}
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
