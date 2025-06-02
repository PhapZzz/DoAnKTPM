package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class QlyToursDAO {
	public static QlyToursDAO getIntance() {
		return new QlyToursDAO();
	}

	public ArrayList<QlyToursDTO> selectAll() {
		ArrayList<QlyToursDTO> ketqua = new ArrayList<QlyToursDTO>();
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "select * from tours where tinhtrang = 1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String matour = rs.getString("matour");
				String tentour = rs.getString("tentour");
				int songay = rs.getInt("songay");
				String noiden = rs.getString("noiden");
				String maloai = rs.getString("maloai");
				String noikhoihanh = rs.getString("noikhoihanh");
				QlyToursDTO tour = new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
				ketqua.add(tour);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	
	
	public String TaoMaTour() {
		String ketQua = null;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "SELECT IFNULL(MAX(id)+1,1) as id FROM tours";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String id = rs.getString("id");
				ketQua = "tour".concat(id);
			}
			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public int InsertTour(QlyToursDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO tours (matour,tentour,songay,noiden,maloai,noikhoihanh,tinhtrang)" + " VALUES('"
					+ t.getMatour() + "','" + t.getTentour() + "'," + t.getSongay() + ",'" + t.getNoiden() + "','"
					+ t.getMaloai() + "','" + t.getNoikhoihanh() + "'," + 1 + ")";
			System.out.println("Ban da thuc thi: " + sql);
			// Bước 4:Xử lý kết quả trả về
			ketQua = st.executeUpdate(sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public int updateTour(QlyToursDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "UPDATE tours" + " SET matour='" + t.getMatour() + "',tentour='" + t.getTentour() + "',songay="
					+ t.getSongay() + ",noiden='" + t.getNoiden() + "',maloai='" + t.getMaloai() + "',noikhoihanh='"
					+ t.getNoikhoihanh() + "' WHERE matour='" + t.getMatour() + "';";
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
	
	public int delete(QlyToursDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "UPDATE tours SET tinhtrang = 0  WHERE matour='" + t.getMatour() + "';";
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

//	public int delete(QlyToursDTO t) {
//		int ketQua = 0;
//		try {
//			// Bước 1:Tạo kết nối
//			Connection con = JDBCUtil.getConnection();
//			// Bước 2:Tạo đối tượng statement
//			java.sql.Statement st = con.createStatement();
//			// Bước 3:Thực thi statement
//			String sql = "DELETE FROM tours WHERE matour='" + t.getMatour() + "';";
//			System.out.println(sql);
//			ketQua = st.executeUpdate(sql);
//			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
//			// Bước 5:Ngắt kết nối
//			JDBCUtil.closeConnection(con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return ketQua;
//	}

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
