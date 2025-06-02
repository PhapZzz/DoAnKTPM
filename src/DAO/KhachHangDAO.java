package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class KhachHangDAO {
	public static KhachHangDAO getIntance() {
		return new KhachHangDAO();
	}
	
	public ArrayList<KhachHangDTO> selectAll(){
		ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
		try {
			//Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//Tạo đối tượng
			java.sql.Statement st = con.createStatement();
			//SQL
			String sql = "SELECT * FROM khachhang ";
			System.out.println(sql);
			ResultSet rs= st.executeQuery(sql);
			//Xu ly ket qua roi tra ve
			while(rs.next()) {
				String makh = rs.getString("makh");
				String hokh = rs.getString("hokh");
				String tenkh = rs.getString("tenkh");
				Boolean gioitinh = rs.getBoolean("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
                KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, diachi, sdt, email, gioitinh,ngaysinh);
                result.add(kh);


			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int InsertKhachHang(KhachHangDTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO khachhang (makh,hokh,tenkh,sdt,email,gioitinh,diachi,ngaysinh,tinhtrang)" + " VALUES('"
					+ t.getMakh() + "','" +t.getHokh()+"','"+ t.getTenkh() + "'," + t.getSdt() + ",'" + t.getEmail() + "',"
					+ t.isGioitinh() + ",'" + t.getDiachi() +"','" + t.getNgaysinh()+"'," + 1 +")";
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
	
	public int deleteKhachHang(KhachHangDTO k) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "UPDATE khachhang set tinhtrang = 0 WHERE makh = '" + k.getMakh() + "'";
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
//	public int deleteKhachHang(KhachHangDTO k) {
//		int kq = 0;
//		
//		try {
//			Connection con = JDBCUtil.getConnection();
//			java.sql.Statement st = con.createStatement();
//			String sql = "DELETE FROM khachhang WHERE makh = '" + k.getMakh() + "'";
//			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi: " + kq);
//			JDBCUtil.closeConnection(con);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return -1;
//		}
//		return kq;
//	}
	
	
	public int upDateKhachHang(KhachHangDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "UPDATE khachhang SET hokh='" + t.getHokh() + "',tenkh='"
					+ t.getTenkh() + "',gioitinh=" + t.isGioitinh() + ",diachi='"
					+ t.getDiachi() + "',sdt='" + t.getSdt() +  "',email='" + t.getEmail() +"',ngaysinh='" + t.getNgaysinh()+
					"' WHERE makh='" + t.getMakh() + "';";
			System.out.println(sql);
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
