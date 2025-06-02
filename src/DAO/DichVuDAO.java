package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.NhanVienDTO;
import DTO.PhuongTienDTO;
import Util.JDBCUtil;

public class DichVuDAO {
	public static DichVuDAO getIntance() {
		return new DichVuDAO();
	}
	
	public ArrayList<KhachSanDTO> selectAll_KhachSan() {
		ArrayList<KhachSanDTO> ketQua=new ArrayList<KhachSanDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM dsks WHERE tinhtrang = 1";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String maks=rs.getString("maks");
				String tenks=rs.getString("tenks");
				double giaca=rs.getDouble("giaca");
				KhachSanDTO ks = new KhachSanDTO(maks, tenks, giaca);
				ketQua.add(ks);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<NhaHangDTO> selectAll_NhaHang() {
		ArrayList<NhaHangDTO> ketQua=new ArrayList<NhaHangDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM dsnhahang where tinhtrang = 1";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String manh=rs.getString("manh");
				String tennh=rs.getString("tennh");
				double giaca=rs.getDouble("giaca");
				NhaHangDTO nh = new NhaHangDTO(manh, tennh, giaca);
				ketQua.add(nh);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<PhuongTienDTO> selectAll_PhuongTien() {
		ArrayList<PhuongTienDTO> ketQua=new ArrayList<PhuongTienDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM dsphuongtien where tinhtrang = 1";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String mapt=rs.getString("mapt");
				String tenpt=rs.getString("tenpt");
				double giaca=rs.getDouble("giaca");
				PhuongTienDTO nh = new PhuongTienDTO(mapt, tenpt, giaca);
				ketQua.add(nh);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}

	
	
	public String TaoMaKhachSan() {
		String ketQua = null;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "SELECT IFNULL(MAX(id)+1,1) as id FROM dsks";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String id = rs.getString("id");
				ketQua = "KS".concat(id);
			}
//			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public String TaoMaNhaHang() {
		String ketQua = null;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "SELECT IFNULL(MAX(id)+1,1) as id FROM dsnhahang";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String id = rs.getString("id");
				ketQua = "NH".concat(id);
			}
//			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public String TaoMaPhuongTien() {
		String ketQua = null;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "SELECT IFNULL(MAX(id)+1,1) as id FROM dsphuongtien";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String id = rs.getString("id");
				ketQua = "PT".concat(id);
			}
//			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int InsertKhanhSan(KhachSanDTO ks) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO dsks (maks, tenks, giaca, tinhtrang) VALUES ('"
		            + ks.getMaso() + "' , '" + ks.getTendv() + "' , " + ks.getGiaca() + " , "+ 1 + " )";
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
	
	public int InsertNhaHang(NhaHangDTO nh) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO dsnhahang (manh, tennh, giaca,tinhtrang) VALUES ('"
		            + nh.getMaso() + "' , '" + nh.getTendv() + "' , " + nh.getGiaca() + "," + 1 +")";
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
	
	public int InsertPhuongTien(PhuongTienDTO pt) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO dsphuongtien (mapt, tenpt, giaca,tinhtrang) VALUES ('"
		            + pt.getMaso() + "' , '" + pt.getTendv() + "' , " + pt.getGiaca() + "," + 1 +")";
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
	
	
	public int deleteDichVu(KhachSanDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsks SET tinhtrang = 0 WHERE maks = '" + t.getMaso() + "'";
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
//	public int deleteDichVu(KhachSanDTO t) {
//		int kq = 0;
//		
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement st = con.createStatement();
//			String sql = "DELETE FROM dsks WHERE maks = '" + t.getMaso() + "'";
//			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi: " + kq);
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -1;
//		}
//		return kq;
//	}
	
	public int deleteDichVu(NhaHangDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsnhahang SET tinhtrang = 0 WHERE manh = '" + t.getMaso() + "'";
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
//	public int deleteDichVu(NhaHangDTO t) {
//		int kq = 0;
//		
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement st = con.createStatement();
//			String sql = "DELETE FROM dsnhahang WHERE manh = '" + t.getMaso() + "'";
//			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi: " + kq);
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -1;
//		}
//		return kq;
//	}
	public int deleteDichVu(PhuongTienDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsphuongtien SET tinhtrang = 0 WHERE mapt = '" + t.getMaso() + "'";
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
//	public int deleteDichVu(PhuongTienDTO t) {
//		int kq = 0;
//		
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement st = con.createStatement();
//			String sql = "DELETE FROM dsphuongtien WHERE mapt = '" + t.getMaso() + "'";
//			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi: " + kq);
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -1;
//		}
//		return kq;
//	}
	
	public int upDateDichVu(KhachSanDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsks SET tenks='" + t.getTendv() + "',giaca="+ t.getGiaca() + 
				" WHERE maks='" + t.getMaso() + "';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	
	public int upDateDichVu(NhaHangDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsnhahang SET tennh='" + t.getTendv() + "',giaca="+ t.getGiaca() + 
						" WHERE manh='" + t.getMaso() + "';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	
	
	public int upDateDichVu(PhuongTienDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE dsphuongtien SET tenpt='" + t.getTendv() + "',giaca="+ t.getGiaca() + 
					" WHERE mapt='" + t.getMaso() + "';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
}
