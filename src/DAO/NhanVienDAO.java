package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import Util.JDBCUtil;


public class NhanVienDAO {
	public static NhanVienDAO getIntance() {
		return new NhanVienDAO();
	}
	public ArrayList<NhanVienDTO> selectAll() {
		ArrayList<NhanVienDTO> ketQua=new ArrayList<NhanVienDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM nhanvien where tinhtrang = 1";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String manv=rs.getString("manv");
				String honv=rs.getString("honv");
				String tennv=rs.getString("tennv");
				String sdt=rs.getString("sdt");
				Boolean gioitinh=rs.getBoolean("gioitinh");
				String cmnd=rs.getString("cmnd");
				Date ngayvl=rs.getDate("ngayvl");
				Date ngaysinh=rs.getDate("ngaysinh");
				NhanVienDTO nv= new NhanVienDTO(manv, honv, tennv, sdt, cmnd, ngayvl,ngaysinh, gioitinh);
				ketQua.add(nv);
				
				
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public int Insert_DSNhanVien(ArrayList<NhanVienDTO> listNV) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO nhanvien (manv, honv, tennv, sdt, cmnd, ngayvl, ngaysinh, gioitinh, tinhtrang) VALUES ";
			for(NhanVienDTO t: listNV) {
				sql += "('" + t.getManv().toLowerCase() + "' , '" + t.getHonv() + "' , '" + t.getTennv() + "' , '" + t.getSdt() + "' , '"
						+ t.getCmnd() + "' , '" + t.getNgayvl() + "' , '" + t.getNgaysinh() + "' ," + t.getGioitinh() + "," + 1 +"),";				
			}
			sql = sql.substring(0, sql.length()-1);
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
	
	public int InsertNhanVien(NhanVienDTO t) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO nhanvien (manv, honv, tennv, sdt, cmnd, ngayvl, ngaysinh, gioitinh, tinhtrang) VALUES ('"
		            + t.getManv() + "' , '" + t.getHonv() + "' , '" + t.getTennv() + "' , '" + t.getSdt() + "' , '"
		            + t.getCmnd() + "' , '" + t.getNgayvl() + "' , '" + t.getNgaysinh() + "' ," + t.getGioitinh() +","+ 1 +")";
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
	public int upDateNhanVien(NhanVienDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE nhanvien SET honv='" + t.getHonv() + "',tennv='"
					+ t.getTennv() + "',sdt='" + t.getSdt() + "',cmnd='" + t.getCmnd() + "',ngayvl='"
					+ t.getNgayvl() + "',ngaysinh='" + t.getNgaysinh() +  "',gioitinh=" + t.getGioitinh() +
					" WHERE manv='" + t.getManv() + "';";
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
	
	public int deleteNhanVien(NhanVienDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE nhanvien set tinhtrang = 0 WHERE manv = '" + t.getManv() + "'";
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
	
//	public int deleteNhanVien(NhanVienDTO t) {
//		int kq = 0;
//		
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement st = con.createStatement();
//			String sql = "DELETE FROM nhanvien WHERE manv = '" + t.getManv() + "'";
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
		
	public NhanVienDTO getById(String id) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM nhanvien WHERE manv = '" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				NhanVienDTO nv = new NhanVienDTO();
				nv.setManv(rs.getString("manv"));
				nv.setHonv(rs.getString("honv"));
				nv.setTennv(rs.getString("tennv"));
				nv.setSdt(rs.getString("sdt"));
				nv.setCmnd(rs.getString("cmnd"));
				nv.setGioitinh(rs.getBoolean("gioitinh"));
				nv.setNgayvl(rs.getDate("ngayvl"));
				nv.setNgaysinh(rs.getDate("ngaysinh"));
				return nv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
